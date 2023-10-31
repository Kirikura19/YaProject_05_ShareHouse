package ru.kirikura.yaproject_05_sharehouse.comment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kirikura.yaproject_05_sharehouse.comment.model.Comment;

import java.util.Set;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
    Set<Comment> findAllByItem_Id(long itemId);

}