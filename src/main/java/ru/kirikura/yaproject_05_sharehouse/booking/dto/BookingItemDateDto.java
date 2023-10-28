package ru.kirikura.yaproject_05_sharehouse.booking.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
public class BookingItemDateDto {
    private long id;
    private LocalDateTime timeStart;
    private LocalDateTime timeEnd;
}
