package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Arrays_HotelBookingsPossible {

	public static void main(String[] args) {
		Integer[] a = {40, 18};
		ArrayList<Integer> arrive = new ArrayList<>(Arrays.asList(a));
		Integer[] d = {40, 43};
		ArrayList<Integer> depart = new ArrayList<>(Arrays.asList(d));
		Arrays_HotelBookingsPossible j = new Arrays_HotelBookingsPossible();
		int K = 1;
		System.out.println(j.hotel(arrive, depart, K));

	}
	 public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
		 ArrayList<Dates> list = new ArrayList<>();
		 
		 for(int i=0;i<arrive.size();i++){
			 Dates d = new Dates(arrive.get(i),depart.get(i));
			 list.add(d);
		 }
	 
		 if(K>=arrive.size()){
			 return true;
		 }
		 Collections.sort(list);
		 ArrayList<Dates> occupied = new ArrayList<>();
		 occupied.add(list.get(0));
		 K--;
		 for(int i=1;i<arrive.size();i++){
			 boolean added = false;
			 if(K>0){
				 occupied.add(list.get(i));
				 added = true;
				 K--;
			 }else{
				 Dates tobe = list.get(i);
				 for(int j=0;j<occupied.size();j++){
					 Dates d = occupied.get(j);
					 if(d.end <= tobe.start){
						 occupied.remove(j);
						K++;
					 }
				 }
				 if(K>0){
					 K--;
					 occupied.add(tobe);
					 added = true;
				 }
			 }
			 if(added){
				 continue;
			 }else{
				 return false;
			 }
			 
		 }
		 return true;
		 
	 }
	 class Dates implements Comparable<Dates>{
		 int start;
		 int end;
		 public Dates(int start,int end){
			 this.start = start;
			 this.end = end;
		 }
		@Override
		public int compareTo(Dates o) {
			// TODO Auto-generated method stub
			if(this.start > o.start){
				return 1;
			}else if(this.start < o.start){
				return -1;
			}
			return 0;
		}
		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			Dates d = (Dates)obj;
			if(this.start == d.start && this.end==d.end){
				return true;
			}
			return false;
		}
		 
	 }
}
