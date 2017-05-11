package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;

public class Greedy_Seats {

	public static void main(String[] args) {
		String in = ".x.x.x..x";
		Greedy_Seats o = new Greedy_Seats();
		System.out.println(o.getMin(in));
	}

	public int getMin(String in){

		ArrayList<Integer> occupied = new ArrayList<>();

		int result = 0;
		for(int i=0;i<in.length();i++){
			if(in.charAt(i)=='x'){
				occupied.add(i);
			}
		}
		if(occupied.size()==0 || occupied.get(occupied.size()-1)-occupied.get(0)==1)
			return 0;

		int a = 0;
		int b = occupied.size()-1;

		int mid = (a+b)/2;
		int midV = occupied.get(mid);

		for(int i=0;i<occupied.size();i++){
			int currentV = occupied.get(i);
			if(i<mid){
				result+=(midV-1)-currentV;	
				midV = midV-1;
			}else{
				result+=currentV-(midV+1);
				midV = midV+1;
			}
			if(i==mid)
				midV = occupied.get(mid);
			
		}

		
		int i=mid-1;

		while(i>=0){
			int currentV = occupied.get(i);
			result+=(midV-1)-currentV;
			midV = midV-1;
			i--;
		}

		i=mid+1;
		midV = occupied.get(mid);
		while(i<occupied.size()){
			int currentV = occupied.get(i);
			result+=currentV-(midV+1);
			midV = midV+1;
			i++;
		}

		return result;
	}
}
