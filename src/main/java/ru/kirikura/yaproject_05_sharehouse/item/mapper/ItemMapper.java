package ru.kirikura.yaproject_05_sharehouse.item.mapper;

import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingItemDateDto;
import ru.kirikura.yaproject_05_sharehouse.comment.model.Comment;
import ru.kirikura.yaproject_05_sharehouse.item.dto.ItemDateCommentDto;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;

import java.util.Set;

public interface ItemMapper {

    ItemDateCommentDto toItemDateComentDto(Item item, BookingItemDateDto s, BookingItemDateDto e, Set<Comment> comments);


}
