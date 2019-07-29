package org.addin.learns.bt01.ui;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import static java.time.ZonedDateTime.ofInstant;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;

import static javax.swing.JOptionPane.*;
import static javax.swing.JOptionPane.YES_OPTION;
import static javax.swing.JOptionPane.showConfirmDialog;

import javax.swing.ListSelectionModel;
import javax.swing.SwingWorker;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import org.addin.learns.bt01.controller.RegisMemberController;
import org.addin.learns.bt01.domain.RegisMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author eroot
 */
@Component
public class FormRegisterMember extends javax.swing.JFrame {

    @Autowired
    private MenuUtama menuUtama;

    @Autowired
    private RegisMemberController memberController;

    private Long selectedMemberId;

    private boolean refreshing = false;

    private boolean saving = false;

    private boolean deleting = false;

    /**
     * Creates new form from_regismember
     */
    public FormRegisterMember() {
        initComponents();
        addSelectionListenerForTable();
    }

    private void addSelectionListenerForTable() {
        ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int selectedRow = table.getSelectedRow();
                final TableModel tableModel = table.getModel();
                if (selectedRow > -1 && tableModel.getRowCount() > 0) {
                    selectedMemberId = (Long) tableModel.getValueAt(selectedRow, 0);
                    btnEdit.setEnabled(true);
                    btnHapus.setEnabled(true);
                    btnPrint.setEnabled(true);
                } else {
                    selectedMemberId = null;
                    btnEdit.setEnabled(false);
                    btnHapus.setEnabled(false);
                    btnPrint.setEnabled(false);
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtfKode = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtfNoKtp = new javax.swing.JTextField();
        txtfAlamat = new javax.swing.JTextField();
        txtfNama = new javax.swing.JTextField();
        txtfNoTelp = new javax.swing.JTextField();
        datcTglDaftar = new com.toedter.calendar.JDateChooser();
        datcTglHabis = new com.toedter.calendar.JDateChooser();
        txtfBayar = new javax.swing.JTextField();
        btnSimpan = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        txtfSearchInput = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        btnKembali = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        btnHapus = new javax.swing.JButton();
        btnPrint = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Registrasi Member"));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Kode Member");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("No KTP");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel3.setText("Nama");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Alamat");

        txtfKode.setEditable(false);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("No Telepon");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Tgl Daftar/Update");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Tgl Habis");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Bayar");

        btnSimpan.setText("Simpan");
        btnSimpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSimpanActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(datcTglHabis, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel8)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel7)
                                        .addComponent(jLabel6)
                                        .addComponent(jLabel4))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(txtfBayar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtfNoTelp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(45, 45, 45)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(datcTglDaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtfAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtfKode, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtfNama, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtfNoKtp, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addContainerGap(52, Short.MAX_VALUE))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnReset, btnSimpan});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfKode, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfNoKtp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txtfNama, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfAlamat, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfNoTelp, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(datcTglDaftar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7)
                    .addComponent(datcTglHabis, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtfBayar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSimpan, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnReset))
                .addGap(36, 36, 36))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnReset, btnSimpan});

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Kode Member", "No. KTP", "Nama", "Alamat", "No. Telp", "Tgl. Daftar", "Tgl. Habis", "Bayar"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Long.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.setShowGrid(true);
        jScrollPane1.setViewportView(table);
        if (table.getColumnModel().getColumnCount() > 0) {
            table.getColumnModel().getColumn(0).setResizable(false);
        }

        txtfSearchInput.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfSearchInputActionPerformed(evt);
            }
        });

        jLabel9.setText("Kode Member");

        btnKembali.setText("Kembali");
        btnKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKembaliActionPerformed(evt);
            }
        });

        jLabel10.setText("Data Member");

        btnEdit.setText("Edit");
        btnEdit.setEnabled(false);
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnHapus.setText("Hapus");
        btnHapus.setEnabled(false);
        btnHapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHapusActionPerformed(evt);
            }
        });

        btnPrint.setText("Print");
        btnPrint.setEnabled(false);
        btnPrint.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrintActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnPrint)
                                .addGap(18, 18, 18)
                                .addComponent(btnEdit)
                                .addGap(18, 18, 18)
                                .addComponent(btnHapus)
                                .addGap(18, 18, 18)
                                .addComponent(btnKembali))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(21, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(327, 327, 327))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtfSearchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnEdit, btnHapus, btnKembali, btnPrint});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(51, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtfSearchInput, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(55, 55, 55)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(btnHapus, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnPrint))
                            .addComponent(btnKembali, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59))))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {btnEdit, btnPrint});

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKembaliActionPerformed
        menuUtama.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btnKembaliActionPerformed

    public void clearMemberForm() {
        refreshNextKodeMember();
        txtfNoKtp.setText("");
        txtfNama.setText("");
        txtfAlamat.setText("");
        txtfNoTelp.setText("");
        txtfBayar.setText("");
        datcTglDaftar.setCalendar(null);
        datcTglHabis.setCalendar(null);
    }

    public void showAlert() {
        showMessageDialog(rootPane, "Harap isi semua data member");
    }

    private void createAndSaveMember(Long id, String kode, String noKtp, String nama, String alamat, String noTelp, ZonedDateTime tglDaftar, ZonedDateTime tglHabis, String bayar) {
        RegisMember member = new RegisMember()
                .withKode(kode)
                .withnoKtp(noKtp)
                .withnama(nama)
                .withalamat(alamat)
                .withNoTelp(noTelp)
                .withTglDaftar(tglDaftar)
                .withTglHabis(tglHabis)
                .withBayar(bayar);

        member.setId(id);

        saving = true;
        btnSimpan.setEnabled(false);
        new SwingWorker<RegisMember, Void>() {
            @Override
            protected RegisMember doInBackground() throws Exception {
                return memberController.save(member);
            }

            @Override
            protected void done() {
                refreshMemberList();
                clearMemberForm();
                saving = false;
                btnSimpan.setEnabled(true);
            }
        }.execute();
    }

    private void refreshMemberList() {
        new SwingWorker<Page<RegisMember>, Void>() {
            @Override
            protected Page<RegisMember> doInBackground() throws Exception {
                return memberController.findAllMember(Pageable.unpaged());
            }

            @Override
            protected void done() {
                try {
                    List<RegisMember> members = get().getContent();
                    updateTableModel(members);
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(FormRegisterMember.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.execute();
    }

    private void refreshMemberListBySearchInput(String keyword) {
        refreshing = true;
        txtfSearchInput.setEnabled(false);
        new SwingWorker<Page<RegisMember>, Void>() {
            @Override
            protected Page<RegisMember> doInBackground() throws Exception {
                return memberController.findAllMemberByKodeLike(keyword, Pageable.unpaged());
            }

            @Override
            protected void done() {
                try {
                    List<RegisMember> members = get().getContent();
                    updateTableModel(members);
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(FormRegisterMember.class.getName()).log(Level.SEVERE, null, ex);
                }
                refreshing = false;
                txtfSearchInput.setEnabled(true);
            }
        }.execute();
    }

    private void updateTableModel(List<RegisMember> members) {
        TableModel dataModel = TableModelUtils.createTableModelForMember(members);
        table.setModel(dataModel);
    }

    private void btnHapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHapusActionPerformed
        if (selectedMemberId != null) {
            int confirmedResult = showConfirmDialog(rootPane, "Yakin hapus data terpilih?", "Hapus", YES_NO_OPTION);
            if (YES_OPTION == confirmedResult) {
                deleteSelectedMember();
            }
        }
    }//GEN-LAST:event_btnHapusActionPerformed

    private void deleteSelectedMember() {
        deleting = true;
        btnHapus.setEnabled(!deleting);
        new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                memberController.delete(selectedMemberId);
                return null;
            }

            @Override
            protected void done() {
                deleting = false;
                btnHapus.setEnabled(!deleting);
                refreshMemberList();
            }
        }.execute();
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        clearMemberForm();
        refreshMemberList();
    }//GEN-LAST:event_formWindowOpened

    private void txtfSearchInputActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfSearchInputActionPerformed
        String keyword = txtfSearchInput.getText();
        if (keyword != null && !keyword.isEmpty()) {
            refreshMemberListBySearchInput("%" + keyword.toLowerCase() + "%");
        } else {
            refreshMemberList();
        }
    }//GEN-LAST:event_txtfSearchInputActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (selectedMemberId != null) {
            editSelectedMember();
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
        new SwingWorker<Boolean, Void>() {
            @Override
            protected Boolean doInBackground() throws Exception {
                try {
                    memberController.cetakKartuMemberPdf(selectedMemberId);
                    return true;
                } catch (Exception e) {
                    Logger.getLogger(FormRegisterMember.class.getName()).log(Level.SEVERE, null, e);
                }
                return false;
            }

            @Override
            protected void done() {
                try {
                    Boolean success = get();
                    if (success) {
                        showMessageDialog(rootPane, "Cetak sukses");
                    } else {
                        showMessageDialog(rootPane, "Cetak gagal", "Cetak Gagal", ERROR_MESSAGE);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(FormRegisterMember.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ExecutionException ex) {
                    Logger.getLogger(FormRegisterMember.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.execute();

    }//GEN-LAST:event_btnPrintActionPerformed

    private void btnSimpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSimpanActionPerformed
        String kode = txtfKode.getText();
        String noKtp = txtfNoKtp.getText();
        String nama = txtfNama.getText();
        String alamat = txtfAlamat.getText();
        String noTelp = txtfNoTelp.getText();

        final Date tglDaftarDate = datcTglDaftar.getDate();
        ZonedDateTime tglDaftar = null;
        if (tglDaftarDate != null) {
            tglDaftar = ofInstant(tglDaftarDate.toInstant(), ZoneId.systemDefault());
        }

        final Date tglHabisDate = datcTglHabis.getDate();
        ZonedDateTime tglHabis = null;
        if (tglHabisDate != null) {
            tglHabis = ofInstant(tglHabisDate.toInstant(), ZoneId.systemDefault());
        }

        String bayar = txtfBayar.getText();

        if (kode == null || kode.isEmpty()
                || noKtp == null || noKtp.isEmpty()
                || nama == null || nama.isEmpty()
                || alamat == null || alamat.isEmpty()
                || tglDaftar == null || tglHabis == null
                || bayar == null || bayar.isEmpty()) {
            showAlert();
            return;
        }

        if (!saving) {
            createAndSaveMember(selectedMemberId, kode, noKtp, nama, alamat, noTelp, tglDaftar, tglHabis, bayar);
        }
    }//GEN-LAST:event_btnSimpanActionPerformed

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        clearMemberForm();
        selectedMemberId = null;
    }//GEN-LAST:event_btnResetActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
       clearMemberForm();
       selectedMemberId = null;
       refreshMemberList();
    }//GEN-LAST:event_formWindowActivated

    private void editSelectedMember() {
        btnEdit.setEnabled(false);
        new SwingWorker<RegisMember, Void>() {
            @Override
            protected RegisMember doInBackground() throws Exception {
                return memberController.findOne(selectedMemberId);
            }

            @Override
            protected void done() {
                try {
                    RegisMember oneMember = get();
                    setFormFieldsWith(oneMember);
                    btnEdit.setEnabled(true);
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(FormRegisterMember.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }.execute();
    }

    private void setFormFieldsWith(RegisMember member) {
        txtfKode.setText(member.getKode());
        txtfNoKtp.setText(member.getNoKtp());
        txtfNama.setText(member.getNama());
        txtfAlamat.setText(member.getAlamat());
        txtfNoTelp.setText(member.getNoTelp());
        datcTglDaftar.setDate(Date.from(member.getTglDaftar().toInstant()));
        datcTglHabis.setDate(Date.from(member.getTglHabis().toInstant()));
        txtfBayar.setText(member.getBayar());
    }
    
    private void refreshNextKodeMember() {
        btnSimpan.setEnabled(false);
        new SwingWorker<String, Void>() {
            @Override
            protected String doInBackground() throws Exception {
                return memberController.findNextKodeMember();
            }

            @Override
            protected void done() {
                try {
                    String nextKodeMember = get();
                    txtfKode.setText(nextKodeMember);
                    btnSimpan.setEnabled(true);
                } catch (InterruptedException | ExecutionException ex) {
                    Logger.getLogger(FormBooking.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }.execute();
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHapus;
    private javax.swing.JButton btnKembali;
    private javax.swing.JButton btnPrint;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSimpan;
    private com.toedter.calendar.JDateChooser datcTglDaftar;
    private com.toedter.calendar.JDateChooser datcTglHabis;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txtfAlamat;
    private javax.swing.JTextField txtfBayar;
    private javax.swing.JTextField txtfKode;
    private javax.swing.JTextField txtfNama;
    private javax.swing.JTextField txtfNoKtp;
    private javax.swing.JTextField txtfNoTelp;
    private javax.swing.JTextField txtfSearchInput;
    // End of variables declaration//GEN-END:variables
}
