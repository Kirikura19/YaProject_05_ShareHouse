package ru.kirikura.yaproject_05_sharehouse.item.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findAllByPerson_Id(long personId);
}