package ru.kirikura.yaproject_05_sharehouse.booking.validation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.kirikura.yaproject_05_sharehouse.booking.exception.BookingNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;
import ru.kirikura.yaproject_05_sharehouse.booking.repository.BookingRepository;

@Component
@AllArgsConstructor
public class BookingValidation {
    BookingRepository bookingRepository;

    public Booking checkIsBookingExists(long bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow(()
                -> new BookingNotFoundException("Booking is not exists"));
    }
}
