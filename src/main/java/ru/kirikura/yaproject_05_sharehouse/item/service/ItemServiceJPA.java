package ru.kirikura.yaproject_05_sharehouse.item.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingItemDateDto;
import ru.kirikura.yaproject_05_sharehouse.booking.mapper.BookingMapper;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;
import ru.kirikura.yaproject_05_sharehouse.booking.repository.BookingRepository;
import ru.kirikura.yaproject_05_sharehouse.item.dto.ItemDateDto;
import ru.kirikura.yaproject_05_sharehouse.item.mapper.ItemMapper;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;
import ru.kirikura.yaproject_05_sharehouse.item.repository.ItemRepository;
import ru.kirikura.yaproject_05_sharehouse.item.validation.ItemValidation;
import ru.kirikura.yaproject_05_sharehouse.person.validation.PersonValidation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@AllArgsConstructor
@Service
public class ItemServiceJPA {
    ItemRepository itemRepository;
    BookingRepository bookingRepository;
    ItemMapper itemMapper;
    BookingMapper bookingMapper;
    PersonValidation personValidation;
    ItemValidation itemValidation;

    public List<ItemDateDto> findAll(long personId) {
        personValidation.checkIsUserExists(personId);
        List<Item> itemList = itemRepository.findAllByPerson_Id(personId);
        List<ItemDateDto> itemDateDtos = new ArrayList<>();
        for (Item item : itemList) {

            BookingItemDateDto bidt1 = null;
            BookingItemDateDto bidt2 = null;

            Booking bk1;
            Booking bk2;

            if ((bk1 = bookingRepository.findFirstByItem_IdAndTimeEndBeforeOrderByTimeEndDesc(item.getId(), LocalDateTime.now())) != null) {
                bidt1 = bookingMapper.toBookingItemDateDto(bk1);
            }

            if ((bk2 = bookingRepository.findFirstByItem_IdAndTimeStartAfterOrderByTimeStartAsc(item.getId(), LocalDateTime.now())) != null) {
                bidt2 = bookingMapper.toBookingItemDateDto(bk2);
            }

            itemDateDtos.add(
                    itemMapper.toItemDateDto(
                            item,
                            bidt1,
                            bidt2
                    )
            );
        }
        return itemDateDtos;
    }

    public Item findById(long id) {
        return itemValidation.checkIsItemExists(id);
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