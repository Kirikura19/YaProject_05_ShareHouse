package ru.kirikura.yaproject_05_sharehouse.booking.mapper.impl;

import org.springframework.stereotype.Component;
import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingDefaultDto;
import ru.kirikura.yaproject_05_sharehouse.booking.mapper.BookerMapper;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;

@Component
public class BookerMapperImpl implements BookerMapper {
    @Override
    public BookingDefaultDto toBookingDefaultDto(Booking booking) {
        return BookingDefaultDto.builder()
                .timeStart(booking.getTimeStart())
                .timeEnd(booking.getTimeEnd())
                .item(booking.getItem())
                .person(booking.getPerson())
                .status(booking.getStatus()).build();
    }
}
