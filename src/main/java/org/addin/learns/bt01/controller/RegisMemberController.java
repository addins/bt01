/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.controller;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;
import org.xhtmlrenderer.pdf.ITextRenderer;

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

    public void cetakKartuMemberPdf(String nama, String tglHabis) {
                
        Context context = new Context();
        context.setVariable("nama", nama);
        context.setVariable("tglHabis", tglHabis);
        
        final String pdfFilePath = "kartu-member.pdf";
        try {
            cetakPdfService.renderToFile(CetakPdfService.kartuMember, context, pdfFilePath);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(FormRegisterMember.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException | IOException ex) {
            Logger.getLogger(FormRegisterMember.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
