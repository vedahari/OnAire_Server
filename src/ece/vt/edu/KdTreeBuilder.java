package ece.vt.edu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Builds the KdTree initially from the populated 
 * StopPointList. Clients should populate the StopPointList
 * and then build the KdTree.
 */
public class KdTreeBuilder {
	
	private ArrayList<Point> pts;
	private KdTree kdRoot;
	
	public KdTreeBuilder(String city){
		pts = new ArrayList<Point>();
		kdRoot = KdTreeFactory.getKdTree(city);
	}
	
	public void addPoint(Point p){
		pts.add(p);
	}
	
	private void build_helper(int start, int end, int direction){
		if (start<=end){			
			direction=(direction==0)?1:0;
			order(start,end,direction);			
			int mid = start+(end-start)/2;
			kdRoot.insert(pts.get(mid));			
			build_helper(start,mid-1,direction);
			build_helper(mid+1,end,direction);			
		}
	}
	
	public void build(){
		build_helper(0,pts.size()-1,1);
	}
	
	//end parameter is inclusive
	public void order (int start,int end,int direction){
		if (direction==0){
		Collections.sort(pts.subList(start,end+1), new Comparator<Object>(){
			public int compare(Object ob1, Object ob2){
				Point o1 = (Point)ob1;
				Point o2 =  (Point)ob2;
				if (o1.x().equals(o2.x())){					
					return o1.y().compareTo(o2.y());					
				}
				else {					
					return (o1.x().compareTo(o2.x()));
				}
			}
		});		
		}
		else {
			Collections.sort(pts.subList(start,end+1), new Comparator<Object>(){
				public int compare(Object ob1, Object ob2){
					Point o1 = (Point)ob1;
					Point o2 =  (Point)ob2;
					if (o1.y().equals(o2.y())){					
						return o1.x().compareTo(o2.x());						
					}
					else {					
						return (o1.y().compareTo(o2.y()));
					}
				}
			});	
		}
	}
	
	public void clear(){
		pts.clear();		
		//TODO: Implement kdRoot.clear();
	}
}
