/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import java.time.ZonedDateTime;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/**
 *
 * @author addin
 */
@Data
@Entity
@Table(name = "regis_member")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class RegisMember implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String kode;

    private String noKtp;
    
    private String nama;

    private String alamat;

    private String noTelp;

    private ZonedDateTime tglDaftar;

    private ZonedDateTime tglHabis;

    private String bayar;
    
    public RegisMember withKode(String kode) {
        this.kode = kode;
        return this;
    }
    
    public RegisMember withnoKtp(String noKtp) {
        this.noKtp = noKtp;
        return this;
    }
    
    public RegisMember withnama(String nama) {
        this.nama = nama;
        return this;
    }
    
    public RegisMember withalamat(String alamat) {
        this.alamat = alamat;
        return this;
    }
    
    
    public RegisMember withNoTelp(String noTelp) {
        this.noTelp = noTelp;
        return this;
    }
    
    
    public RegisMember withTglDaftar(ZonedDateTime tglDaftar) {
        this.tglDaftar = tglDaftar;
        return this;
    }
    
    
    public RegisMember withTglHabis(ZonedDateTime tglHabis) {
        this.tglHabis = tglHabis;
        return this;
    }
    
    
    public RegisMember withBayar(String bayar) {
        this.bayar = bayar;
        return this;
    }
    
    
    
    
}
