package ru.kirikura.yaproject_05_sharehouse.person.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;
import ru.kirikura.yaproject_05_sharehouse.person.service.PersonServiceJPA;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/persons")
public class PersonController {
    PersonServiceJPA personService;

    @GetMapping()
    public List<Person> findAll() {
        return personService.findAll();
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable long id) {
        return personService.findById(id);
    }

    @PostMapping
    public Person save(@RequestBody Person person) {
        return personService.save(person);
    }

    @PatchMapping
    public Person update(Person person) {
        return personService.update(person);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        personService.deleteById(id);
    }

    @DeleteMapping
    public void delete(@RequestBody Person person) {
        personService.delete(person);
    }
}
