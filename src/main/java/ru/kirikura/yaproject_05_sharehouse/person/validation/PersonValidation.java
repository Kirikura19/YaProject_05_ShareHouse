package ru.kirikura.yaproject_05_sharehouse.person.validation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.kirikura.yaproject_05_sharehouse.person.exception.PersonNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;
import ru.kirikura.yaproject_05_sharehouse.person.repository.PersonRepository;

@AllArgsConstructor
@Component
public class PersonValidation {
    PersonRepository personRepository;

    public Person checkIsUserExists(long personId) {
        return personRepository.findById(personId).orElseThrow(()
                -> new PersonNotFoundException("User is not exists"));
    }
}
