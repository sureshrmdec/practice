	package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hashing_PointsOnTheStraightLine {

	public static void main(String[] args) {
		Point[] points ;
		 int[][] po = {{0,9},{138,429},{115,359},{115,359},{-30,-102},{230,709},{-150,-686},{-135,-613},{-60,-248},{-161,-481},{207,639},{23,79},{-230,-691},{-115,-341},{92,289},{60,336},{-105,-467},{135,701},{-90,-394},{-184,-551},{150,774}};
		//int[][] po = {{4,0},{4,-1},{4,5}};
		points = new Point[po.length];
		 for(int i=0;i<po.length;i++){
			 	points[i] = new Point(po[i][0],po[i][1]);
		 }
		Hashing_PointsOnTheStraightLine o = new Hashing_PointsOnTheStraightLine();
		System.out.println(o.maxPoints(points));

	}
//Interview bit
	public int maxPoints(ArrayList<Integer> a, ArrayList<Integer> b) {
		Point[] points = new Point[a.size()];
		for(int i=0;i<a.size();i++){
			points[i] = new Point(a.get(i),b.get(i));
		}
		int result = 0;
		if(points.length==1){
			return 1;
		}
		if(points.length==2){
			return 2;
		}
		//sort to avoid performance issues
		Arrays.sort(points, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return Integer.valueOf(o1.x).compareTo(o2.x);
			}
		});
		
		for(int i=0;i<points.length-1;i++){
			Map<Double,Integer> map = new HashMap<>();
			//try all starting points one by one
			Point start = points[i];
			Point prev = start;
			int tobe = 0;
			boolean stillFirst = true;
			for(int j=i+1;j<points.length;j++){
				Point p = points[j];
				//You only need to handle the same points when they are at same starting point. For eg {{1,1},{1,1},{1,1},{2,2},{3,3}};
				// Or if starting point is in middle (when you take i >0) For eg {{1,7},{2,4},{3,3},{3,3},{3,3},{4,4},{5,5},{7,7};
				if(p.x==prev.x && p.y==prev.y && stillFirst){
					prev = p;
					tobe++;
					continue;
				}
				double yy = p.y - start.y;
				double xx = p.x - start.x;
				double slope =0;
				
				if(xx==0) //horizontal slope
					slope=0.0;
				else if(yy==0){  //vertical slope
					slope = Double.MAX_VALUE;
				}else{ 
					slope = yy/xx;
				}
				if(map.containsKey(slope)){
					map.put(slope, map.get(slope)+1);
				}else{
					
					map.put(slope, 2+tobe);
				}
				stillFirst = false;
			}
			
			List<Integer> values = new ArrayList<>(map.values());
			if(values.isEmpty()){
				result = Math.max(result, tobe+1);
			}else{
				Collections.sort(values);
				result = Math.max(result, values.get(values.size()-1));	
			}
			
			
		}
		return result;
	
		
	}
	public int maxPoints(Point[] points) {
		int result = 0;
		if(points.length==1){
			return 1;
		}
		if(points.length==2){
			return 2;
		}
		//sort to avoid performance issues
		Arrays.sort(points, new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {
				return Integer.valueOf(o1.x).compareTo(o2.x);
			}
		});
		
		for(int i=0;i<points.length-1;i++){
			Map<Double,Integer> map = new HashMap<>();
			//try all starting points one by one
			Point start = points[i];
			Point prev = start;
			int tobe = 0;
			boolean stillFirst = true;
			for(int j=i+1;j<points.length;j++){
				Point p = points[j];
				//You only need to handle the same points when they are at same starting point. For eg {{1,1},{1,1},{1,1},{2,2},{3,3}};
				// Or if starting point is in middle (when you take i >0) For eg {{1,7},{2,4},{3,3},{3,3},{3,3},{4,4},{5,5},{7,7};
				if(p.x==prev.x && p.y==prev.y && stillFirst){
					prev = p;
					tobe++;
					continue;
				}
				double yy = p.y - start.y;
				double xx = p.x - start.x;
				double slope =0;
				
				if(xx==0) //horizontal slope
					slope=0.0;
				else if(yy==0){  //vertical slope
					slope = Double.MAX_VALUE;
				}else{ 
					slope = yy/xx;
				}
				if(map.containsKey(slope)){
					map.put(slope, map.get(slope)+1);
				}else{
					
					map.put(slope, 2+tobe);
				}
				stillFirst = false;
			}
			
			List<Integer> values = new ArrayList<>(map.values());
			if(values.isEmpty()){
				result = Math.max(result, tobe+1);
			}else{
				Collections.sort(values);
				result = Math.max(result, values.get(values.size()-1));	
			}
			
			
		}
		return result;
	}

}

class Point {
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString();
	}
}