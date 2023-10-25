package ru.kirikura.yaproject_05_sharehouse.item.mapper.impl;

import ru.kirikura.yaproject_05_sharehouse.item.dto.ItemDto;
import ru.kirikura.yaproject_05_sharehouse.item.mapper.ItemMapper;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;

public class ItemMapperImpl implements ItemMapper {
    @Override
    public ItemDto toItemDto(Item item) {
        return new ItemDto(
                item.getName(),
                item.getDescription()
        );
    }
}
