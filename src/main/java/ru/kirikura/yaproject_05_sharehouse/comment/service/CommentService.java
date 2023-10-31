package ru.kirikura.yaproject_05_sharehouse.comment.service;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;
import ru.kirikura.yaproject_05_sharehouse.comment.model.Comment;
import ru.kirikura.yaproject_05_sharehouse.comment.repository.CommentRepository;
import ru.kirikura.yaproject_05_sharehouse.item.validation.ItemValidation;
import ru.kirikura.yaproject_05_sharehouse.person.validation.PersonValidation;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
@Data
public class CommentService {
    CommentRepository commentRepository;
    ItemValidation itemValidation;
    PersonValidation personValidation;

    public Comment addComment(long personId, long itemId, String txt) {
        Comment comment = Comment
                .builder()
                .text(txt)
                .item(itemValidation.checkIsItemExists(itemId))
                .person(personValidation.checkIsUserExists(personId))
                .created(LocalDateTime.now())
                .build();
        return commentRepository.save(comment);
    }
}
