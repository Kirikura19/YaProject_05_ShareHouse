package ru.kirikura.yaproject_05_sharehouse.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kirikura.yaproject_05_sharehouse.booking.enums.Status;
import ru.kirikura.yaproject_05_sharehouse.booking.model.Booking;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
    List<Booking> findAllByStatusAndPerson_Id(Status status, long id);

    List<Booking> findAllByPerson_Id(long id);

    List<Booking> findAllByItem_Person_Id(long id);

    List<Booking> findAllByStatusAndItem_Person_Id(Status status, long id);

    //List<Booking> findByItem_IdAndTimeStartAfterOrderByTimeStartDesc(Long userId, LocalDateTime start);


    Booking findFirstByItem_IdAndTimeEndBeforeOrderByTimeEndDesc(long itemId, LocalDateTime timeEnd);

    Booking findFirstByItem_IdAndTimeStartAfterOrderByTimeStartAsc(long itemId, LocalDateTime timeEnd);
}