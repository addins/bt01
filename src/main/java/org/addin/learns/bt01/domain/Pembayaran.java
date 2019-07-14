/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.domain;

import java.math.BigDecimal;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 *
 * @author addin
 */
@Data
@Entity
@Table(name = "pembayaran")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Pembayaran {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @OneToOne
    private Booking booking;
    
    @NotNull
    private String noTransaksi;
    
    @NotNull
    private BigDecimal harusBayar;
    
    public Pembayaran withBooking(Booking booking) {
        this.booking = booking;
        return this;
    }
    
    public Pembayaran withNoTransaksi(String noTransaksi) {
        this.noTransaksi = noTransaksi;
        return this;
    }
    
    public Pembayaran  withHarusBayar(BigDecimal harusBayar) {
        this.harusBayar = harusBayar;
        return this;
    }
}
