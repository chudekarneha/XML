import java.io.FileInputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DomParserDTD 
{
	public static void main(String args[]) 
	{	
		try
		{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setValidating(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			builder.setErrorHandler(new org.xml.sax.ErrorHandler() {
				
			public void fatalError(SAXParseException exception)throws SAXException { }
				 
			public void error(SAXParseException excep)throws SAXParseException 
			{
				System.out.println("Error at " +excep.getLineNumber() + " line.");
				System.out.println(excep.getMessage());
				System.exit(0);
			}
			
			public void warning(SAXParseException error)throws SAXParseException
			{
				System.out.println(error.getMessage());
				System.exit(0);
			}});
			
			Document xmlDoc = builder.parse(new FileInputStream("AccountBanking.xml"));
			System.out.println("\n\n *** Parsing Successful ***");
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("\n\n *** Parsing Exception ***");
		}
	}
}