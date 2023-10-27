package ru.kirikura.yaproject_05_sharehouse.person.mapper;

import ru.kirikura.yaproject_05_sharehouse.person.dto.PersonDto;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;

public interface PersonMapper {
    PersonDto toUserDto(Person person);
}
