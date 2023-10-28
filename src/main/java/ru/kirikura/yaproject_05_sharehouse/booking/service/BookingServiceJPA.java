package ru.kirikura.yaproject_05_sharehouse.booking.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingDefaultDto;
import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingRegDto;
import ru.kirikura.yaproject_05_sharehouse.booking.enums.Status;
import ru.kirikura.yaproject_05_sharehouse.booking.exception.BookingAccessDenied;
import ru.kirikura.yaproject_05_sharehouse.booking.exception.BookingNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.booking.mapper.BookerMapper;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;
import ru.kirikura.yaproject_05_sharehouse.booking.repository.BookingRepository;
import ru.kirikura.yaproject_05_sharehouse.booking.validation.BookingValidation;
import ru.kirikura.yaproject_05_sharehouse.item.exception.ItemIsNotAvailable;
import ru.kirikura.yaproject_05_sharehouse.item.exception.ItemNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;
import ru.kirikura.yaproject_05_sharehouse.item.repository.ItemRepository;
import ru.kirikura.yaproject_05_sharehouse.item.validation.ItemValidation;
import ru.kirikura.yaproject_05_sharehouse.person.exception.PersonNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;
import ru.kirikura.yaproject_05_sharehouse.person.repository.PersonRepository;
import ru.kirikura.yaproject_05_sharehouse.person.validation.PersonValidation;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class BookingServiceJPA {
    BookingRepository bookingRepository;
    ItemRepository itemRepository;
    PersonRepository personRepository;
    BookerMapper bookerMapper;

    public List<BookingDefaultDto> findAllByPersonAndStatus(Long personId, String status) {
        PersonValidation.checkIsUserExists(personId);
        List<Booking> bookings;
        if (status.equals("ALL"))
            bookings = bookingRepository.findAllByPerson_Id(personId);
        else
            bookings = bookingRepository.findAllByStatusAndPerson_Id(Status.valueOf(status), personId);
        return bookings.stream()
                .map(bookerMapper::toBookingDefaultDto)
                .collect(Collectors.toList());
    }

    public List<BookingDefaultDto> findAllByStatusAndItems_Owner(Long personId, String status) {
        PersonValidation.checkIsUserExists(personId);
        List<Booking> bookings;
        if (status.equals("ALL"))
            bookings = bookingRepository.findAllByItem_Person_Id(personId);
        else
            bookings = bookingRepository.findAllByStatusAndItem_Person_Id(Status.valueOf(status), personId);
        return bookings.stream()
                .map(bookerMapper::toBookingDefaultDto)
                .collect(Collectors.toList());
    }

    public BookingDefaultDto findById(long personId, long bookingId) {
        PersonValidation.checkIsUserExists(personId);
        Booking booking = BookingValidation.checkIsBookingExists(bookingId);
        if (!(booking.getPerson().getId() == personId) ||
                !(booking.getItem().getPerson().getId() == personId)) {
            throw new BookingNotFoundException("This booking is not accessible for you.");
        }
        return bookerMapper.toBookingDefaultDto(booking);
    }

    public BookingDefaultDto save(BookingRegDto bookingReg, Long personId) {
        PersonValidation.checkIsUserExists(personId);
        Person person = PersonValidation.checkIsUserExists(personId);
        Item item = ItemValidation.checkIsItemExists(bookingReg.getItemId());
        if(!item.getAvailable())
            throw new ItemIsNotAvailable("Item is already is used");

        /* Когда дойду до работы с item, тут нужно будет поменять item.avialable = false */

        Booking booking = Booking.builder()
                .timeStart(bookingReg.getTimeStart())
                .timeEnd(bookingReg.getTimeEnd())
                .item(item)
                .person(person)
                .status(Status.WAITING).build();
        return bookerMapper.toBookingDefaultDto(bookingRepository.save(booking));
    }

    public BookingDefaultDto approve(boolean approve, long personId, long bookingId) {
        PersonValidation.checkIsUserExists(personId);
        Booking booking = BookingValidation.checkIsBookingExists(bookingId);
        if (!(booking.getPerson().getId() == personId)) {
            throw new BookingAccessDenied("This booking is not accessible for you.");
        }
        if (approve) {
            booking.setStatus(Status.APPROVED);
        } else {
            booking.setStatus(Status.REJECTED);
        }
        return bookerMapper.toBookingDefaultDto(bookingRepository.save(booking));
    }

    public BookingDefaultDto update(Booking booking) {
        return bookerMapper.toBookingDefaultDto(bookingRepository.save(booking));
    }

    public void deleteById(long id) {
        bookingRepository.deleteById(id);
    }

    public void delete(Booking booking) {
        bookingRepository.delete(booking);
    }
}