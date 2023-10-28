package ru.kirikura.yaproject_05_sharehouse.person.exception;

public class PersonNotFoundException extends RuntimeException {
    public PersonNotFoundException(String msg) {
        super(msg);
    }
}
