package com.travelmaker.yeoga.repository;

import com.travelmaker.yeoga.model.Reservation;
import com.travelmaker.yeoga.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByUser(User user);
    List<Reservation> findByUserAndCheckInDateBetween(User user, LocalDateTime start, LocalDateTime end);
}