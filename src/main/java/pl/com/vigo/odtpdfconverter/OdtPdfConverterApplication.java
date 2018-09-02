package pl.com.vigo.odtpdfconverter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.com.vigo.odtpdfconverter.ODT2PDF.DocConverter;
import pl.com.vigo.odtpdfconverter.ODT2PDF.ODT2PDF;

@SpringBootApplication
public class OdtPdfConverterApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OdtPdfConverterApplication.class, args);
        DocConverter docConverter = new DocConverter();
        docConverter.konwertuj();
    }
}
