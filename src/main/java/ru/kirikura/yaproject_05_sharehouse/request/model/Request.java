package ru.kirikura.yaproject_05_sharehouse.request.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;

import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Data
public class Request {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String description;
    @ManyToOne()
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
    private LocalDateTime created;
}
