package ru.kirikura.yaproject_05_sharehouse.comment.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kirikura.yaproject_05_sharehouse.comment.model.Comment;
import ru.kirikura.yaproject_05_sharehouse.comment.service.CommentService;

@RestController
@AllArgsConstructor
@RequestMapping("/items")
public class CommentController {
    private static final String PERSON_ID = "X-Sharer-Person-Id";
    CommentService commentService;

    @PostMapping("/{itemId}/comment")
    public Comment addComment(@RequestHeader(PERSON_ID) long personId, @PathVariable long itemId, @RequestBody String comment) {
        return commentService.addComment(personId, itemId, comment);
    }
}
