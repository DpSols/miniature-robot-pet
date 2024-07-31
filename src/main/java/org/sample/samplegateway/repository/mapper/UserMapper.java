package org.sample.samplegateway.repository.mapper;

import org.sample.samplegateway.dto.UserDto;
import org.sample.samplegateway.model.User;
import org.sample.samplegateway.repository.entity.UserEntity;

public class UserMapper {
    public static User toModel(UserEntity entity) {
        return new User(
                entity.getId(),
                entity.getName(),
                entity.getAge());
    }

    public static UserEntity toEntity(org.sample.samplegateway.model.User model) {
        return new UserEntity(
                model.getId(),
                model.getName(),
                model.getAge());
    }

    public static UserDto toDto(User model) {
        return new UserDto(
                model.getId(),
                model.getName(),
                model.getAge());
    }
}
