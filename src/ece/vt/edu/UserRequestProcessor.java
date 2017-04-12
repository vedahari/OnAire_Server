package ece.vt.edu;

import java.io.IOException;
import java.util.ArrayList;

import org.xml.sax.SAXException;

public class UserRequestProcessor {

	private static KdTreeFactory factory=null;
	
	public UserRequestProcessor() {
		//factory = new KdTreeFactory();
	}
	
	public static void initialize(){
		factory = new KdTreeFactory();
		factory.addCity(Constants.SF);
		OSMWrapperAPI osmWrapper = new OSMWrapperAPI();
		try {
			osmWrapper.parse(Constants.SF);
		} catch (SAXException | IOException e) {			
			e.printStackTrace();
		}
	}
		
	public static void actual_main(String[] args) {
		//initialize the server
		initialize();
		//wait for the client/user request
		//BoundBox box = new BoundBox (33.298,-119.437,34.583,-116.724);
		//BB BoundBox box = new BoundBox (37.1751293,-80.4912875,37.2855176,-80.3675103);
		BoundBox box = new BoundBox (37.449,-122.737,37.955,-122.011);		
		ArrayList<Integer> stopTimeList = (ArrayList<Integer>) KdTreeFactory.getKdTree(Constants.SF).range(box);
		System.out.println("The Stop time list size is "+stopTimeList.size());
	}
	
	public static void main(String[] args){
		System.out.println("Test Main is called");
		OnAire oOnAire = new OnAire();
		oOnAire.vInitialize();
		oOnAire.vExecute();
	}
	
	
}
