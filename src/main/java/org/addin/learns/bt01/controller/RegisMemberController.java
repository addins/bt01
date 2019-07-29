/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.controller;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import lombok.extern.slf4j.Slf4j;
import org.addin.learns.bt01.domain.RegisMember;
import org.addin.learns.bt01.repository.RegisMemberRepository;
import org.addin.learns.bt01.ui.FormRegisterMember;
import org.addin.learns.bt01.utils.CetakPdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.thymeleaf.context.Context;

/**
 *
 * @author addin
 */
@Slf4j
@Transactional
@Component
public class RegisMemberController {

    @Autowired
    private RegisMemberRepository memberRepository;

    @Autowired
    private CetakPdfService cetakPdfService;

    public Page<RegisMember> findAllMember(Pageable page) {
        return memberRepository.findAll(page);
    }

    public Page<RegisMember> findAllMemberByKodeLike(String kode, Pageable page) {
        return memberRepository.findAllByKodeLike(kode, page);
    }

    public RegisMember findOne(Long id) {
        final RegisMember member = memberRepository.getOne(id);
        member.getId();
        member.getKode();
        member.getNoKtp();
        member.getNama();
        member.getAlamat();
        member.getNoTelp();
        member.getTglDaftar();
        member.getTglHabis();
        member.getBayar();
        return member;
    }

    public RegisMember save(RegisMember member) {
        return memberRepository.save(member);
    }

    public void delete(RegisMember member) {
        memberRepository.delete(member);
    }

    public void delete(Long id) {
        memberRepository.deleteById(id);
    }

    public void cetakKartuMemberPdf(String nama, String tglHabis) throws IOException, FileNotFoundException, DocumentException {

        Context context = new Context();
        context.setVariable("nama", nama);
        context.setVariable("tglHabis", tglHabis);

        final String pdfFilePath = "kartu-member.pdf";
        cetakPdfService.renderToFile(CetakPdfService.kartuMember, context, pdfFilePath);
    }

    public void cetakKartuMemberPdf(Long selectedMemberId) throws IOException, FileNotFoundException, DocumentException {
        RegisMember one = findOne(selectedMemberId);
        
        Context context = new Context();
        context.setVariable("kode", one.getKode());
        context.setVariable("nama", one.getNama());
        context.setVariable("tglDaftar", one.getTglDaftar().format(DateTimeFormatter.ISO_LOCAL_DATE));
        context.setVariable("tglHabis", one.getTglHabis().format(DateTimeFormatter.ISO_LOCAL_DATE));

        final String pdfFilePath = "kartu-member.pdf";
        cetakPdfService.renderToFile(CetakPdfService.kartuMember, context, pdfFilePath);
    }

    public String findNextKodeMember() {
        String kode = "MEM-";
        Long maxId = memberRepository.getMaxId();
        kode += String.format("%03d", maxId + 1);
        return kode;
    }
}