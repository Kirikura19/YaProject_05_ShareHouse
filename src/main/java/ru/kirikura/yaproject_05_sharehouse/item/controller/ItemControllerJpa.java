package ru.kirikura.yaproject_05_sharehouse.item.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;
import ru.kirikura.yaproject_05_sharehouse.item.service.ItemServiceJPA;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/items")
public class ItemControllerJpa {
    ItemServiceJPA itemService;

    @GetMapping()
    public List<Item> findAll() {
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Item> findById(@PathVariable long id) {
        return itemService.findById(id);
    }

    @PostMapping
    public Item save(@RequestBody Item item) {
        return itemService.save(item);
    }

    @PatchMapping
    public Item update(Item item) {
        return itemService.update(item);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        itemService.deleteById(id);
    }

    @DeleteMapping
    public void delete(@RequestBody Item item) {
        itemService.delete(item);
    }
}
