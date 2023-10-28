package ru.kirikura.yaproject_05_sharehouse.booking.validation;

import ru.kirikura.yaproject_05_sharehouse.booking.exception.BookingNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;
import ru.kirikura.yaproject_05_sharehouse.booking.repository.BookingRepository;
import ru.kirikura.yaproject_05_sharehouse.person.exception.PersonNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;

public class BookingValidation {
    static BookingRepository bookingRepository;
    public static Booking checkIsBookingExists(long bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow(()
                -> new BookingNotFoundException("Booking is not exists"));
    }
}
