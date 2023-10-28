package ru.kirikura.yaproject_05_sharehouse.booking.exception;

public class BookingNotFoundException extends RuntimeException {
    public BookingNotFoundException(String msg) {
        super(msg);
    }
}
