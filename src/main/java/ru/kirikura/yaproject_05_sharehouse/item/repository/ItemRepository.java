package ru.kirikura.yaproject_05_sharehouse.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}