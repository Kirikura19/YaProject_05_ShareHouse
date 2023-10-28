package ru.kirikura.yaproject_05_sharehouse.person.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kirikura.yaproject_05_sharehouse.person.exception.PersonNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;
import ru.kirikura.yaproject_05_sharehouse.person.repository.PersonRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PersonServiceJPA {
    PersonRepository personRepository;

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person findById(long personId) {
        return personRepository.findById(personId).orElseThrow(()
                -> new PersonNotFoundException("Person not found"));
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
