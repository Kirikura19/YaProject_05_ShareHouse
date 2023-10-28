package ru.kirikura.yaproject_05_sharehouse.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kirikura.yaproject_05_sharehouse.request.model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Long> {
}