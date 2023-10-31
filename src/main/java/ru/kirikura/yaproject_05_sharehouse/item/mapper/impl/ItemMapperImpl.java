package ru.kirikura.yaproject_05_sharehouse.item.mapper.impl;

import org.springframework.stereotype.Component;
import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingItemDateDto;
import ru.kirikura.yaproject_05_sharehouse.comment.model.Comment;
import ru.kirikura.yaproject_05_sharehouse.item.dto.ItemDateCommentDto;
import ru.kirikura.yaproject_05_sharehouse.item.mapper.ItemMapper;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;

import java.util.Set;

@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public ItemDateCommentDto toItemDateComentDto(Item item, BookingItemDateDto s, BookingItemDateDto e, Set<Comment> comments) {
        return ItemDateCommentDto
                .builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .available(item.getAvailable())
                .person(item.getPerson())
                .request(item.getRequest())
                .previous(s)
                .next(e)
                .build();
    }
}
