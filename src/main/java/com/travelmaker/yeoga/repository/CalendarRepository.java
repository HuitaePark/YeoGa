package com.travelmaker.yeoga.repository;


import com.travelmaker.yeoga.model.Calendar;
import com.travelmaker.yeoga.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Long> {
    List<Calendar> findByUser(User user);
    List<Calendar> findByUserAndDateBetween(User user, LocalDate start, LocalDate end);
}