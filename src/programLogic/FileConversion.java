package programLogic;


import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

import org.apache.commons.io.FileUtils;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.media.jai.codec.ImageCodec;
import com.sun.media.jai.codec.ImageDecoder;
import com.sun.media.jai.codec.TIFFDecodeParam;


/*author
 * Saurabh Kumar Maurya 
 * 30 May 2020
 */

public class FileConversion {
	
	public static final String FILE_SEPRATOR = System.getProperty("file.separator");
	public JProgressBar jb;
	public static String logpath = null;
	public String logmessage = null;
	
	public void Tiff2Pdf(String path) throws IOException {		
		      try {
	
		        File fileSrc = new File(path);							//Get the source directory from JFileChooser
		       
		        //Log Path 
		        logpath = path + "/log.txt";
		        LogCreator.logwriter("Process Started ",logpath);
		        
		        //Extensions to filter tif file
				String[] tif_exts = new String[] { "tiff" ,"tif"};
		        
				//Used to list all directory with contain tif image
				List<File> files = (List<File>) FileUtils.listFiles(fileSrc, tif_exts, true);
				
				System.out.println(" File count  : " +files.size());

			    
				int count = 0;
				 
				//Loop start to fetch all tif to convert PDF
				
				for (File file : files) {
				 
					count +=1;					 
					
					String destFileName = file.getName().substring(0, file.getName().lastIndexOf("."))+".pdf";
					
					String srcFile = file.getCanonicalPath();
					String destFile = file.getParent()+FILE_SEPRATOR+destFileName;
					
					logmessage = count +". Source Path : "+ srcFile +"     Destignation Path : "+destFile;
					LogCreator.logwriter(logmessage,logpath);
					
					//Check whether File converted to PDF 
					File pdfFiles = new File(destFile);
					if(!pdfFiles.exists()){
						convertStart(srcFile,destFile);
					}
					 
				}
				
				LogCreator.logwriter("Process Completed ",logpath);
				JOptionPane.showMessageDialog(null, "Completed");
				
				
		      } catch (ArrayIndexOutOfBoundsException e) {
		    	  LogCreator.logwriter("Error : "+e.toString(),logpath);  
		          JOptionPane.showMessageDialog(null, " Please try again");
		      }
	}
	
	public boolean convertStart(String sourcefile,String targetfile) throws IOException{			
        
        try {
        	
        	 float width = 2480;
             float height = 3508;
             
             Rectangle rect = new Rectangle(width,height);
             
	         //PDF conversation starts here 
             Document document = new Document(rect);
	    	    
	    	 FileOutputStream fos = new FileOutputStream(targetfile);
	    	 PdfWriter writer = PdfWriter.getInstance(document, fos);	   
	    	 writer.open();
	    	 document.open();
	    	 
        	 Iterator readers=javax.imageio.ImageIO.getImageReadersBySuffix("tiff");
        	  
        	  if (readers.hasNext()) {
        		  
        		  File srcFile=new File(sourcefile);
        		  
        		  ImageInputStream iis=javax.imageio.ImageIO.createImageInputStream(srcFile);
      		      TIFFDecodeParam param=null;
      		      ImageDecoder dec=ImageCodec.createImageDecoder("tiff",srcFile,param);
    		      int pageCount=dec.getNumPages();
    		      ImageReader _imageReader=(ImageReader)(readers.next());
        		  
    		      if (_imageReader != null) {
    		    	  
    			      _imageReader.setInput(iis,true);
    			      
    			      for (int i=0; i < pageCount; i++) {
	    			    	//Read the source file (tiff)
	    		        	  BufferedImage srcImg = _imageReader.read(i);  
	    		        	  BufferedImage img2 = new BufferedImage(srcImg.getWidth(), srcImg.getHeight(), 
	    	        				  BufferedImage.TYPE_INT_RGB);
	    		        	  	    	        	    
	    		        	
	    	        		//Set the RGB values for converted image (jpg)
	    	        	    for(int y = 0; y < srcImg.getHeight(); y++) {
	    	        	      for(int x = 0; x < srcImg.getWidth(); x++) {
	    	        	        img2.setRGB(x, y, srcImg.getRGB(x, y));
	    	        	      }
	    	        	    }
	    	        	  /*  
	    	        	    String s = "C:/Users/shrisowdhaman/Desktop/TIFF/A-04-000001/sample"+i+".jpg";
	    	        	    ImageIO.write(img2, "jpg", new File(s));
	    	        	    */
	    	        	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    	        	    ImageIO.write(img2, "jpg", baos);
	    	        	    baos.flush();
	    	
	    	        	    // Convert byteArrayoutputSteam to ByteArray
	    	        	    byte[] imageInByte = baos.toByteArray();
	    	        	    
	    	        	    
	    	        	    document.add(Image.getInstance(imageInByte));
	    	        	   
	    	        	    System.out.println("Page: " + (i + 1)  );
	    	        	    baos.close();
	    	        	    
    			      }//End of for loop
    			      
    			    //Close all open methods
  	        	    document.close();
  	        	    writer.close();
  	        	    fos.close();
  	        	   
    		      }else{
	        		  LogCreator.logwriter("Image is null for file :" + targetfile,logpath); 
	        	      return false;
	        	  }
        	  }
        	} catch (Exception e) {
        		LogCreator.logwriter("Error : "+e.getMessage().toString(), logpath);
        		return false;
        	}

          return true;
	}
	
	 
	public static void main(String[] args) throws IOException {
		 FileConversion fc=new FileConversion();
		 fc.Tiff2Pdf("D:\\NEWGEN\\");

	}

}