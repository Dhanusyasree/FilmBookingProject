package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.entity.Booking;
import com.example.entity.User;
import com.example.service.BookingService;
import com.example.service.UserService;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;
    private final UserService userService;

    @Autowired
    public BookingController(BookingService bookingService, UserService userService) {
        this.bookingService = bookingService;
        this.userService = userService;
    }

    @PostMapping("/{userId}/book/{filmId}")
    public Booking bookFilm(@PathVariable Long userId, @PathVariable Long filmId) {
        User user = userService.findByUsername(userId);
        return bookingService.bookFilm(user, filmId);
    }
}
