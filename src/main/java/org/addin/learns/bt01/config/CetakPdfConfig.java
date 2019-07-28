package org.addin.learns.bt01.config;

import org.addin.learns.bt01.utils.CetakPdfService;
import org.addin.learns.bt01.utils.impl.CetakPdfThymeleafEngine;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

/**
 *
 * @author Addin
 */
@Configuration
public class CetakPdfConfig {
    @Bean
    public TemplateEngine cetakPdfEngine() {
        ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
        templateResolver.setSuffix(".html");
        templateResolver.setTemplateMode("HTML");
        
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.setTemplateResolver(templateResolver);
        return templateEngine;
    }
    
    @Bean
    public CetakPdfService cetakPdfService() {
        return new CetakPdfThymeleafEngine(cetakPdfEngine());
    }
}
