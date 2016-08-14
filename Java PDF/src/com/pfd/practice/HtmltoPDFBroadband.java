package com.pfd.practice;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

import com.itextpdf.text.Document;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;

public class HtmltoPDFBroadband {
	
	static String htmlFile = "/Users/prathore2/Desktop/broadband/jan151/jan15.html";
	 static String month="Jan";
	static String pdfFile = "/Users/prathore2/PRATEEK/Developer/temp/ACT_"+month+"_15_.pdf";

	public static void main(String ... args ) {
	    try {
	      Document document = new Document(PageSize.LETTER);
		  PdfWriter.getInstance(document, new FileOutputStream(pdfFile));
	      document.open();
	     
	      HTMLWorker htmlWorker = new HTMLWorker(document);
	      String str = readFile( htmlFile);
	      htmlWorker.parse(new StringReader(str));
	      document.close();
	      }
	    catch (Exception e) {
	      e.printStackTrace();
	    }
	    
	    
	
	}

	
	
	
	
	
	
	
	private static String readFile(String file) {
		BufferedReader br = null;
		StringBuilder builder= new StringBuilder("");
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader(file));
			while ((sCurrentLine = br.readLine()) != null) {
				builder.append(sCurrentLine);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return builder.toString();
	}
}
