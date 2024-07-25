package org.sample.samplegateway.service;

import org.sample.samplegateway.model.Card;
import org.sample.samplegateway.model.SortingParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CardService {
    Flux<Card> getAll();

    Mono<Card> getById(int id);

    Flux<Card> getByCardNumber(String cardNumber);

    Flux<Card> getByCardName(String cardName);

    Flux<Card> getByCardHolder(int holderId);

    Flux<Card> getByCardHolderAndCardName(int holderId, String name);

    Mono<Card> create(Card card);

    Mono<Card> update(Card card);

    Mono<Void> delete(int id);

    Flux<Card> getAll(Integer holderId, String cardName, SortingParam sortingParam);
}
