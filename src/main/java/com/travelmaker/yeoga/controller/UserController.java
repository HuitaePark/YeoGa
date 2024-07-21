package com.travelmaker.yeoga.controller;
import com.travelmaker.service.UserService;
import com.travelmaker.dto.ReservationDTO;
import com.travelmaker.dto.BookmarkDTO;
import com.travelmaker.dto.CalendarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import java.util.List;

@RestController
@RequestMapping("/yeoga/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/reservation")
    public ResponseEntity<ReservationDTO> makeReservation(@RequestBody ReservationDTO reservationDTO) {
        ReservationDTO savedReservation = userService.makeReservation(reservationDTO);
        return ResponseEntity.ok(savedReservation);
    }

    @PostMapping("/bookmark")
    public ResponseEntity<BookmarkDTO> addBookmark(@RequestBody BookmarkDTO bookmarkDTO) {
        BookmarkDTO savedBookmark = userService.addBookmark(bookmarkDTO);
        return ResponseEntity.ok(savedBookmark);
    }

    @GetMapping("/calendar")
    public ResponseEntity<List<CalendarDTO>> getCalendar(@RequestParam Long userId) {
        List<CalendarDTO> calendarEntries = userService.getCalendar(userId);
        return ResponseEntity.ok(calendarEntries);
    }
}