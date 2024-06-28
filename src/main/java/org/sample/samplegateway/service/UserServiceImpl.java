package org.sample.samplegateway.service;

import lombok.RequiredArgsConstructor;
import org.sample.samplegateway.datasource.postgres.UserDatasource;
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
        return userDatasource.create(user);
    }

    @Override
    public Mono<User> update(User user) {
        return userDatasource.update(user);
    }

    @Override
    public Mono<Void> delete(int id) {
        return userDatasource.delete(id);
    }
}