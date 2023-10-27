package ru.kirikura.yaproject_05_sharehouse.booking.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;
import ru.kirikura.yaproject_05_sharehouse.booking.service.BookingServiceJPA;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/bookings")
public class BookingController {
    BookingServiceJPA bookingService;

    @GetMapping()
    public List<Booking> findAll() {
        return bookingService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Booking> findById(@PathVariable long id) {
        return bookingService.findById(id);
    }

    @PostMapping
    public Booking save(@RequestBody Booking booking) {
        return bookingService.save(booking);
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
