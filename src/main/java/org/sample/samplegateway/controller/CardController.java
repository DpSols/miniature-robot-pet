package org.sample.samplegateway.controller;

import lombok.RequiredArgsConstructor;
import org.sample.samplegateway.model.Card;
import org.sample.samplegateway.service.CardService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/card")
public class CardController {
    private final CardService cardService;

    @GetMapping("/")
    public Flux<Card> getAllCard(@RequestParam(required = false) String cardName) {
        Flux<Card> card;

        if (cardName != null && !cardName.isEmpty()) {
            card = cardService.getByCardName(cardName);
        } else {
            card = cardService.getAll();
        }

        return card;
    }

    @PostMapping("/")
    public Mono<Card> createCard(@RequestBody Card card) {
        return cardService.create(card);
    }

    @GetMapping("/{id}")
    public Mono<Card> getCardById(@PathVariable int id) {
        return cardService.getById(id);
    }

    @PutMapping("/")
    public Mono<Card> putCard(@RequestBody Card card) {
        return cardService.update(card);
    }

    @PatchMapping("/")
    public Mono<Card> patchCard(@RequestBody Card card) {
        return cardService.update(card);
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteCard(@PathVariable int id) {
        return cardService.delete(id);
    }
}
