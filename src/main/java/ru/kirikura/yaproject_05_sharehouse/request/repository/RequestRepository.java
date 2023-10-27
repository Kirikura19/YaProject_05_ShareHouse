package ru.kirikura.yaproject_05_sharehouse.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirikura.yaproject_05_sharehouse.request.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
}