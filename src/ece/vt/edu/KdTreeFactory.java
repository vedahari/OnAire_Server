package ece.vt.edu;

import java.util.HashMap;
import java.util.Map;

public class KdTreeFactory {
	private static Map<String,KdTree> KdTreeMap;
	
	public KdTreeFactory(){
		KdTreeMap = new HashMap<String,KdTree>();
	}
	
	public void addCity(String city){
		if (KdTreeMap.containsKey(city)){
			System.err.println("Already KdTree has been created for the city");
			return;
		}
		KdTreeMap.put(city, new KdTree());
	}

	public static KdTree getKdTree(String city) {
		if (KdTreeMap.containsKey(city)){
			return KdTreeMap.get(city);
		}
		else{
			System.err.println("Factory doesn't have requested city!");
			return null;			
		}	
	}

}
