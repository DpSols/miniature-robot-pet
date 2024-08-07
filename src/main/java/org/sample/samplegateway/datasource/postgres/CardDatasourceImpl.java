package org.sample.samplegateway.datasource.postgres;

import lombok.RequiredArgsConstructor;
import org.sample.samplegateway.model.Card;
import org.sample.samplegateway.repository.CardRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class CardDatasourceImpl implements CardDatasource {
    private final CardRepository cardRepository;

    @Override
    public Flux<Card> getAll() {
        return cardRepository.findAll();
    }

    @Override
    public Mono<Card> getById(int id) {
        return cardRepository.findById(id);
    }

    @Override
    public Flux<Card> getByCardNumber(String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber);
    }

    @Override
    public Flux<Card> getByCardHolder(int holderId) {
        return cardRepository.findByCardHolder(holderId);
    }

    @Override
    public Flux<Card> getByCardName(String cardName) {
        return cardRepository.findByCardName(cardName);
    }

    @Override
    public Mono<Card> create(Card card) {
        if (!card.getExpiry().matches("^[0-9]{2}/[0-9]{2}$")) {
            return Mono.error(new IllegalArgumentException("Expiry date must be in MM/YY format"));
        }
        return cardRepository.save(card);
    }

    @Override
    public Mono<Card> update(Card card) {
        if (!card.getExpiry().matches("^[0-9]{2}/[0-9]{2}$")) {
            return Mono.error(new IllegalArgumentException("Expiry date must be in MM/YY format"));
        }

        return cardRepository.updateCard(
                card.getId(),
                card.getUserId(),
                card.getNumber(),
                card.getExpiry(),
                card.getName(),
                card.getBalance()
        );
    }

    @Override
    public Mono<Void> delete(int id) {
        return cardRepository.deleteById(id);
    }
}
