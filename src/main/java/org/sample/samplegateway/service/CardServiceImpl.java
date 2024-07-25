package org.sample.samplegateway.service;

import lombok.RequiredArgsConstructor;
import org.sample.samplegateway.datasource.postgres.CardDatasource;
import org.sample.samplegateway.datasource.postgres.UserDatasource;
import org.sample.samplegateway.model.Card;
import org.sample.samplegateway.model.SortingParam;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final UserDatasource userDatasource;
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
    public Flux<Card> getByCardHolder(int holderId) {
        return cardDatasource.getByCardHolder(holderId);
    }

    @Override
    public Flux<Card> getByCardHolderAndCardName(int holderId, String name) {
        return null;
    }

    @Override
    public Mono<Card> create(Card card) {
        return userDatasource.existsById(card.getUserId())
                .flatMap(exists -> {
                    if (!exists) {
                        return Mono.error(new IllegalArgumentException("User with id " + card.getUserId() + " does not exist"));
                    }
                    return cardDatasource.create(card);
                });
    }

    @Override
    public Mono<Card> update(Card card) {
        if (card.getUserId() == 0) {
            return cardDatasource.update(card);
        }

        return userDatasource.existsById(card.getUserId())
                .flatMap(exists -> {
                    if (!exists) {
                        return Mono.error(new IllegalArgumentException("User with id " + card.getUserId() + " does not exist"));
                    }

                    return cardDatasource.update(card);
                });
    }

    @Override
    public Mono<Void> delete(int id) {
        return cardDatasource.delete(id);
    }

    @Override
    public Flux<Card> getAll(Integer holderId, String cardName, SortingParam sortingParam) {
        Flux<Card> card;

        if (holderId != null) {
            card = cardDatasource.getByCardHolder(holderId)
                    .filter(c -> cardName == null || cardName.isEmpty() || c.getName().equals(cardName))
                    .switchIfEmpty(Flux.error(new Exception("No card found for holder id " + holderId)));
        } else if (cardName != null && !cardName.isEmpty()) {
            card = cardDatasource.getByCardName(cardName)
                    .switchIfEmpty(Flux.error(new Exception("No card found with name " + cardName)));
        } else {
            card = cardDatasource.getAll();
        }

        card.sort();

        return null;
    }
}
