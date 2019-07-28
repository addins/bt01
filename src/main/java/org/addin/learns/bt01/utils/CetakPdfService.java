/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.utils;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.thymeleaf.context.Context;

/**
 *
 * @author Addin
 */
public interface CetakPdfService {
    public final CetakType kartuMember = new CetakType("kartuMember", "templates/kartu-member");
    public final CetakType buktiBayar = new CetakType("buktiBayar", "templates/bukti-bayar");

    public void renderToFile(CetakType kartuMember, Context context, String pdfFilePath) throws FileNotFoundException, DocumentException, IOException ;
}
