package ru.kirikura.yaproject_05_sharehouse.booking.mapper.impl;

import org.springframework.stereotype.Component;
import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingDefaultDto;
import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingItemDateDto;
import ru.kirikura.yaproject_05_sharehouse.booking.mapper.BookingMapper;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;

@Component
public class BookingMapperImpl implements BookingMapper {
    @Override
    public BookingDefaultDto toBookingDefaultDto(Booking booking) {
        return BookingDefaultDto.builder()
                .id(booking.getId())
                .timeStart(booking.getTimeStart())
                .timeEnd(booking.getTimeEnd())
                .item(booking.getItem())
                .person(booking.getPerson())
                .status(booking.getStatus()).build();
    }

    @Override
    public BookingItemDateDto toBookingItemDateDto(Booking booking) {
        return BookingItemDateDto
                .builder()
                .id(booking.getId())
                .timeStart(booking.getTimeStart())
                .timeEnd(booking.getTimeEnd())
                .build();
    }
}
