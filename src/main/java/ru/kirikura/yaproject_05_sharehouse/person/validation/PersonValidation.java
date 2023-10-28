package ru.kirikura.yaproject_05_sharehouse.person.validation;

import ru.kirikura.yaproject_05_sharehouse.person.exception.PersonNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;
import ru.kirikura.yaproject_05_sharehouse.person.repository.PersonRepository;

public class PersonValidation {
    static PersonRepository personRepository;
    public static Person checkIsUserExists(long personId) {
        return personRepository.findById(personId).orElseThrow(()
                -> new PersonNotFoundException("User is not exists"));
    }
}
