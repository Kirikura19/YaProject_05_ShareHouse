package ru.kirikura.yaproject_05_sharehouse.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class BookingRegDto {
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
    private Long itemId;

}
