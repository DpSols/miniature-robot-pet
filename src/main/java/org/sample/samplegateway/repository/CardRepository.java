package org.sample.samplegateway.repository;

import org.sample.samplegateway.model.Card;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDate;

@Repository
public interface CardRepository extends ReactiveCrudRepository<Card, Integer> {
    @Query("SELECT * FROM cards WHERE name = :name")
    public Flux<Card> findByCardName(String name);

    @Query("SELECT * FROM cards WHERE number = :number")
    public Flux<Card> findByCardNumber(String number);

    @Query("UPDATE cards SET fk_user_id = :userId, number = :number, expiry = :expiry, name = :name, balance = :balance WHERE id = :id")
    public Mono<Card> updateCard(int id, int userId, String number, String expiry, String name, int balance);
    ;
}
