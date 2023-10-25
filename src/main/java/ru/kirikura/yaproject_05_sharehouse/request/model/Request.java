package ru.kirikura.yaproject_05_sharehouse.request.model;

import ru.kirikura.yaproject_05_sharehouse.user.model.User;

import java.time.LocalDateTime;

public class Request {
    private long id;
    private String description;
    private User requestor;
    private LocalDateTime created;

}
