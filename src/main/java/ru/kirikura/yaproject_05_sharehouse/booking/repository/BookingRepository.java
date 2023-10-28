package ru.kirikura.yaproject_05_sharehouse.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.kirikura.yaproject_05_sharehouse.booking.enums.Status;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;
import ru.kirikura.yaproject_05_sharehouse.person.model.Person;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByStatusAndPerson(Status status, Person person);

    List<Booking> findAllByPerson(Person person);

    List<Booking> findAllByItem_Person(Person owner);

    List<Booking> findAllByStatusAndItem_Person(Status status, Person owner);
}