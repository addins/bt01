/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.repository;

import org.addin.learns.bt01.domain.Booking;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author addin
 */
public interface BookingRepository extends JpaRepository<Booking, Long>{

    public Page<Booking> findAllByNoBookingLikeAndKodeLapanganEquals(String noBooking, String kodeLapangan, Pageable pageable);

    public Page<Booking> findAllByNoBookingLike(String noBooking, Pageable pageable);

    public Page<Booking> findAllByKodeLapanganEquals(String kodeLapangan, Pageable pageable);
    
}
