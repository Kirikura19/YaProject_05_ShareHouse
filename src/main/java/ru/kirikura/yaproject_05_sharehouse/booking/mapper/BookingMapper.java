package ru.kirikura.yaproject_05_sharehouse.booking.mapper;

import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingDefaultDto;
import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingItemDateDto;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;

public interface BookingMapper {
    BookingDefaultDto toBookingDefaultDto(Booking booking);

    BookingItemDateDto toBookingItemDateDto(Booking booking);

}
