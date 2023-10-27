package ru.kirikura.yaproject_05_sharehouse.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Long> {
}