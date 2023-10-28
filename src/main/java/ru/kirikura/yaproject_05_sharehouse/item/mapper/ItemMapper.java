package ru.kirikura.yaproject_05_sharehouse.item.mapper;

import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingItemDateDto;
import ru.kirikura.yaproject_05_sharehouse.item.dto.ItemDateDto;
import ru.kirikura.yaproject_05_sharehouse.item.dto.ItemDefaultDto;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;

public interface ItemMapper {
    ItemDefaultDto toItemDefaultDto(Item item);

    ItemDateDto toItemDateDto(Item item, BookingItemDateDto s, BookingItemDateDto e);
}
