package ru.kirikura.yaproject_05_sharehouse.item.validation;

import ru.kirikura.yaproject_05_sharehouse.booking.exception.BookingNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;
import ru.kirikura.yaproject_05_sharehouse.booking.repository.BookingRepository;
import ru.kirikura.yaproject_05_sharehouse.item.exception.ItemNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;
import ru.kirikura.yaproject_05_sharehouse.item.repository.ItemRepository;

public class ItemValidation {
    static ItemRepository itemRepository;
    public static Item checkIsItemExists(long itemId) {
        return itemRepository.findById(itemId).orElseThrow(()
                -> new ItemNotFoundException("Item is not exists"));
    }
}
