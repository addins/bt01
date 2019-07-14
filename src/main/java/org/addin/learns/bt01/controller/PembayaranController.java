/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.controller;

import java.time.LocalDate;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.addin.learns.bt01.domain.Booking;
import org.addin.learns.bt01.domain.Pembayaran;
import org.addin.learns.bt01.repository.BookingRepository;
import org.addin.learns.bt01.repository.PembayaranRepository;
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
public class PembayaranController {

    @Autowired
    private PembayaranRepository pembayaranRepository;
    
    @Autowired
    private BookingRepository bookingRepository;
    
    public Booking getOneById(Long id) {
        Booking one = bookingRepository.getOne(id);
        one.getMember();
        return one;
    }
    
    public Page<Booking> findAllBooking(Pageable pageable) {
        return bookingRepository.findAll(pageable);
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

    public Page<Pembayaran> findAllPembayaranByNoTransaksi(String noTransaksi, Pageable page) {
        return pembayaranRepository.findAllByNoTransaksi(noTransaksi, page);
    }

    public Page<Pembayaran> findAllPembayaran(Pageable page) {
        return pembayaranRepository.findAll(page);
    }
    
    public Pembayaran save(@Valid Pembayaran pembayaran) {
        return pembayaranRepository.save(pembayaran);
    }

    public String findNextNoTransaksi() {
        Long maxId = pembayaranRepository.getMaxId();
        Long nextId = maxId + 1;
        LocalDate date = LocalDate.now();
        String noTransaksi = "" + String.format("%02d", date.getDayOfMonth());
        noTransaksi += "-" + String.format("%02d", date.getMonthValue());
        final String yearStr = date.getYear() + "";
        noTransaksi += "-" + yearStr.substring(yearStr.length() - 2);
        noTransaksi += "-" + String.format("%03d", nextId);
        return noTransaksi;
    }

    public Pembayaran save(Pembayaran bayaran, Booking selectedBooking) {
        bookingRepository.save(selectedBooking);
        return pembayaranRepository.save(bayaran);
    }
}
