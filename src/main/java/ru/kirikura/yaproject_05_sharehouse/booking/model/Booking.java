package ru.kirikura.yaproject_05_sharehouse.booking.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.kirikura.yaproject_05_sharehouse.booking.enums.Status;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "time_start")
    private LocalDateTime timeStart;
    @Column(name = "time_end")
    private LocalDateTime timeEnd;
    @ManyToOne()
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;
    //booker
    @ManyToOne()
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;
    @Enumerated(EnumType.STRING)
    private Status status;
}
