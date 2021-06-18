package programLogic;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import org.apache.pdfbox.contentstream.PDContentStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.graphics.image.JPEGFactory;
import org.apache.pdfbox.pdmodel.graphics.image.LosslessFactory;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

/*author
 * Saurabh Kumar Maurya 
 * 30 May 2020
 */

public class FileConversion {
	/*
	 * File file = jpg || jpeg || png || gif || bmp || tiff || tif
	 * These extensions are allowed in the File
	 * Single File at a time
	 * return type will be in PDF format
	 * eg: 
	 * PDDocument document=convertToPDF(file);
	 * document.save("path to save the file");
	 * document.close();  
	 */
	public PDDocument convertToPDF(File file) throws IOException {
		String extension = "";
		int index = file.getAbsolutePath().lastIndexOf(".");
		if (index > 0) {
			extension = file.getAbsolutePath().substring(index + 1);
		}
		if (extension.equals("jpg") || extension.equals("jpeg")) {
			FileInputStream in = new FileInputStream(file);
			BufferedImage image = ImageIO.read(file);

			PDDocument document = new PDDocument();
			PDPage page = new PDPage(new PDRectangle(image.getWidth(), image.getHeight()));
			document.addPage(page);
			PDImageXObject pdImageXObject = LosslessFactory.createFromImage(document, image);
			// PDImageXObject pdImageXObject = JPEGFactory.createFromImage(document, image);
			PDPageContentStream contents = new PDPageContentStream(document, page);
			contents.drawImage(pdImageXObject, 20, 20);
			contents.close();

			System.out.println("Completed");
			return document;

		} else if (extension.equals("tiff") || extension.equals("tif")) {
			ImageInputStream imageInputStream = ImageIO.createImageInputStream(file);
			Iterator<ImageReader> it = ImageIO.getImageReaders(imageInputStream);
			if (it == null || !it.hasNext()) {
				throw new IOException("Image File Format Not Supported by ImageIO : " + file.getAbsolutePath());
			}
			ImageReader reader = (ImageReader) it.next();
			it = null;
			reader.setInput(imageInputStream);

			// Number of Pages
			System.out.println(reader.getNumImages(true));

			// to read image separately
			// reader.read(index);

			// Create a new pdfdocument
			PDDocument document = new PDDocument();
			// For adding pages to pdf
			PDPageContentStream contents;
			for (int i = 0; i < reader.getNumImages(true); i++) {
				PDImageXObject pdImage;
				// System.out.println("Width : "+reader.read(i).getWidth()+" | Height :
				// "+reader.read(i).getHeight());
				// Create page size as that of image
				PDPage page = new PDPage(new PDRectangle(reader.read(i).getWidth(), reader.read(i).getHeight()));
				// Create pages of A4 size
				// PDPage page = new PDPage(new PDRectangle(2480,3508));
				document.addPage(page);
				pdImage = LosslessFactory.createFromImage(document, reader.read(i));
				contents = new PDPageContentStream(document, page);
				// draw the image at full size at (x=20, y=20)
				contents.drawImage(pdImage, 20, 20);
				contents.close();
			}
			// document.save("D:\\pdfbox\\Demo.pdf");
			// document.close();

			System.out.println("Completed");
			return document;

		} else if (extension.equals("png") || extension.equals("bmp") || extension.equals(".gif")) {
			FileInputStream in = new FileInputStream(file);
			BufferedImage image = ImageIO.read(file);

			PDDocument document = new PDDocument();
			PDPage page = new PDPage(new PDRectangle(image.getWidth(), image.getHeight()));
			document.addPage(page);
			PDImageXObject pdImageXObject = LosslessFactory.createFromImage(document, image);
			// PDImageXObject pdImageXObject = JPEGFactory.createFromImage(document, image);
			PDPageContentStream contents = new PDPageContentStream(document, page);
			contents.drawImage(pdImageXObject, 20, 20);
			contents.close();

			System.out.println("Completed");
			return document;
		}
		return null;
	}

	/*
	 * ArrayList file = {jpg ,jpeg ,png ,gif ,bmp ,tiff ,tif}
	 * These extensions are allowed in the array list
	 * This arrayList can be heterogeneous or homogeneous in nature
	 * return type will be in PDF format
	 * eg: 
	 * PDDocument document=convertToPDF(file);
	 * document.save("path to save the file");
	 * document.close();  
	 */
	public PDDocument convertToPDF(ArrayList<File> file) throws Exception {
		String extension = "";
		PDDocument document = new PDDocument();
		PDPage page;
		PDPageContentStream contents = null;
		PDImageXObject pdImageXObject;
		for (int lcount = 0; lcount < file.size(); lcount++) {
			int index = file.get(lcount).getAbsolutePath().lastIndexOf(".");
			if (index > 0) {
				extension = file.get(lcount).getAbsolutePath().substring(index + 1);
			}else {
				throw new Exception("File invalid or corrupted");
			}
			if(extension.equals("jpg") || extension.equals("jpeg")) {
				
				FileInputStream inputStream = new FileInputStream(file.get(lcount));
				BufferedImage image = ImageIO.read(inputStream);
				page = new PDPage(new PDRectangle(image.getWidth(), image.getHeight()));
				document.addPage(page);
				pdImageXObject = LosslessFactory.createFromImage(document, image);
				// PDImageXObject pdImageXObject = JPEGFactory.createFromImage(document, image);
				contents = new PDPageContentStream(document, page);
				contents.drawImage(pdImageXObject, 20, 20);

			}else if (extension.equals("tiff") || extension.equals("tif")) {
				ImageInputStream imageInputStream = ImageIO.createImageInputStream(file.get(lcount));
				Iterator<ImageReader> it = ImageIO.getImageReaders(imageInputStream);
				if (it == null || !it.hasNext()) {
					throw new Exception("Image File Format Not Supported by ImageIO : " + file.get(lcount).getAbsolutePath());
				}
				ImageReader reader = (ImageReader) it.next();
				it = null;
				reader.setInput(imageInputStream);
				// Number of Pages
				//System.out.println(reader.getNumImages(true));

				// to read image separately
				// reader.read(index);
				for (int i = 0; i < reader.getNumImages(true); i++) {
					
					// System.out.println("Width : "+reader.read(i).getWidth()+" | Height :
					// "+reader.read(i).getHeight());
					// Create page size as that of image
					page = new PDPage(new PDRectangle(reader.read(i).getWidth(), reader.read(i).getHeight()));
					// Create pages of A4 size
					// PDPage page = new PDPage(new PDRectangle(2480,3508));
					document.addPage(page);
					pdImageXObject = LosslessFactory.createFromImage(document, reader.read(i));
					contents = new PDPageContentStream(document, page);
					// draw the image at full size at (x=20, y=20)
					contents.drawImage(pdImageXObject, 20, 20);
					contents.close();
				}
				// document.save("D:\\pdfbox\\Demo.pdf");
				// document.close();

			} else if (extension.equals("png") || extension.equals("bmp") || extension.equals(".gif")) {
				FileInputStream in = new FileInputStream(file.get(lcount));
				BufferedImage image = ImageIO.read(in);

				page = new PDPage(new PDRectangle(image.getWidth(), image.getHeight()));
				document.addPage(page);
				pdImageXObject = LosslessFactory.createFromImage(document, image);
				// PDImageXObject pdImageXObject = JPEGFactory.createFromImage(document, image);
				contents = new PDPageContentStream(document, page);
				contents.drawImage(pdImageXObject, 20, 20);
			}
			else {
				System.out.print("File Extension Not Supported : "+ extension);
			}
		}
		contents.close();
		return document;
	}
	
	public File convertToJPEG(File file) {
		String extension = "";
		int index = file.getAbsolutePath().lastIndexOf(".");
		if (index > 0) {
			extension = file.getAbsolutePath().substring(index + 1);
		}
		
		return null;
	}

	public static void main(String args[]) throws IOException {
		File file = new File("D:\\Personal\\me.jpg");
		FileConversion fc = new FileConversion();
		PDDocument document = new PDDocument();
		document = fc.convertToPDF(file);
		document.save("D:\\pdfbox\\demo.pdf");
	}
}