package com.example.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Booking;
import com.example.entity.User;
import com.example.repository.BookingRepository;
import com.example.repository.FilmRepository;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;
    private  FilmRepository filmRepository;

    @Autowired
    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking bookFilm(User user, Long filmId) {
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setFilm(filmRepository.findById(filmId).orElse(null));
        booking.setBookingTime(LocalDateTime.now());
        return bookingRepository.save(booking);
    }
}
