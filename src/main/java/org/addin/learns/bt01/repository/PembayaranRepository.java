/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.repository;

import java.time.ZonedDateTime;
import java.util.Date;
import org.addin.learns.bt01.domain.Pembayaran;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author addin
 */
public interface PembayaranRepository extends JpaRepository<Pembayaran, Long>{

    public Page<Pembayaran> findAllByNoTransaksiLike(String noTransaksi, Pageable page);
    
    @Query("SELECT coalesce(max(p.id), 0) FROM Pembayaran p")
    public Long getMaxId();

    public Page<Pembayaran> findAllByBookingTglSewaBetween(ZonedDateTime dateFrom, ZonedDateTime dateTo, Pageable unpaged);
}
