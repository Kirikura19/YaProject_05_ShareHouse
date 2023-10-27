package ru.kirikura.yaproject_05_sharehouse.booking.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingRegDto;
import ru.kirikura.yaproject_05_sharehouse.booking.enums.Status;
import ru.kirikura.yaproject_05_sharehouse.booking.exception.BookingNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;
import ru.kirikura.yaproject_05_sharehouse.booking.repository.BookingRepository;
import ru.kirikura.yaproject_05_sharehouse.item.exception.ItemIsNotAvailable;
import ru.kirikura.yaproject_05_sharehouse.item.exception.ItemNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;
import ru.kirikura.yaproject_05_sharehouse.item.service.ItemServiceJPA;
import ru.kirikura.yaproject_05_sharehouse.user.exception.UserNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.user.model.User;
import ru.kirikura.yaproject_05_sharehouse.user.service.UserServiceJPA;

import java.util.List;
import java.util.Optional;
@AllArgsConstructor
@Service
public class BookingServiceJPA {
    BookingRepository bookingRepository;
    ItemServiceJPA itemServiceJPA;
    UserServiceJPA userServiceJPA;
    BookingServiceJPA bookingServiceJPA;

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking findById(long bookerId, long bookingId) {
        User user = userServiceJPA.findById(bookerId).orElseThrow(()
                -> new UserNotFoundException("User not found"));
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(()
                -> new BookingNotFoundException("User not found"));
        if(!booking.getBooker().equals(user) || !booking.getItem().getOwner().equals(user))
            throw new BookingNotFoundException("This booking is not Accessible for you.");
        return booking;
    }

    public Booking save(BookingRegDto bookingReg, Long bookerId) {
        User booker = userServiceJPA.findById(bookerId).orElseThrow(()
                -> new UserNotFoundException("User not found"));
        Item item = itemServiceJPA.findById(bookingReg.getItemId()).orElseThrow(()
                -> new ItemNotFoundException("Item not found"));
        if(!item.getAvailable())
            throw new ItemIsNotAvailable("Item is already is used");

        Booking booking = Booking.builder()
                .timeStart(bookingReg.getTimeStart())
                .timeEnd(bookingReg.getTimeEnd())
                .item(item)
                .booker(booker)
                .status(Status.WAITING).build();
        return bookingRepository.save(booking);
    }

    public Booking update(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteById(long id) {
        bookingRepository.deleteById(id);
    }

    public void delete(Booking booking) {
        bookingRepository.delete(booking);
    }
}