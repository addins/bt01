/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.addin.learns.bt01.utils.impl;

import com.itextpdf.text.DocumentException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.addin.learns.bt01.utils.CetakPdfService;
import org.addin.learns.bt01.utils.CetakType;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

/**
 *
 * @author Addin
 */
@Service
public class CetakPdfThymeleafEngine implements CetakPdfService {

    private final TemplateEngine templateEngine;

    public CetakPdfThymeleafEngine(TemplateEngine cetakPdfEngine) {
        this.templateEngine = cetakPdfEngine;
    }

    @Override
    public void renderToFile(CetakType type, Context context, String pdfFilePath) throws FileNotFoundException, DocumentException, IOException {
        render(type, context, pdfFilePath);
    }

    private void render(CetakType type, Context context, String pdfFilePath) throws FileNotFoundException, DocumentException, IOException {
        String html = templateEngine.process(type.getTemplate(), context);
        OutputStream os = new FileOutputStream(pdfFilePath);
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(html);
        renderer.layout();
        renderer.createPDF(os);
        os.close();
    }

}
