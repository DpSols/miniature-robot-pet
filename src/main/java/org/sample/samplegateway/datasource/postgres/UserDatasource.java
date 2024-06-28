package org.sample.samplegateway.datasource.postgres;

import org.sample.samplegateway.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserDatasource {

    Flux<User> getAll();
    Mono<User> getById(int id);
    Flux<User> getByName(String Name);
    Mono<User> create(User user);
    Mono<User> update(User user);
    Mono<Void> delete(int id);
}
