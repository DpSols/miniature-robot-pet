package org.sample.samplegateway.service;

import org.sample.samplegateway.dto.CardDto;
import org.sample.samplegateway.dto.GetCustomerCardResponse;
import org.sample.samplegateway.model.SortingParam;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CardService {
    Flux<CardDto> getAll();

    Mono<CardDto> getById(int id);

    Flux<CardDto> getByCardNumber(String cardNumber);

    Flux<CardDto> getByCardName(String cardName);

    Mono<GetCustomerCardResponse> getByCardHolder(int holderId);

    Flux<GetCustomerCardResponse> getByCardHolderAndCardName(int holderId, String name);

    Mono<CardDto> create(CardDto card);

    Mono<CardDto> update(CardDto card);

    Mono<Void> delete(int id);

    Mono<GetCustomerCardResponse> getAll(Integer holderId, String cardName, SortingParam sortingParam);
}
