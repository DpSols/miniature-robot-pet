package org.sample.samplegateway.service;

import lombok.RequiredArgsConstructor;
import org.sample.samplegateway.datasource.postgres.CardDatasource;
import org.sample.samplegateway.datasource.postgres.UserDatasource;
import org.sample.samplegateway.dto.CardDto;
import org.sample.samplegateway.dto.GetCustomerCardResponse;
import org.sample.samplegateway.dto.UserDto;
import org.sample.samplegateway.model.Card;
import org.sample.samplegateway.model.SortingParam;
import org.sample.samplegateway.repository.mapper.CardMapper;
import org.sample.samplegateway.repository.mapper.UserMapper;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
    private final UserDatasource userDatasource;
    private final CardDatasource cardDatasource;

    @Override
    public Flux<CardDto> getAll() {
        return cardDatasource.getAll()
                .map(CardMapper::toDto);
    }

    @Override
    public Mono<CardDto> getById(int id) {
        return cardDatasource.getById(id)
                .map(CardMapper::toDto);
    }

    @Override
    public Flux<CardDto> getByCardNumber(String cardNumber) {
        return cardDatasource.getByCardNumber(cardNumber)
                .map(CardMapper::toDto);
    }

    @Override
    public Flux<CardDto> getByCardName(String cardName) {
        return cardDatasource.getByCardName(cardName)
                .map(CardMapper::toDto);
    }

    @Override
    public Mono<GetCustomerCardResponse> getByCardHolder(int holderId) {
        Mono<UserDto> user = userDatasource.getById(holderId)
                .switchIfEmpty(Mono.error(new Exception("No user found for id " + holderId)))
                .map(UserMapper::toDto);

        Flux<CardDto> cards = cardDatasource.getByCardHolder(holderId)
                .map(CardMapper::toDto);

        return user.flatMap(userDto -> cards.collectList()
                        .map(cardDtos -> new GetCustomerCardResponse(userDto, cardDtos)));
    }

    @Override
    public Flux<GetCustomerCardResponse> getByCardHolderAndCardName(int holderId, String name) {
        return null;
    }

    @Override
    public Mono<CardDto> create(CardDto cardDto) {
//        return userDatasource.existsById(card.getUserId())
//                .flatMap(exists -> {
//                    if (!exists) {
//                        return Mono.error(new IllegalArgumentException("User with id " + card.getUserId() + " does not exist"));
//                    }
//                    return cardDatasource.create(card);
//                });

        return cardDatasource.create(CardMapper.toModel(cardDto))
                .map(CardMapper::toDto);
    }

    @Override
    public Mono<CardDto> update(Card card) {
        if (card.getUserId() == 0) {
            return cardDatasource.update(card)
                    .map(CardMapper::toDto);
        }

        return userDatasource.existsById(card.getUserId())
                .flatMap(exists -> {
                    if (!exists) {
                        return Mono.error(new IllegalArgumentException("User with id " + card.getUserId() + " does not exist"));
                    }

                    return cardDatasource.update(card)
                            .map(CardMapper::toDto);
                });
    }

    @Override
    public Mono<Void> delete(int id) {
        return cardDatasource.delete(id);
    }

    @Override
    public Mono<GetCustomerCardResponse> getAll(Integer holderId, String cardName, SortingParam sortingParam) {
        Flux<CardDto> cards;

        Mono<UserDto> user = userDatasource.getById(holderId)
                .switchIfEmpty(Mono.error(new Exception("No user found for id " + holderId)))
                .map(UserMapper::toDto);

        if (holderId != null) {
            cards = cardDatasource.getByCardHolder(holderId)
                    .filter(c -> cardName == null || cardName.isEmpty() || c.getName().equals(cardName))
                    .map(CardMapper::toDto)
                    .switchIfEmpty(Flux.error(new Exception("No card found for holder id " + holderId)));
        } else if (cardName != null && !cardName.isEmpty()) {
            cards = cardDatasource.getByCardName(cardName)
                    .map(CardMapper::toDto)
                    .switchIfEmpty(Flux.error(new Exception("No card found with name " + cardName)));
        } else {
            cards = cardDatasource.getAll()
                    .map(CardMapper::toDto);
        }

        // todo sorting
        return user.flatMap(userDto -> cards.collectList()
                        .map(cardDtos -> new GetCustomerCardResponse(userDto, cardDtos)));
    }
}
