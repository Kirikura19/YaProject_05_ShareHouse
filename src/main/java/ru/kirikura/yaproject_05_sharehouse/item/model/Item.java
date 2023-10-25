package ru.kirikura.yaproject_05_sharehouse.item.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.kirikura.yaproject_05_sharehouse.request.model.Request;
import ru.kirikura.yaproject_05_sharehouse.user.model.User;

@Data
@AllArgsConstructor
public class Item {
    private long id;
    private String name;
    private String description;
    private Boolean available;
    private User owner;
    private Request request;
}
