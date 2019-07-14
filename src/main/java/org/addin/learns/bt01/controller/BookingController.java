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
    
    public static final String[] bookingColumns = new String[] {
        "ID",
        "No. Booking",
        "Tgl Sewa",
        "Kode Member",
        "Nama Penyewa",
        "Kode Lapangan",
        "Jam Mulai",
        "Jam Selesai",
        "DP",
        "Status Bayar"
    };
    
    public Page<Lapangan> findAllLapangan(Pageable pageable) {
        return lapanganRepository.findAll(pageable);
    }
    
    public Page<Booking> findAllBooking(Pageable pageable) {
        return bookingRepository.findAll(pageable);
    }
     
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }
}
