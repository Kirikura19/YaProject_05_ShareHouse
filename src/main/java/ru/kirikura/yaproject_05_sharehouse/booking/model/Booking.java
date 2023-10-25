package ru.kirikura.yaproject_05_sharehouse.booking.model;

import ru.kirikura.yaproject_05_sharehouse.booking.enums.Status;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;
import ru.kirikura.yaproject_05_sharehouse.user.model.User;

import java.time.LocalDateTime;

public class Booking {
    private long id;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private Item item;
    private User booker;
    private Status status;
}
