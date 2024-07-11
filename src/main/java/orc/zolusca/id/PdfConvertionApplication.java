package orc.zolusca.id;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class PdfConvertionApplication {
    public static final String FILE_NAME = "src/main/resources/testing.pdf";
    public static final String FILE_IMAGE = "src/main/resources/sample.png";
	public static void main(String[] args) throws IOException {

        try {
//            PdfWritersBuilder.createSimpleTextPdf(FILE_NAME,"example--2");
            PdfWritersBuilder.createImagePdf(FILE_NAME,Helpers.encodeImageToBase64(FILE_IMAGE));
        } catch (NullPointerException e) {
            System.out.println("file not found"+FILE_NAME);
            throw new RuntimeException(e.getMessage());
        }
    }

}
