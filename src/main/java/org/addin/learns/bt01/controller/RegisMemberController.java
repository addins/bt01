/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.controller;

import lombok.extern.slf4j.Slf4j;
import org.addin.learns.bt01.domain.RegisMember;
import org.addin.learns.bt01.repository.RegisMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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
    
    public static final String[] columnNames = new String[]{
        "Kode Member",
        "No. KTP",
        "Nama",
        "Alamat",
        "No. Telp",
        "Tgl Daftar",
        "Tgl Habis",
        "Bayar"
    };
    
    public Page<RegisMember> findAllMember(Pageable page) {
        return memberRepository.findAll(page);
    }
    
    public Page<RegisMember> findAllMemberByKodeLike(String kode, Pageable page) {
        return memberRepository.findAllByKodeLike(kode, page);
    }
    
    public RegisMember save(RegisMember member) {
        return memberRepository.save(member);
    }
    
    public void delete(RegisMember member) {
        memberRepository.delete(member);
    }
}
