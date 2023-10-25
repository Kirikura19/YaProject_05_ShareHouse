package ru.kirikura.yaproject_05_sharehouse.item.mapper;

import ru.kirikura.yaproject_05_sharehouse.item.dto.ItemDto;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;

public interface ItemMapper {
    ItemDto toItemDto(Item item);
}
