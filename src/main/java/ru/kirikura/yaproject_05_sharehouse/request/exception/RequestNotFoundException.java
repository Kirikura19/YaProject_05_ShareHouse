package ru.kirikura.yaproject_05_sharehouse.request.exception;

public class RequestNotFoundException extends RuntimeException {
    public RequestNotFoundException(String msg) {
        super(msg);
    }
}
