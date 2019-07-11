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
}
