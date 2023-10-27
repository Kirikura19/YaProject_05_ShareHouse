package ru.kirikura.yaproject_05_sharehouse.booking.dto;

import lombok.Builder;
import ru.kirikura.yaproject_05_sharehouse.booking.enums.Status;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;

import java.time.LocalDateTime;

@Builder
public class BookingDefaultDto {
    private long id;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private Item item;
    private Person person;
    private Status status;
}
