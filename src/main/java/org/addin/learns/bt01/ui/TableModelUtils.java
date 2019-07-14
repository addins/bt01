/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.ui;

import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import org.addin.learns.bt01.domain.RegisMember;
import static java.util.Optional.ofNullable;
import org.addin.learns.bt01.domain.Booking;
import org.addin.learns.bt01.domain.Pembayaran;
import org.springframework.data.domain.Page;

/**
 *
 * @author Addin
 */
public class TableModelUtils {
    public static final String[] regisMemberColumnNames = new String[]{
        "ID",
        "Kode Member",
        "No. KTP",
        "Nama",
        "Alamat",
        "No. Telp",
        "Tgl Daftar",
        "Tgl Habis",
        "Bayar"
    };
    
    public static final String[] bookingColumnNames = new String[] {
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
    
    public static final String[] pembayaranColumnNames = new String[] {
        "ID",
        "No. Transaksi",
        "No. Booking",
        "Tgl Sewa",
        "Kode Member",
        "Nama Penyewa",
        "Kode Lapangan",
        "Jam Mulai",
        "Jam Selesai",
        "DP",
        "Harus Bayar",
        "Status Bayar"
    };
    
    public static TableModel createTableModelForMember(List<RegisMember> members) {
        return new AbstractTableModel() {

            @Override
            public int getRowCount() {
                return members.size();
            }

            @Override
            public int getColumnCount() {
                return regisMemberColumnNames.length;
            }

            @Override
            public String getColumnName(int column) {
                return regisMemberColumnNames[column];
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                switch (columnIndex) {
                    case 0:
                        return Long.class;
                    case 1:
                        return String.class;
                    case 2:
                        return String.class;
                    case 3:
                        return String.class;
                    case 4:
                        return String.class;
                    case 5:
                        return String.class;
                    case 6:
                        return String.class;
                    case 7:
                        return String.class;
                    case 8:
                        return String.class;
                    default:
                        return String.class;
                }
            }

            @Override
            public Object getValueAt(int arg0, int arg1) {
                RegisMember member = members.get(arg0);
                switch (arg1) {
                    case 0:
                        return member.getId();
                    case 1:
                        return member.getKode();
                    case 2:
                        return member.getNoKtp();
                    case 3:
                        return member.getNama();
                    case 4:
                        return member.getAlamat();
                    case 5:
                        return member.getNoTelp();
                    case 6:
                        return ofNullable(member.getTglDaftar())
                                .map(d -> d.format(DateTimeFormatter.ISO_DATE))
                                .orElse(null);
                    case 7:
                        return ofNullable(member.getTglHabis())
                                .map(d -> d.format(DateTimeFormatter.ISO_DATE))
                                .orElse(null);
                    case 8:
                        return member.getBayar();
                    default:
                        return "";
                }
            }
        };
    }
    public static TableModel createTableModelForBooking(Page<Booking> bookings) {
        List<Booking> content = bookings.getContent();
        return new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return content.size();
            }

            @Override
            public int getColumnCount() {
                return bookingColumnNames.length;
            }

            @Override
            public String getColumnName(int column) {
                return bookingColumnNames[column];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Booking booking = content.get(rowIndex);
                final Optional<RegisMember> member = ofNullable(booking.getMember());
                switch (columnIndex) {
                    case 0:
                        return booking.getId();
                    case 1:
                        return booking.getNoBooking();
                    case 2:
                        return booking.getTglSewa();
                    case 3:
                        return member.map(RegisMember::getKode).orElse("");
                    case 4:
                        return booking.getNamaPenyewa();
                    case 5:
                        return booking.getKodeLapangan();
                    case 6:
                        return booking.getJamMulai();
                    case 7:
                        return booking.getJamSelesai();
                    case 8:
                        return booking.getDp();
                    case 9:
                        return booking.getStatusPembayaran();
                    default:
                        return "";
                }
            }
        };
    }

    public static TableModel createTableModelForPembayaran(Page<Pembayaran> pembayarans) {
        List<Pembayaran> content = pembayarans.getContent();
        return new AbstractTableModel() {
            @Override
            public int getRowCount() {
                return content.size();
            }

            @Override
            public int getColumnCount() {
                return pembayaranColumnNames.length;
            }

            @Override
            public String getColumnName(int column) {
                return pembayaranColumnNames[column];
            }

            @Override
            public Object getValueAt(int rowIndex, int columnIndex) {
                Pembayaran pembayaran = content.get(rowIndex);
                final Optional<Booking> booking = ofNullable(pembayaran.getBooking());
                final Optional<RegisMember> member = booking.map(Booking::getMember);
                switch (columnIndex) {
                    case 0:
                        return pembayaran.getId();
                    case 1:
                        return pembayaran.getNoTransaksi();
                    case 2:
                        return booking.map(Booking::getNoBooking).orElse("");
                    case 3:
                        return booking.map(Booking::getTglSewa).orElse(null);
                    case 4:
                        return member.map(RegisMember::getKode).orElse("");
                    case 5:
                        return booking.map(Booking::getNamaPenyewa).orElse("");
                    case 6:
                        return booking.map(Booking::getKodeLapangan).orElse("");
                    case 7:
                        return booking.map(Booking::getJamMulai).orElse(null);
                    case 8:
                        return booking.map(Booking::getJamSelesai).orElse(null);
                    case 9:
                        return booking.map(Booking::getDp).orElse(null);
                    case 10:
                        return pembayaran.getHarusBayar();
                    case 11:
                        return booking.map(Booking::getStatusPembayaran).orElse("");
                    default:
                        return "";
                }
            }
        };
    }
}
