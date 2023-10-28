package ru.kirikura.yaproject_05_sharehouse.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirikura.yaproject_05_sharehouse.booking.enums.Status;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByStatusAndPerson_Id(Status status, long id);

    List<Booking> findAllByPerson_Id(long id);

    List<Booking> findAllByItem_Person_Id(long id);

    List<Booking> findAllByStatusAndItem_Person_Id(Status status, long id);
}