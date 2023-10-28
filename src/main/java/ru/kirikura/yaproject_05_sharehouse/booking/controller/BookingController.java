package ru.kirikura.yaproject_05_sharehouse.booking.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingDefaultDto;
import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingRegDto;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;
import ru.kirikura.yaproject_05_sharehouse.booking.service.BookingServiceJPA;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bookings")
public class BookingController {
    BookingServiceJPA bookingService;
    private static final String PERSON_ID = "X-Sharer-Person-Id";


    /*
     * Получение списка всех бронирований текущего пользователя
     */

    @GetMapping()
    public List<BookingDefaultDto> findAllByPersonAndStatus(@RequestHeader(PERSON_ID) Long personId, @RequestParam String status) {
        return bookingService.findAllByPersonAndStatus(personId, status);
    }

    /*
     * Получение списка бронирований всех вещей текущего пользователя.
     */

    @GetMapping("/owner")
    public List<BookingDefaultDto> findAllByItemsByOwner(@RequestHeader(PERSON_ID) Long personId, @RequestParam String status) {
        return bookingService.findAllByStatusAndItems_Owner(personId, status);
    }

    /*
     * Метод для хозяина бронирования или хозяина вещи.
     * Пользователь получает информацию конкретного бронирования по ID.
     */

    @GetMapping("/{bookingId}")
    public BookingDefaultDto findById(@RequestHeader(PERSON_ID) Long personId, @PathVariable long bookingId) {
        return bookingService.findById(bookingId, personId);
    }

    /*
     * Создание бронирования. В JSON запросе должны быть начало и конец бронирования, ID предмета.
     */

    @PostMapping
    public BookingDefaultDto save(@RequestHeader(PERSON_ID) Long personId, @RequestBody BookingRegDto booking) {
        return bookingService.save(booking, personId);
    }

    @PatchMapping("/{bookingId}")
    public BookingDefaultDto approve(@RequestHeader(PERSON_ID) Long personId, @PathVariable long bookingId, @RequestParam boolean approved) {
        return bookingService.approve(approved, personId, bookingId);
    }

    @PatchMapping
    public BookingDefaultDto update(Booking booking) {
        return bookingService.update(booking);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id) {
        bookingService.deleteById(id);
    }

    @DeleteMapping
    public void delete(@RequestBody Booking booking) {
        bookingService.delete(booking);
    }
}
