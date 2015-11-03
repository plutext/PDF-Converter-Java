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

	public static void main(String[] args) throws IOException  {
		
		String prefix = "Word2007-fonts";
		
		File fileIN = new java.io.File(
				System.getProperty("user.dir")
					//+ "/src/sample/resources/hello.docx");
				+ "/docx/" + prefix + ".docx");
		
		File fileOUT = new java.io.File(
				System.getProperty("user.dir") + "/" + prefix + ".pdf");
		
		// TODO: configure your endpoint URL here
		String URL = "http://converter-eval.plutext.com/plutext/converter";
		
		
		Converter converter = new ConverterHttp(URL); 
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		try {
			
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
