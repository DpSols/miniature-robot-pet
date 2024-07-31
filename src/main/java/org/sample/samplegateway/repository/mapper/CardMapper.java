package org.sample.samplegateway.repository.mapper;

import org.sample.samplegateway.dto.CardDto;
import org.sample.samplegateway.model.Card;
import org.sample.samplegateway.repository.entity.CardEntity;

public class CardMapper {
    public static Card toModel(CardEntity entity) {
        return new Card(
                entity.getId(),
                entity.getUserId(),
                entity.getNumber(),
                entity.getExpiry(),
                entity.getName(),
                entity.getBalance());
    }

    public static Card toModel(CardDto entity) {
        return new Card(
                entity.getId(),
                entity.getUserId(),
                entity.getNumber(),
                entity.getExpiry(),
                entity.getName(),
                entity.getBalance());
    }

    public static CardEntity toEntity(CardDto model) {
        return new CardEntity(
                model.getId(),
                model.getUserId(),
                model.getNumber(),
                model.getExpiry(),
                model.getName(),
                model.getBalance());
    }

    public static CardDto toDto(Card model) {
        return new CardDto(
                model.getId(),
                model.getUserId(),
                model.getNumber(),
                model.getExpiry(),
                model.getName(),
                model.getBalance());
    }
}
