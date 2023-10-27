package ru.kirikura.yaproject_05_sharehouse.booking.model;

import jakarta.persistence.*;
import lombok.*;
import ru.kirikura.yaproject_05_sharehouse.booking.enums.Status;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;
import ru.kirikura.yaproject_05_sharehouse.user.model.User;

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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User booker;
    @Enumerated(EnumType.STRING)
    private Status status;
}
