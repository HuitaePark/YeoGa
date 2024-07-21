package com.travelmaker.yeoga.repository;


import com.travelmaker.yeoga.model.Bookmark;
import com.travelmaker.yeoga.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findByUser(User user);
    boolean existsByUserAndPlaceName(User user, String placeName);
}