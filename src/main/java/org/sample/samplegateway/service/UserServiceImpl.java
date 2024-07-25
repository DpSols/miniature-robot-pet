package org.sample.samplegateway.service;

import lombok.RequiredArgsConstructor;
import org.sample.samplegateway.comparator.ByUserAgeComparator;
import org.sample.samplegateway.datasource.postgres.UserDatasource;
import org.sample.samplegateway.model.SortingParam;
import org.sample.samplegateway.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDatasource userDatasource;

    @Override
    public Flux<User> getAll() {
        return userDatasource.getAll();
    }

    @Override
    public Mono<User> getById(int id) {
        return userDatasource.getById(id);
    }

    @Override
    public Flux<User> getByName(String Name) {
        return userDatasource.getByName(Name);
    }

    @Override
    public Mono<User> create(User user) {
        if (user.getName().isEmpty() || user.getAge() < 3) {
            return Mono.error(new IllegalArgumentException("Name and age must be provided"));
        }

        return userDatasource.create(user);
    }

    @Override
    public Mono<User> update(User user) {
        if (user.getName().isEmpty() || user.getAge() < 3) {
            return Mono.error(new IllegalArgumentException("Name and age must be provided"));
        }

        return userDatasource.update(user);
    }

    @Override
    public Mono<Void> delete(int id) {
        return userDatasource.delete(id);
    }

    @Override
    public Flux<User> getAll(String name, SortingParam sortingParam) {
        Flux<User> users;

        if (name != null && !name.isEmpty()) {
            users = userDatasource.getByName(name);
        }else {
            users = userDatasource.getAll();
        }

        if (sortingParam != null) {
            users = users.sort(new ByUserAgeComparator(sortingParam));
        }
        return users;
    }
}
