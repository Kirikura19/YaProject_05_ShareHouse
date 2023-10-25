package ru.kirikura.yaproject_05_sharehouse.user.mapper.impl;

import ru.kirikura.yaproject_05_sharehouse.user.dto.UserDto;
import ru.kirikura.yaproject_05_sharehouse.user.mapper.UserMapper;
import ru.kirikura.yaproject_05_sharehouse.user.model.User;

public class UserMapperImpl implements UserMapper {
    @Override
    public UserDto toUserDto(User user) {
        return new UserDto(user.getName());
    }
}
