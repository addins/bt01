/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  addin
 * Created: Jul 11, 2019
 */

create table `regis_member` (
    `id` bigint not null AUTO_INCREMENT,
    `kode` varchar(255) default null,
    `no_ktp` varchar(255) default null,
    `nama` varchar(255) default null,
    `alamat` varchar(255) default null,
    `no_telp` varchar(255) default null,
    `tgl_daftar` datetime,
    `tgl_habis` datetime,
    `bayar` varchar(255),
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `booking` (
    `id` bigint not null AUTO_INCREMENT,
    `no_booking` varchar(255) default null,
    `tgl_sewa` datetime not null,
    `regis_member_id` bigint,
    `nama_penyewa` varchar(255) not null,
    `kode_lapangan` varchar(255) not null,
    `jam_mulai` time not null,
    `jam_selesai` time not null,
    `dp` numeric,
    `status_pembayaran` varchar(255),
    PRIMARY KEY (id),
    FOREIGN KEY (regis_member_id) REFERENCES regis_member(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `pembayaran` (
    `id` bigint not null AUTO_INCREMENT,
    `booking_id` bigint not null,
    `no_transaksi` varchar(255) not null,
    PRIMARY KEY (id),
    FOREIGN KEY (booking_id) REFERENCES booking(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

create table `lapangan` (
    `id` bigint not null AUTO_INCREMENT,
    `kode` varchar(255) not null,
    PRIMARY KEY (id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;