package ru.kirikura.yaproject_05_sharehouse.item.validation;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.kirikura.yaproject_05_sharehouse.item.exception.ItemNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;
import ru.kirikura.yaproject_05_sharehouse.item.repository.ItemRepository;

@AllArgsConstructor
@Component
public class ItemValidation {
    ItemRepository itemRepository;

    public Item checkIsItemExists(long itemId) {
        return itemRepository.findById(itemId).orElseThrow(()
                -> new ItemNotFoundException("Item is not exists"));
    }
}
