package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Arrays_MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays_MergeIntervals a = new Arrays_MergeIntervals();
		Arrays_MergeIntervals.Interval ai1 = a. new Interval(3,5);
		//Arrays_MergeIntervals.Interval ai2 = a. new Interval(3,5);
		//Arrays_MergeIntervals.Interval ai3 = a. new Interval(6,7);
		Arrays_MergeIntervals.Interval ai4 = a. new Interval(8,10);
		//Arrays_MergeIntervals.Interval ai5 = a. new Interval(12,16);
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(ai1);
		//intervals.add(ai2);
		//intervals.add(ai3);
		intervals.add(ai4);
		//intervals.add(ai5);
		Arrays_MergeIntervals.Interval newInterval = a. new Interval(1,12);
		a.insert(intervals, newInterval);
		
		
	}
	public ArrayList<Arrays_MergeIntervals.Interval> insert(ArrayList<Arrays_MergeIntervals.Interval> intervals, Arrays_MergeIntervals.Interval newInterval) {
		
		ArrayList<Interval> r = new ArrayList<>();
		if(intervals.isEmpty()){
			r.add(newInterval);
			return r;
		}
		int newS = -1;
		int newE = -1;
		boolean merged = false;
		for(int i=0;i<intervals.size();i++){
			boolean ShouldAdded = true;
			Interval ci = intervals.get(i);
			if(ci.start <= newInterval.start &&  ci.end >= newInterval.start){
				newS = ci.start;
				ShouldAdded = false;
				continue;
			}
			if(newS!=-1){

				if(ci.start < newInterval.end && ci.end < newInterval.end && newE==-1){
					continue;
				}
				if(ci.start >= newInterval.end && ci.end >= newInterval.end && newE==-1){
					newE = newInterval.end;
					r.add(new Interval(newS,newE));
					ShouldAdded = true;
					merged=true;
				}
				if(ci.start <= newInterval.end && ci.end >= newInterval.end){
					newE = ci.end;
					r.add(new Interval(newS,newE));
					ShouldAdded = false;
					merged=true;
				}
			}
			if(ShouldAdded){
				r.add(ci);
				
			}
			
		}
		if(!merged){
			r.add(newInterval);
			Collections.sort(r, new Comparator<Interval>(){

				@Override
				public int compare(Interval o1, Interval o2) {
					if(o1.start > o2.start){
						return 1;
					}else if(o1.start < o2.start){
						return -1;
					}
					return 0;
				}
				
			});
		}

		return r;
    }
	  class Interval {
		      int start;
		      int end;
		      Interval() { 
		    	  start = 0; end = 0; 
		    	  }
		      
		      Interval(int s, int e) { 
		    	  start = s; end = e; 
		    }
	 }   
		 
}
