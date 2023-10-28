package ru.kirikura.yaproject_05_sharehouse.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
