package testPackage;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.junit.Test;

import programLogic.PDFService;

public class PDFServiceTest {

	@Test
	public void testConvertToPdf() {
		fail("Not yet implemented");
	}

	@Test
	public void testSplitPDF() {
		try {
		PDFService pdfService = new PDFService();
		pdfService.splitPDF("D:\\NEWGEN\\mixer.pdf", null);
		}
		catch(Exception e){
			System.out.println("Failed" + e.getMessage());
		}
		
	}

}
