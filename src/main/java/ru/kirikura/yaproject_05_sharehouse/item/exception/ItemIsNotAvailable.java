package ru.kirikura.yaproject_05_sharehouse.item.exception;

public class ItemIsNotAvailable extends RuntimeException {
    public ItemIsNotAvailable(String msg) {
        super(msg);
    }
}