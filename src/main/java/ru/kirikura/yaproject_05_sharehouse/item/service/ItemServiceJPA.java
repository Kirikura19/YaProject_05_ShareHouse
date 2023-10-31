package ru.kirikura.yaproject_05_sharehouse.item.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingItemDateDto;
import ru.kirikura.yaproject_05_sharehouse.booking.mapper.BookingMapper;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;
import ru.kirikura.yaproject_05_sharehouse.booking.repository.BookingRepository;
import ru.kirikura.yaproject_05_sharehouse.comment.model.Comment;
import ru.kirikura.yaproject_05_sharehouse.comment.repository.CommentRepository;
import ru.kirikura.yaproject_05_sharehouse.item.dto.ItemDateCommentDto;
import ru.kirikura.yaproject_05_sharehouse.item.mapper.ItemMapper;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;
import ru.kirikura.yaproject_05_sharehouse.item.repository.ItemRepository;
import ru.kirikura.yaproject_05_sharehouse.item.validation.ItemValidation;
import ru.kirikura.yaproject_05_sharehouse.person.validation.PersonValidation;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@Service
public class ItemServiceJPA {
    ItemRepository itemRepository;
    BookingRepository bookingRepository;
    ItemMapper itemMapper;
    BookingMapper bookingMapper;
    PersonValidation personValidation;
    ItemValidation itemValidation;
    CommentRepository commentRepository;

    public ItemDateCommentDto findItemWithPreviousAndNextBookingAndComment(Item item) {
        BookingItemDateDto bidt1 = null;
        BookingItemDateDto bidt2 = null;
        Set<Comment> comments;
        Booking bk1;
        Booking bk2;
        if ((bk1 = bookingRepository.findFirstByItem_IdAndTimeEndBeforeOrderByTimeEndDesc(item.getId(), LocalDateTime.now())) != null) {
            bidt1 = bookingMapper.toBookingItemDateDto(bk1);
        }

        if ((bk2 = bookingRepository.findFirstByItem_IdAndTimeStartAfterOrderByTimeStartAsc(item.getId(), LocalDateTime.now())) != null) {
            bidt2 = bookingMapper.toBookingItemDateDto(bk2);
        }
        comments = commentRepository.findAllByItem_Id(item.getId());

        return itemMapper.toItemDateComentDto(
                item,
                bidt1,
                bidt2,
                comments
        );
    }

    public List<ItemDateCommentDto> findAll(long personId) {
        personValidation.checkIsUserExists(personId);
        List<Item> itemList = itemRepository.findAllByPerson_Id(personId);
        List<ItemDateCommentDto> itemDateDtos = new ArrayList<>();
        for (Item item : itemList) {
            itemDateDtos.add(findItemWithPreviousAndNextBookingAndComment(item));
        }
        return itemDateDtos;
    }

    public ItemDateCommentDto findById(long id) {
        Item item = itemValidation.checkIsItemExists(id);
        return findItemWithPreviousAndNextBookingAndComment(item);
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