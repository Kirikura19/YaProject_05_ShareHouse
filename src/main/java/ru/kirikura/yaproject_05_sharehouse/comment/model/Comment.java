package ru.kirikura.yaproject_05_sharehouse.comment.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;
    @ManyToOne()
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;
    @ManyToOne()
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
    private LocalDateTime created;
}
