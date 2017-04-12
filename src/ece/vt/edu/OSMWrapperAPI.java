package ece.vt.edu;
import java.io.IOException;
import org.xml.sax.*;
import org.xml.sax.helpers.XMLReaderFactory;

public class OSMWrapperAPI{
	public void parse(String city) throws SAXException,IOException {
		// TODO Auto-generated method stub
		XMLReader osmReader = XMLReaderFactory.createXMLReader();
		osmReader.setContentHandler(new OSMSAXHandler(city));
		//osmReader.parse("D:\\Courses\\Spring2017\\Project\\Data_Collection\\mapzen\\chennai_india.osm");		
		//osmReader.parse("D:\\Courses\\Spring2017\\Project\\Data_Collection\\mapzen\\los-angeles_california.osm");
		//osmReader.parse("D:\\Courses\\Spring2017\\Project\\Data_Collection\\mapzen\\blacksburg.osm");
		osmReader.parse(Constants.CityFileMap.get(city));
	}
}

/*
import org.w3c.dom.*;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.*;
public class OSMWrapperAPI {

	public static void main(String[] args) {
		System.out.println("Going to fetch the document...");
		Document osmDoc = getDocument(getDocumentName());
		System.out.println("Root: "+osmDoc.getDocumentElement().getNodeName());
		NodeList nodes = osmDoc.getElementsByTagName("node");
		System.out.println("Number of nodes in the doc "+nodes.getLength());
		
	}
	private static String getDocumentName() {		
		return "D:\\Courses\\Spring2017\\Project\\Data_Collection\\mapzen\\chennai_india.osm";
	}

	private static Document getDocument(String docName) {		
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			factory.setIgnoringComments(true);
			//factory.setValidating(true);
			DocumentBuilder builder = factory.newDocumentBuilder();
			return builder.parse(new InputSource(docName));
		}
		catch (Exception e){
			System.out.println(e.getMessage());
		}
		
		return null;
	}
}
*/