package ru.kirikura.yaproject_05_sharehouse.item.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;
import ru.kirikura.yaproject_05_sharehouse.request.model.Request;

@Entity
@RequiredArgsConstructor
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;
    private Boolean available;
    @ManyToOne()
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
    @ManyToOne()
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;
}
