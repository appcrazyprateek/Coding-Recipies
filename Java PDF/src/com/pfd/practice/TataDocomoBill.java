package com.pfd.practice;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PRStream;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
public class TataDocomoBill {
	
	public static final String SRC = "bill.pdf";
    public static final String DEST = "bill1.pdf";
 
    public static void main(String[] args) throws IOException, DocumentException {
        File file = new File(DEST);
        //file.getParentFile().mkdirs();
        new TataDocomoBill().manipulatePdf(SRC, DEST);
    }
 
    public void manipulatePdf(String src, String dest) throws IOException, DocumentException {
        
    	
    	PdfReader reader = new PdfReader(src);
        PdfDictionary dict = reader.getPageN(1);
        PdfObject object = dict.getDirectObject(PdfName.CONTENTS);
        if (object instanceof PRStream) {
            PRStream stream = (PRStream)object;
            byte[] data = PdfReader.getStreamBytes(stream);
            
            setFields(stream, data);
        }
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        stamper.close();
        reader.close();
    }

	private void setFields(PRStream stream, byte[] data) throws IOException { // Bill Date 
  		
		//Page of
		stream.setData(new String(data).replace("of 15","of 1").getBytes());
		
		data = PdfReader.getStreamBytes(stream);
		//Bill Date
		stream.setData(new String(data).replace("08/01/15", "26/01/15").getBytes());
   		 
  		 //Due Date 
   		data = PdfReader.getStreamBytes(stream);
  		 stream.setData(new String(data).replace("25/01/15", "15/02/15").getBytes());
  		 
  		data = PdfReader.getStreamBytes(stream);
  		 //Bill Period
  		 stream.setData(new String(data).replace("06/12/14", "23/12/14").getBytes());
  		 data = PdfReader.getStreamBytes(stream);
  		 stream.setData(new String(data).replace("05/01/15", "22/01/15").getBytes());
  		 
  		
  		 
  		data = PdfReader.getStreamBytes(stream);
  		 //Dynamic Credit Limit
  		 stream.setData(new String(data).replace("1200", "2500").getBytes());
  		 
  		data = PdfReader.getStreamBytes(stream);
  		 //Monthly Rental
  		// stream.setData(new String(data).replace("1200", "2500").getBytes());
  		 
  		data = PdfReader.getStreamBytes(stream);
  		 //Usage Charges
  		 stream.setData(new String(data).replace("521", "1221").getBytes());
  		 	
  		data = PdfReader.getStreamBytes(stream);
  		 //Data Usage
  		 stream.setData(new String(data).replace("260", "980").getBytes());
  		 
  		 
  		data = PdfReader.getStreamBytes(stream);
  		 //VAS Charges
  		 stream.setData(new String(data).replace("3.90", "93.90").getBytes());
  		 
  		data = PdfReader.getStreamBytes(stream);
  		 //Roaming Charges
  		 //stream.setData(new String(data).replace("0.00", "2500").getBytes());
  		 
  		data = PdfReader.getStreamBytes(stream);
  		 //Discounts
  		 stream.setData(new String(data).replace("603", "219").getBytes());

  		data = PdfReader.getStreamBytes(stream);
  		 //Sub Totals
  		 stream.setData(new String(data).replace("339.10", "2076.61").getBytes());
  		 
  		data = PdfReader.getStreamBytes(stream);
  		 //Service Tax
  		 stream.setData(new String(data).replace("41.91", "256.47").getBytes());
  		 
  		 
  		data = PdfReader.getStreamBytes(stream);
  		 //Current Charges
  		 stream.setData(new String(data).replace("381", "2331").getBytes());
           
           }

    
	
	
    
}
