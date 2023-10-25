package ru.kirikura.yaproject_05_sharehouse.user.mapper;

import ru.kirikura.yaproject_05_sharehouse.user.dto.UserDto;
import ru.kirikura.yaproject_05_sharehouse.user.model.User;

public interface UserMapper {
    UserDto toUserDto(User user);
}
