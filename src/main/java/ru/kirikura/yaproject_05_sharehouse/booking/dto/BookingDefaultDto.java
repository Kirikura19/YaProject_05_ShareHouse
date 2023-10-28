package ru.kirikura.yaproject_05_sharehouse.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.kirikura.yaproject_05_sharehouse.booking.enums.Status;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class BookingDefaultDto {
    private long id;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private Item item;
    private Person person;
    private Status status;
}
