package programLogic;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.impl.Log4JLogger;
import org.apache.pdfbox.multipdf.Splitter;
import org.apache.pdfbox.pdmodel.PDDocument;

public class PDFService {
	
	public void splitPDF(String file,String path) throws IOException {
		 //Loading an existing PDF document 
	      PDDocument doc = PDDocument.load(new File(file)); 
	      
	      //Instantiating Splitter class 
	      Splitter splitter = new Splitter(); 
	      
	      //splitting the pages of a PDF document 
	      List<PDDocument> Pages = splitter.split(doc); 

	      //Creating an iterator 
	      Iterator<PDDocument> iterator = Pages.listIterator();         

	      //Saving each page as an individual document 
	      int i = 1; 
	      
	      while(iterator.hasNext()){ 
	         PDDocument pd = iterator.next(); 
	         pd.save(path+ i++ +".pdf");             
	      } 
	      
	   } 
	
	}

