package ru.kirikura.yaproject_05_sharehouse.booking.mapper;

import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingDefaultDto;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;

public interface BookerMapper {
    BookingDefaultDto toBookingDefaultDto(Booking booking);

}
