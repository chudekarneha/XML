import java.io.File;
import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.w3c.dom.Document;

public class DomParserSchema 
{
	
 public static void main(String[] args) 
 {
	 String schema_Name = "AccountBankingSchema.xsd";
	 String xml_Name = "AccountBanking.xml";
	 Schema schema = loadSchema(schema_Name);
	 Document doc = parseXmlDom(xml_Name);
	 if(doc!=null)
	 {
		 validateXml(schema, doc);
	 }
 }
 
 public static void validateXml(Schema schema, Document doc) 
 {
  try 
  {
	  Validator validator = schema.newValidator();
	  validator.validate(new DOMSource(doc));
	  System.out.println("\n *** Validation Successful ***");
  } 
  catch (Exception excep) 
  {
   System.out.println(excep.toString());
   System.out.println("\n\n *** Validation Exception ***");
  }
 }
 
 public static Schema loadSchema(String schema_FName) 
 {
	 Schema schema = null;
	 try 
	 {
		 String lang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
		 SchemaFactory fact = SchemaFactory.newInstance(lang);
		 schema = fact.newSchema(new File(schema_FName));
	 } 
	 catch (Exception excep) 
	 {
		 System.out.println(excep.toString());
		 
	 }
	 return schema;
 }
 
 public static Document parseXmlDom(String xml_Name) 
 {
	 Document document = null;
	 try 
	 {
		 DocumentBuilderFactory fact = DocumentBuilderFactory.newInstance();
		 DocumentBuilder builder = fact.newDocumentBuilder();
		 document = builder.parse(new File(xml_Name));
		 System.out.println("\n\n *** Parsing Successful ***");
	 } 
	 catch (Exception excep) 
	 {
		 System.out.println(excep.toString());
		 System.out.println("\n\n *** Parsing Exception *** \n\n");
	 }
	 return document;
 }
}
