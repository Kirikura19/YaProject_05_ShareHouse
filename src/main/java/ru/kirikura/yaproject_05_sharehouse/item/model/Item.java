package ru.kirikura.yaproject_05_sharehouse.item.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.kirikura.yaproject_05_sharehouse.request.model.Request;
import ru.kirikura.yaproject_05_sharehouse.user.model.User;

@Entity
@RequiredArgsConstructor
@Data
public class Item {
    @Id
    private long id;
    private String name;
    private String description;
    private Boolean available;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id", nullable = false)
    private Request request;
}
