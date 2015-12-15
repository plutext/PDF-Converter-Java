import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
//import org.apache.commons.io.IOUtils;


import com.plutext.converter.ConversionException;
import com.plutext.converter.Converter;
import com.plutext.converter.ConverterHttp;
import com.plutext.converter.Format;


/**
 * This sample code uses the com.plutext.converter package
 * to convert a docx file to a PDF file
 * using the PDF Converter web service.
 */
public class Sample {
	
	// ++++++++++++++++++++++++++++++++++++
	// Configuration

	// 1. Specify input doc/docx
	static String prefix = "Word2007-fonts";
	
	static File fileIN = new java.io.File(
			System.getProperty("user.dir")
				//+ "/src/sample/resources/hello.docx");
			+ "/docx/" + prefix + ".docx");
	
	// 2. Specify output pdf
	static File fileOUT = new java.io.File(
			System.getProperty("user.dir") + "/" + prefix + ".pdf");
	
	// 3. configure your endpoint URL here
	static String host = "converter-eval.plutext.com";
	static int port = 80;
	static int productVersion =2; 
	
	static String URL = null;	
	static {
		
		if (productVersion <2) {
			URL = "http://" + host + ":" + port + "/plutext/converter"; 
		} else {
			// PDF Converter v2
			URL = "http://" + host + ":" + port + "/v1/00000000-0000-0000-0000-000000000000/convert"; 			
		}
		
	}
	
	

	public static void main(String[] args) throws IOException  {		
		
		// Create a converter object, specifying the endpoint
		Converter converter = new ConverterHttp(URL); 
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		try {
			
			// Perform the conversion
			converter.convert(fileIN, Format.DOCX, Format.PDF, baos);

			// Alternatively
//			converter.convert(IOUtils.toByteArray(FileUtils.openInputStream(fileIN)), 
//					Format.DOCX, Format.PDF, baos);			
			
			// Alternatively, if your server config supports it
			// converter.convert(FileUtils.openInputStream(fileIN), Format.DOCX, Format.PDF, baos);
			
			FileUtils.writeByteArrayToFile(fileOUT, baos.toByteArray());
			System.out.println("It worked...");

		} catch (ConversionException e) {
			
			if (e.getResponse()!=null) {
				System.err.println(""+ e.getResponse().getStatusLine());
			}
			System.err.println("Something went wrong...");
			e.printStackTrace();
			System.err.println(new String(baos.toByteArray(), "UTF-8")); 
		} 
		
		
	}	
}
