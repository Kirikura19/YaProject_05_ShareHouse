package ru.kirikura.yaproject_05_sharehouse.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
