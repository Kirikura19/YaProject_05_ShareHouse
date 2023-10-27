package ru.kirikura.yaproject_05_sharehouse.booking.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import ru.kirikura.yaproject_05_sharehouse.booking.enums.Status;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;
import ru.kirikura.yaproject_05_sharehouse.user.model.User;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class BookingRegDto {
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private Long itemId;

}
