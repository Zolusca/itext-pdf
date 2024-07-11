package orc.zolusca.id;


import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import java.io.FileNotFoundException;
import java.io.IOException;

public class PdfWritersBuilder {
    public static void createSimpleTextPdf(String pathFileName,String text){

        try(
                PdfWriter writer = new PdfWriter(pathFileName);
                PdfDocument pdf = new PdfDocument(writer);
                Document document = new Document(pdf);
        )
        {
            document.add(new Paragraph(text));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
