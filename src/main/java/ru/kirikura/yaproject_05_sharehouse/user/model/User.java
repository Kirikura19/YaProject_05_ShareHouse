package ru.kirikura.yaproject_05_sharehouse.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@RequiredArgsConstructor
@Data
public class User {
    @Id
    private int id;
    private String name;
    private String email;

}
