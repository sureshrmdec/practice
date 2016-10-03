package com.practice.hackerrank.Booking.com.Back.End.CodeSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class CouplingPassions {

	/*2
	3 surfing yoga walking
	3 wine relaxation beach
	3
	amsterdam 52.374030 4.889690 4 museums canals nightlife walking
	sagres 37.129665 -8.669586 3 beach surfing relaxation
	biarritz 43.480120 -1.555580 6 surfing nightlife beach food wine walking*/
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		int guests = Integer.parseInt(r.readLine());
		PrintWriter out = new PrintWriter(System.out);
		Set<String> passions = new HashSet<String>();
		for(int i=0;i<guests;i++){
			String[] sa = r.readLine().split(" ");
			int p = Integer.parseInt(sa[0]);
			for(int j=1;j<=p;j++){
				passions.add(sa[j]);
			}
		}
		int cities = Integer.parseInt(r.readLine());
		int maxPassions = Integer.MIN_VALUE;
		
		Map<Integer,List<City>> map = new TreeMap<>(
				new Comparator<Integer>() {

					@Override
					public int compare(Integer o1, Integer o2) {
						return o2.compareTo(o1);
					}

				});
		int h = Integer.MIN_VALUE;
		int s = Integer.MIN_VALUE;
		for(int i=0;i<cities;i++){
			String[] sa = r.readLine().split(" ");
			String cityName = (sa[0]);
			int nPassions = Integer.parseInt(sa[3]);
			int countPassions = 0;
			for(int j=4;j<nPassions+4;j++){

				if(passions.contains(sa[j])){
					countPassions++;
				}
			}
			maxPassions = Math.max(countPassions, maxPassions);
			City city = new City(cityName,countPassions,Float.parseFloat(sa[1]),Float.parseFloat(sa[2]));
			if(map.get(countPassions)!=null){
				map.get(countPassions).add(city);
			}else{
				List<City> cL = new ArrayList<>();
				cL.add(city);
				map.put(countPassions, cL);
			}
			if(countPassions>=h){
				s = h;
				h = countPassions;
			}else if(countPassions>=s){
				s=countPassions;
			}
		}
		List<City> finalsF = map.get(h);
		List<City> finalsS = map.get(s);
		List<String> result = null;
		if(finalsF.size()>=2){
			result = calculateTwoNearest(finalsF);
		}else{
			result = calculateTwoNearest(finalsF,finalsS);
		}

		Collections.sort(result);
		out.println(result.get(0) +" "+result.get(1));
		out.close();
	}

	private static List<String> calculateTwoNearest(List<City> finals) {
		// TODO Auto-generated method stub
		List<String> finalss = new ArrayList<>();
		Double d = Double.MAX_VALUE;
		for(int i=0;i<finals.size()-1;i++){
			for(int j=i+1;j<finals.size();j++){
				double dd = distance_between(finals.get(i),finals.get(j));
				if(dd<d){
					finalss.add(finals.get(i).getName());
					finalss.add(finals.get(j).getName());
				}
			}	
		}
		return finalss;
	}
	private static List<String> calculateTwoNearest(List<City> finalsF,List<City> finalsS) {
		// TODO Auto-generated method stub
		List<String> finalss = new ArrayList<>();
		Double d = Double.MAX_VALUE;
		for(int i=0;i<finalsF.size();i++){
			for(int j=0;j<finalsS.size();j++){
				double dd = distance_between(finalsF.get(i),finalsS.get(j));
				if(dd<d){
					finalss.add(finalsF.get(i).getName());
					finalss.add(finalsS.get(j).getName());
				}
			}	
		}
		return finalss;
	}
	private static double distance_between(City one,City two) {
		int EARTH_RADIUS = 6371;//in km
		double point1_lat_in_radians  = degree2radians( one.getLatitude() );
		double point2_lat_in_radians  = degree2radians( two.getLatitude() );
		double point1_long_in_radians  = degree2radians( one.getLongitude() );
		double point2_long_in_radians  = degree2radians( two.getLongitude() );

		return Math.acos( Math.sin( point1_lat_in_radians ) * Math.sin( point2_lat_in_radians ) +
				Math.cos( point1_lat_in_radians ) * Math.cos( point2_lat_in_radians ) *
				Math.cos( point2_long_in_radians - point1_long_in_radians) ) * EARTH_RADIUS;
	}

	private static double degree2radians(float latitude) {
		// TODO Auto-generated method stub
		return latitude*0.0174533;
	}
}
class City implements Comparable<City> {
	private int countPassions;
	public int getCountPassions() {
		return countPassions;
	}
	public void setCountPassions(int countPassions) {
		this.countPassions = countPassions;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private float latitude;
	private float longitude;
	private String name;
	public City(String name,int countPassions,float latitude,float longitude){
		this.countPassions=countPassions;
		this.latitude=latitude;
		this.longitude=longitude;
		this.name=name;
	}
	@Override
	public int compareTo(City o) {
		if(this.countPassions<o.countPassions){
			return 1;
		}
		return -1;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name;
	}

}
class NameComparator implements Comparator<City>{

	@Override
	public int compare(City o1, City o2) {
		// TODO Auto-generated method stub
		return o1.getName().compareTo(o2.getName());

	}

}
