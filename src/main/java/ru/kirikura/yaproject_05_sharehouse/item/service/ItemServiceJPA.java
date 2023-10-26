package ru.kirikura.yaproject_05_sharehouse.item.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;
import ru.kirikura.yaproject_05_sharehouse.item.repository.ItemRepository;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class ItemServiceJPA {
    ItemRepository itemRepository;

    public List<Item> findAll() {
        return itemRepository.findAll();
    }

    public Optional<Item> findById(long id) {
        return itemRepository.findById(id);
    }

    public Item save(Item item) {
        return itemRepository.save(item);
    }

    public Item update(Item item) {
        return itemRepository.save(item);
    }

    public void deleteById(long id) {
        itemRepository.deleteById(id);
    }

    public void delete(Item item) {
        itemRepository.delete(item);
    }
}