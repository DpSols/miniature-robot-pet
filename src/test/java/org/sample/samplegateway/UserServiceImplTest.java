package org.sample.samplegateway;

import org.mockito.Mockito;
import org.sample.samplegateway.datasource.postgres.UserDatasource;
import org.sample.samplegateway.datasource.postgres.UserDatasourceImpl;
import org.sample.samplegateway.model.SortingParam;
import org.sample.samplegateway.model.User;
import org.sample.samplegateway.service.UserServiceImpl;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

public class UserServiceImplTest {

    private UserDatasource userDatasource;

    @BeforeMethod
    public void setUpBeforeMethod() {
        userDatasource = Mockito.mock(UserDatasourceImpl.class);
    }

    @Test
    public void testGetAll() {
        Mockito.when(userDatasource.getAll())
                .thenReturn(Flux.just(
                        new User(1, "John", 20),
                        new User(2, "Jane", 21),
                        new User(3, "Doe", 22))
                );
//        Mockito.spy().stub

        UserServiceImpl userService = new UserServiceImpl(userDatasource);

        // verify that the service returns the expected users
        StepVerifier.create(userService.getAll())
                .expectNext(new User(1, "John", 20))
                .expectNext(new User(2, "Jane", 21))
                .expectNext(new User(3, "Doe", 22))
                .verifyComplete();

        // verify that userService returns equal number of users as userDatasource
        StepVerifier.create(userService.getAll())
                .expectNextCount(3)
                .verifyComplete();
    }

//    @Test
//    public void testGetAllFiltered() {
//        String testName = "John";
//        Mockito.when(userDatasource.getByName(testName))
//                .thenReturn(Flux.just(
//                        new User(1, testName, 20),
//                        new User(1, testName, 23),
//                        new User(2, testName, 21))
//                );
//
//        UserServiceImpl userService = new UserServiceImpl(userDatasource);
//
//        // verify that userService returns equal number of users as userDatasource
//        StepVerifier.create(userService.getAll(testName, SortingParam.ASCENDING))
//                .
//                .expectNextCount(2)
//                .verifyComplete();
//    }
}