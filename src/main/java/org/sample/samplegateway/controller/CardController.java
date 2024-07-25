package org.sample.samplegateway.controller;

import lombok.RequiredArgsConstructor;
import org.sample.samplegateway.model.Card;
import org.sample.samplegateway.model.SortingParam;
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
    public Flux<Card> getAllCard(@RequestParam(required = false) String cardName, @RequestParam(required = false) Integer holder_id, @RequestParam(required = false) SortingParam sortingParam) {

        return cardService.getAll(holder_id, cardName, sortingParam);
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
