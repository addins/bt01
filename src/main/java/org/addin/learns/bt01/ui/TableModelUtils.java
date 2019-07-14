/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.ui;

import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import org.addin.learns.bt01.domain.RegisMember;
import static java.util.Optional.ofNullable;

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
    
    public static TableModel createTableModelFor(List<RegisMember> members) {
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
}
