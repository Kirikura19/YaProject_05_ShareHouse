package ru.kirikura.yaproject_05_sharehouse.request.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirikura.yaproject_05_sharehouse.request.model.Request;

public interface RequestRepository extends JpaRepository<Request, Long> {
}