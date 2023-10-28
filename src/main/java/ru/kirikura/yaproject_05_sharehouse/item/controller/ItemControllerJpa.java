package ru.kirikura.yaproject_05_sharehouse.item.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kirikura.yaproject_05_sharehouse.item.dto.ItemDateDto;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;
import ru.kirikura.yaproject_05_sharehouse.item.service.ItemServiceJPA;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/items")
public class ItemControllerJpa {
    ItemServiceJPA itemService;
    private static final String PERSON_ID = "X-Sharer-Person-Id";


    @GetMapping()
    public List<ItemDateDto> findAll(@RequestHeader(PERSON_ID) long personId) {
        return itemService.findAll(personId);
    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable long id) {
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
