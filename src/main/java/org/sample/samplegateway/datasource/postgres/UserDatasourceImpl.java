package org.sample.samplegateway.datasource.postgres;

import lombok.RequiredArgsConstructor;
import org.sample.samplegateway.repository.UserRepository;
import org.sample.samplegateway.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserDatasourceImpl implements UserDatasource{
    private final UserRepository userRepository;

    @Override
    public Flux<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public Flux<User> getByName(String Name) {
        return userRepository.findByName(Name);
    }

    @Override
    public Mono<User> create(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<User> update(User user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<Void> delete(int id) {
        return userRepository.deleteById(id);
    }
}
