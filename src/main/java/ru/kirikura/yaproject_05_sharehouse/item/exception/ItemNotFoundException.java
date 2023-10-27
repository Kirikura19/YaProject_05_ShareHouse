package ru.kirikura.yaproject_05_sharehouse.item.exception;

public class ItemNotFoundException extends RuntimeException {
    public ItemNotFoundException(String msg) {
        super(msg);
    }
}
