package ece.vt.edu;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class Constants {
	public static final String SF = "SanFrancisco";
	public static final String SF_PATH = "D:\\Courses\\Spring2017\\Project\\Data_Collection\\mapzen\\san-francisco_california.osm";
	
	public static final String CHE = "Chennai";
	public static final String CHE_PATH = "D:\\Courses\\Spring2017\\Project\\Data_Collection\\mapzen\\chennai_india.osm";
	
	public static final String LA = "LosAngeles";
	public static final String LA_PATH = "D:\\Courses\\Spring2017\\Project\\Data_Collection\\mapzen\\los-angeles_california.osm";
	
	public static final String BB = "Blacksburg";
	public static final String BB_PATH = "D:\\Courses\\Spring2017\\Project\\Data_Collection\\mapzen\\blacksburg.osm";
	
	
	public static final Map<String,String> CityFileMap;
	static{
		Map<String,String> fileMap = new HashMap<String,String>();
		fileMap.put(Constants.SF,Constants.SF_PATH);
		fileMap.put(Constants.CHE,Constants.CHE_PATH);
		fileMap.put(Constants.LA,Constants.LA_PATH);
		fileMap.put(Constants.BB,Constants.BB_PATH);
		CityFileMap = Collections.unmodifiableMap(fileMap);
	}
	
	private Constants(){
		//static const class
		throw new AssertionError();
	}
}
