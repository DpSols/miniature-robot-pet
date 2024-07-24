package org.sample.samplegateway.datasource.postgres;

import org.sample.samplegateway.model.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CardDatasource {
    Flux<Card> getAll();
    Mono<Card> getById(int id);
    Flux<Card> getByCardNumber(String cardNumber);
    Flux<Card> getByCardName(String cardNumber);
    Mono<Card> create(Card card);
    Mono<Card> update(Card card);
    Mono<Void> delete(int id);
}
