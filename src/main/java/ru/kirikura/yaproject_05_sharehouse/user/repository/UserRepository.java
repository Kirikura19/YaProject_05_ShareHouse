package ru.kirikura.yaproject_05_sharehouse.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirikura.yaproject_05_sharehouse.user.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
