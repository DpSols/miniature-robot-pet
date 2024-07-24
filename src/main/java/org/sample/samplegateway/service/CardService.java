package org.sample.samplegateway.service;

import org.sample.samplegateway.model.Card;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CardService {
    Flux<Card> getAll();

    Mono<Card> getById(int id);

    Flux<Card> getByCardNumber(String cardNumber);

    Flux<Card> getByCardName(String cardName);

    Mono<Card> create(Card card);

    Mono<Card> update(Card card);

    Mono<Void> delete(int id);
}
