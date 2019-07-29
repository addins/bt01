/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.controller;

import lombok.extern.slf4j.Slf4j;
import org.addin.learns.bt01.domain.Booking;
import org.addin.learns.bt01.domain.Lapangan;
import org.addin.learns.bt01.repository.BookingRepository;
import org.addin.learns.bt01.repository.LapanganRepository;
import org.addin.learns.bt01.repository.RegisMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Addin
 */
@Slf4j
@Transactional
@Component
public class BookingController {
    
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private RegisMemberRepository memberRepository;
    
    @Autowired
    private LapanganRepository lapanganRepository;
    
    public Page<Lapangan> findAllLapangan(Pageable pageable) {
        return lapanganRepository.findAll(pageable);
    }
    
    public Page<Booking> findAllBooking(Pageable pageable) {
        return bookingRepository.findAll(pageable);
    }
     
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    public Page<Booking> findAllBookingByNoBookingAndKodeLapangan(String noBooking, String kodeLapangan, Pageable pageable) {
        return bookingRepository.findAllByNoBookingLikeAndKodeLapanganEquals(noBooking, kodeLapangan, pageable);
    }

    public Page<Booking> findAllBookingByNoBooking(String noBooking, Pageable pageable) {
        return bookingRepository.findAllByNoBookingLike(noBooking, pageable);
    }

    public Page<Booking> findAllBookingByKodeLapangan(String kodeLapangan, Pageable pageable) {
        return bookingRepository.findAllByKodeLapanganEquals(kodeLapangan, pageable);
    }

    public Long findMaxBookingId() {
        return bookingRepository.getMaxId();
    }
    
    public String findNextNoBooking() {
        Long maxBookingId = findMaxBookingId();
        return "MB-" +  String.format("%03d", maxBookingId + 1);
    }

    public Page<Booking> findAllBookingByNoBookingAndKodeLapanganAndStatusPembayaran(String noBooking, String kodeLapangan, String statusPembayaran, Pageable pageable) {
        return bookingRepository.findAllByNoBookingLikeAndKodeLapanganEqualsAndStatusPembayaran(noBooking, kodeLapangan, statusPembayaran, pageable);
    }

    public Page<Booking> findAllBookingByNoBookingAndStatusPembayaran(String noBooking, String statusPembayaran, Pageable pageable) {
        return bookingRepository.findAllByNoBookingLike(noBooking, statusPembayaran, pageable);
    }

    public Page<Booking> findAllBookingByKodeLapanganAndStatusPembayaran(String kodeLapangan, String statusPembayaran, Pageable pageable) {
        return bookingRepository.findAllByKodeLapanganEqualsAndStatusPembayaran(kodeLapangan, statusPembayaran, pageable);
    }

    public Page<Booking> findAllBookingByStatusPembayaran(String statusPembayaran, Pageable unpaged) {
        return bookingRepository.findAllByStatusPembayaran(statusPembayaran, unpaged);
    }
}
