package ru.kirikura.yaproject_05_sharehouse.booking.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kirikura.yaproject_05_sharehouse.booking.dto.BookingRegDto;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;
import ru.kirikura.yaproject_05_sharehouse.booking.service.BookingServiceJPA;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/bookings")
public class BookingController {
    BookingServiceJPA bookingService;
    private static final String USER_ID = "X-Sharer-User-Id";

    @GetMapping()
    public List<Booking> findAll() {
        return bookingService.findAll();
    }

    @GetMapping("/{bookingId}")
    public Booking findById(@RequestHeader(USER_ID) Long bookerId, @PathVariable long bookingId) {
        return bookingService.findById(bookingId, bookerId);
    }

    @PostMapping
    public Booking save(@RequestHeader(USER_ID) Long bookerId, @RequestBody BookingRegDto booking) {
        return bookingService.save(booking, bookerId);
    }

    @PatchMapping
    public Booking update(Booking booking) {
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
