package ru.kirikura.yaproject_05_sharehouse.request.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import ru.kirikura.yaproject_05_sharehouse.user.model.User;

import java.time.LocalDateTime;

@Entity
@RequiredArgsConstructor
@Data
public class Request {
    @Id
    private long id;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requestor_id", nullable = false)
    private User requestor;
    private LocalDateTime created;
}
