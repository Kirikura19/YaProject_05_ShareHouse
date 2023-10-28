package ru.kirikura.yaproject_05_sharehouse.booking.exception;

public class BookingAccessDenied extends RuntimeException {
    public BookingAccessDenied(String msg) {
        super(msg);
    }
}
