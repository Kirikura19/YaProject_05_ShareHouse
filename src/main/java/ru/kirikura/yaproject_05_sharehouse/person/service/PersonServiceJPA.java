package ru.kirikura.yaproject_05_sharehouse.person.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;
import ru.kirikura.yaproject_05_sharehouse.person.repository.PersonRepository;
import ru.kirikura.yaproject_05_sharehouse.person.validation.PersonValidation;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceJPA {
    PersonRepository personRepository;
    PersonValidation personValidation;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(long personId) {
        return personValidation.checkIsUserExists(personId);
    }

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public Person update(Person person) {
        return personRepository.save(person);
    }

    public void deleteById(long id) {
        personRepository.deleteById(id);
    }

    public void delete(Person person) {
        personRepository.delete(person);
    }
}
