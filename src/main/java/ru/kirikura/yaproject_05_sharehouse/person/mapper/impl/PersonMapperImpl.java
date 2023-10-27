package ru.kirikura.yaproject_05_sharehouse.person.mapper.impl;

import ru.kirikura.yaproject_05_sharehouse.person.dto.PersonDto;
import ru.kirikura.yaproject_05_sharehouse.person.mapper.PersonMapper;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;

public class PersonMapperImpl implements PersonMapper {
    @Override
    public PersonDto toUserDto(Person person) {
        return new PersonDto(person.getName());
    }
}
