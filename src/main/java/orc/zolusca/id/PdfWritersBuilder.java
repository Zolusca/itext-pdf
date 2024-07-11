package orc.zolusca.id;


import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.Paragraph;
import org.apache.commons.codec.binary.Base64;
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

    public static void createImagePdf(String pathFilePdf,String imageBase64){

        try(
                PdfDocument pdf = new PdfDocument(new PdfWriter(pathFilePdf));
        )
        {
            PageSize pageSize = PageSize.A4;

            Document document = new Document(pdf,pageSize);

            byte[] data = Base64.decodeBase64(imageBase64);

            Image image = new Image(ImageDataFactory.create(data));
            document.add(image);
            document.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
