package org.addin.learns.bt01;

import java.awt.EventQueue;
import javax.swing.JFrame;
import org.addin.learns.bt01.ui.MenuUtama;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = "org.addin.learns")
public class App extends JFrame
{
    @Autowired
    private MenuUtama menuUtama;
    
    public static void main( String[] args )
    {        
        var ctx = new SpringApplicationBuilder(App.class)
                .headless(false)
                .run(args);
        
        EventQueue.invokeLater(() -> {
            var app = ctx.getBean(MenuUtama.class);
            app.setVisible(true);
        });
    }
}
