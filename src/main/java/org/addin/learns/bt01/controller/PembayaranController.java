/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.controller;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.addin.learns.bt01.domain.Booking;
import org.addin.learns.bt01.domain.Lapangan;
import org.addin.learns.bt01.domain.Pembayaran;
import org.addin.learns.bt01.repository.BookingRepository;
import org.addin.learns.bt01.repository.LapanganRepository;
import org.addin.learns.bt01.repository.PembayaranRepository;
import org.addin.learns.bt01.ui.FormRegisterMember;
import org.addin.learns.bt01.utils.CetakPdfService;
import static org.addin.learns.bt01.utils.CetakPdfService.buktiBayar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

/**
 *
 * @author Addin
 */
@Slf4j
@Transactional
@Component
public class PembayaranController {

    public static String LUNAS = "LUNAS";
    public static String BELUM_LUNAS = "BELUM_LUNAS";

    @Autowired
    private PembayaranRepository pembayaranRepository;
    
    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private LapanganRepository lapanganRepository;
    
    @Autowired
    private CetakPdfService cetakPdfService;
    
    public Page<Lapangan> findAllLapangan(Pageable pageable) {
        return lapanganRepository.findAll(pageable);
    }
    
    public Booking getOneById(Long id) {
        Booking one = bookingRepository.getOne(id);
        one.getMember();
        return one;
    }
    
    public Pembayaran getPembayaranById(Long id) {
        Pembayaran one = pembayaranRepository.getOne(id);
        one.getBooking().getMember();
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
        return pembayaranRepository.findAllByNoTransaksiLike(noTransaksi, page);
    }

    public Page<Pembayaran> findAllPembayaranByNoTransaksiAndKodeLapangan(String noTransaksi, String kodeLapangan, Pageable page) {
        return pembayaranRepository.findAllByNoTransaksiLikeAndBookingKodeLapangan(noTransaksi, kodeLapangan, page);
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

    public Page<Booking> findAllBookingByStatusPembayaran(String statusPembayaran, Pageable pageable) {
        return bookingRepository.findAllByStatusPembayaran(statusPembayaran, pageable);
    }

    public Page<Booking> findAllBookingByNoBookingAndStatusPembayaran(String nomorBooking, String statusBayar, Pageable pageable) {
        return bookingRepository.findAllByNoBookingAndStatusPembayaran(nomorBooking, statusBayar, pageable);
    }

    public Page<Pembayaran> findAllPembayaran(Date dateFrom, Date dateTo, Pageable unpaged) {
        ZonedDateTime startFrom = ZonedDateTime.ofInstant(dateFrom.toInstant(), ZoneId.systemDefault());
        ZonedDateTime startTo = ZonedDateTime.ofInstant(dateTo.toInstant(), ZoneId.systemDefault());
        return pembayaranRepository.findAllByBookingTglSewaBetween(startFrom, startTo, unpaged);
    }

    public void cetakBuktiBayar(String noTransaksi) throws DocumentException, IOException {
        Pembayaran bayaran = pembayaranRepository.findOneByNoTransaksi(noTransaksi);
        if (bayaran != null) {
            Context context = new Context();
            context.setVariable("vm", bayaran);
            cetakPdfService.renderToFile(buktiBayar, context, "bukti-bayar.pdf");
        }
    }

    public Page<Booking> findAllBookingByNoBookingAndKodeLapanganAndStatusPembayaran(String noBooking, String kodeLapanganFilter, String statusPembayaran, Pageable pageable) {
        return bookingRepository.findAllByNoBookingLikeAndKodeLapanganEqualsAndStatusPembayaran(noBooking, kodeLapanganFilter, statusPembayaran, pageable);
    }

    public Page<Booking> findAllBookingByKodeLapanganAndStatusPembayaran(String kodeLapanganFilter, String statusPembayaran, Pageable pageable) {
        return bookingRepository.findAllByKodeLapanganEqualsAndStatusPembayaran(kodeLapanganFilter, statusPembayaran, pageable);
    }

    public Page<Pembayaran> findAllPembayaranByKodeLapangan(String kodeLapangan, Pageable pageable) {
        return pembayaranRepository.findAllByBookingKodeLapangan(kodeLapangan, pageable);
    }
}
