package ru.kirikura.yaproject_05_sharehouse.user.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
