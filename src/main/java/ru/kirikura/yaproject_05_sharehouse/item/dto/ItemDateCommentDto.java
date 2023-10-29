package ru.kirikura.yaproject_05_sharehouse.item.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingItemDateDto;
import ru.kirikura.yaproject_05_sharehouse.comment.model.Comment;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;
import ru.kirikura.yaproject_05_sharehouse.request.model.Request;

import java.util.Set;

@AllArgsConstructor
@Builder
@Data
public class ItemDateCommentDto {
    private long id;
    private String name;
    private String description;
    private Boolean available;
    private Person person;
    private Request request;
    private BookingItemDateDto previous;
    private BookingItemDateDto next;
    private Set<Comment> comments;
}
