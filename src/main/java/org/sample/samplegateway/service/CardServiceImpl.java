package org.sample.samplegateway.service;

import lombok.RequiredArgsConstructor;
import org.sample.samplegateway.datasource.postgres.CardDatasource;
import org.sample.samplegateway.model.Card;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final CardDatasource cardDatasource;

    @Override
    public Flux<Card> getAll() {
        return cardDatasource.getAll();
    }

    @Override
    public Mono<Card> getById(int id) {
        return cardDatasource.getById(id);
    }

    @Override
    public Flux<Card> getByCardNumber(String cardNumber) {
        return cardDatasource.getByCardNumber(cardNumber);
    }

    @Override
    public Flux<Card> getByCardName(String cardName) {
        return cardDatasource.getByCardName(cardName);
    }

    @Override
    public Mono<Card> create(Card card) {
        return cardDatasource.create(card);
    }

    @Override
    public Mono<Card> update(Card card) {
        return cardDatasource.update(card);
    }

    @Override
    public Mono<Void> delete(int id) {
        return cardDatasource.delete(id);
    }
}
