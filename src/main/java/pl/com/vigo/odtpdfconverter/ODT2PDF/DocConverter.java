package pl.com.vigo.odtpdfconverter.ODT2PDF;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.images.FileImageProvider;
import fr.opensagres.xdocreport.document.images.IImageProvider;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;
import fr.opensagres.xdocreport.template.formatter.FieldsMetadata;

public class DocConverter {
    public void konwertuj() {
        try {
// Ładujemy nasz template
            InputStream in = new FileInputStream(new File("templatka.odt"));
            IXDocReport report =
                    XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Freemarker);
// pobieramy elementy z dokumentu
            FieldsMetadata metadata = new FieldsMetadata();
            metadata.addFieldAsList("developers.Name");
            metadata.addFieldAsList("developers.LastName");
            metadata.addFieldAsList("developers.Mail");
            metadata.addFieldAsImage("logo");
            report.setFieldsMetadata(metadata);
// tworzymy kontekst
            IContext context = report.createContext();
            IImageProvider logo = new FileImageProvider(new File("logo.png"),
                    true);
// zmieniamy wymiary logo
            logo.setHeight((float) 240);
            logo.setWidth((float) 550);
// zamieszczamy wszystkie nasze obiekty
            context.put("project", MapProvider.getProjectMap());
            context.put("developers", MapProvider.getDevelopers());
            context.put("logo", logo);
// Tworzymy plik ODT z wynikiem
            OutputStream out = new FileOutputStream(new File("outputfreemarker - map.odt"));
                    report.process(context, out);
// Tworzymy plik PDF z wynikiem
            OutputStream pdfOut = new FileOutputStream(new File("outputfreemarker - map - odt.pdf"));
                    Options options =
                    Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.ODFDOM);
            report.convert(context, options, pdfOut);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XDocReportException e) {
            e.printStackTrace();
        }
    }
}
