package ru.kirikura.yaproject_05_sharehouse.item.mapper.impl;

import org.springframework.stereotype.Component;
import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingItemDateDto;
import ru.kirikura.yaproject_05_sharehouse.item.dto.ItemDateDto;
import ru.kirikura.yaproject_05_sharehouse.item.dto.ItemDefaultDto;
import ru.kirikura.yaproject_05_sharehouse.item.mapper.ItemMapper;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;

@Component
public class ItemMapperImpl implements ItemMapper {
    @Override
    public ItemDefaultDto toItemDefaultDto(Item item) {
        return ItemDefaultDto
                .builder()
                .id(item.getId())
                .name(item.getName())
                .description(item.getDescription())
                .available(item.getAvailable())
                .person(item.getPerson())
                .request(item.getRequest())
                .build();
    }

    @Override
    public ItemDateDto toItemDateDto(Item item, BookingItemDateDto s, BookingItemDateDto e) {
        return ItemDateDto
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
