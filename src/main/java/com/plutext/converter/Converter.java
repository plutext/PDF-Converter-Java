package com.plutext.converter;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


/**
 * Java client library interface for Plutext PDF Converter
 * 
 * For an example of how to use, please see 
 * https://github.com/plutext/PDF-Converter-Java/blob/master/src/sample/java/Sample.java
 *
 */
public interface Converter {
	
	/** There is no signature here for converting from a WordMLPackage, since
	 *  then docx4j would be a dependency.
	 *  
	 *  Better for docx4j 3 to have converter as a dependency, and extend to
	 *  implement that.
	 */

	/**
	 * Convert File fromFormat to toFormat, streaming result to OutputStream os.
	 * 
	 * fromFormat supported: DOC, DOCX
	 * 
	 * toFormat supported: PDF
	 * 
	 * @param f
	 * @param fromFormat
	 * @param toFormat
	 * @param os
	 * @throws IOException
	 * @throws ConversionException
	 */
	public void convert(File f, Format fromFormat, Format toFormat, OutputStream os) throws IOException, ConversionException;



	/**
	 * Convert InputStream fromFormat to toFormat, streaming result to OutputStream os.
	 * 
	 * fromFormat supported: DOC, DOCX
	 * 
	 * toFormat supported: PDF
	 * 
	 * Note this uses a non-repeatable request entity, so it may not be suitable
	 * (depending on the endpoint config).
	 * 
	 * @param instream
	 * @param fromFormat
	 * @param toFormat
	 * @param os
	 * @throws IOException
	 * @throws ConversionException
	 */
	public void convert(InputStream instream, Format fromFormat, Format toFormat, OutputStream os) throws IOException, ConversionException;


	/**
	 * Convert byte array fromFormat to toFormat, streaming result to OutputStream os.
	 * 
	 * fromFormat supported: DOC, DOCX
	 * 
	 * toFormat supported: PDF
	 * 
	 * @param bytesIn
	 * @param fromFormat
	 * @param toFormat
	 * @param os
	 * @throws IOException
	 * @throws ConversionException
	 */
	public void convert(byte[] bytesIn, Format fromFormat, Format toFormat, OutputStream os) throws IOException, ConversionException;
	
}