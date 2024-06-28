package org.sample.samplegateway.repository;

import org.sample.samplegateway.model.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer> {
//    @Query("INSERT INTO user_dto (user_age, user_name) VALUES ($1, $2)")
//    public Mono<User> save(User user);
    @Query("SELECT * FROM user_dto WHERE user_name = :name")
    public Flux<User> findByName(String name);
}
