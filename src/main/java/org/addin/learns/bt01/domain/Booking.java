/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.domain;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.ZonedDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 *
 * @author addin
 */
@Data
@Entity
@Table(name = "booking")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String noBooking;
    
    private ZonedDateTime tglSewa;
    
    @ManyToOne
    @JoinColumn(name = "regis_member_id")
    private RegisMember member;
    
    private String namaPenyewa;
    
    private String kodeLapangan;
    
    private LocalTime jamMulai;
    
    private LocalTime jamSelesai;
    
    private BigDecimal dp;
    
    private String statusPembayaran;
}
