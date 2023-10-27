package ru.kirikura.yaproject_05_sharehouse.booking.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingRegDto;
import ru.kirikura.yaproject_05_sharehouse.booking.enums.Status;
import ru.kirikura.yaproject_05_sharehouse.booking.exception.BookingAccessDenied;
import ru.kirikura.yaproject_05_sharehouse.booking.exception.BookingNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;
import ru.kirikura.yaproject_05_sharehouse.booking.repository.BookingRepository;
import ru.kirikura.yaproject_05_sharehouse.item.exception.ItemIsNotAvailable;
import ru.kirikura.yaproject_05_sharehouse.item.exception.ItemNotFoundException;
import ru.kirikura.yaproject_05_sharehouse.item.model.Item;
import ru.kirikura.yaproject_05_sharehouse.item.service.ItemServiceJPA;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;
import ru.kirikura.yaproject_05_sharehouse.person.service.PersonServiceJPA;

import java.util.List;

@AllArgsConstructor
@Service
public class BookingServiceJPA {
    BookingRepository bookingRepository;
    ItemServiceJPA itemServiceJPA;
    PersonServiceJPA personServiceJPA;

    public List<Booking> findAllByPersonAndStatus(Long personId, String status) {
        Person person = personServiceJPA.findById(personId);
        if (status.equals("ALL"))
            return bookingRepository.findAllByPerson(person);
        else
            return bookingRepository.findAllByStatusAndPerson(Status.valueOf(status), person);
    }

    public List<Booking> findAllByStatusAndItems_Owner(Long personId, String status) {
        Person person = personServiceJPA.findById(personId);
        if (status.equals("ALL"))
            return bookingRepository.findAllByItem_Person(person);
        else
            return bookingRepository.findAllByStatusAndItem_Person(Status.valueOf(status), person);
    }

    public Booking findById(long personId, long bookingId) {
        Person person = personServiceJPA.findById(personId);
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(()
                -> new BookingNotFoundException("Person not found"));
        if (!booking.getPerson().equals(person) || !booking.getItem().getPerson().equals(person))
            throw new BookingNotFoundException("This booking is not accessible for you.");
        return booking;
    }

    public Booking save(BookingRegDto bookingReg, Long personId) {
        Person person = personServiceJPA.findById(personId);
        Item item = itemServiceJPA.findById(bookingReg.getItemId()).orElseThrow(()
                -> new ItemNotFoundException("Item not found"));
        if(!item.getAvailable())
            throw new ItemIsNotAvailable("Item is already is used");

        Booking booking = Booking.builder()
                .timeStart(bookingReg.getTimeStart())
                .timeEnd(bookingReg.getTimeEnd())
                .item(item)
                .person(person)
                .status(Status.WAITING).build();
        return bookingRepository.save(booking);
    }

    public Booking approve(boolean approve, long personId, long bookingId) {
        Person person = personServiceJPA.findById(personId);
        Booking booking = bookingRepository.findById(bookingId).orElseThrow(()
                -> new BookingNotFoundException("Person not found"));
        if (!booking.getPerson().equals(person))
            throw new BookingAccessDenied("This booking is not accessible for you.");
        if (approve) {
            booking.setStatus(Status.APPROVED);
        } else {
            booking.setStatus(Status.REJECTED);
        }
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