import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import com.plutext.converter.ConversionException;
import com.plutext.converter.Convert;
import com.plutext.converter.Format;


/**
 * This sample code uses the com.plutext.converter package
 * to convert a docx file to a PDF file
 * using the PDF Converter web service.
 */
public class Sample {

	public static void main(String[] args) throws IOException  {
		
		File fileIN = new java.io.File(
				System.getProperty("user.dir")
					+ "/src/sample/resources/hello.docx");

		File fileOUT = new java.io.File(
				System.getProperty("user.dir") + "/output.pdf");
		
		// TODO: you must configure the endpoint URL in com.plutext.converter.Convert
		Convert converter = new Convert(); 

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
