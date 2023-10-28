package ru.kirikura.yaproject_05_sharehouse.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;
import ru.kirikura.yaproject_05_sharehouse.request.model.Request;

@Builder
@AllArgsConstructor
public class ItemDefaultDto {
    private long id;
    private String name;
    private String description;
    private Boolean available;
    private Person person;
    private Request request;
}
