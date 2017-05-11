package com.practice.algo.and.ds.arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;


public class Arrays_MergeOverlappingIntervals {

	public static void main(String[] args) {
		Arrays_MergeOverlappingIntervals a = new Arrays_MergeOverlappingIntervals();
		Arrays_MergeOverlappingIntervals.Interval ai1 = a. new Interval(2,4);
		Arrays_MergeOverlappingIntervals.Interval ai2 = a. new Interval(3,6);
		Arrays_MergeOverlappingIntervals.Interval ai3 = a. new Interval(5,8);
		Arrays_MergeOverlappingIntervals.Interval ai4 = a. new Interval(7,9);
		//Arrays_MergeIntervals.Interval ai5 = a. new Interval(12,16);
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(ai1);
		intervals.add(ai2);
		intervals.add(ai3);
		intervals.add(ai4);
		//intervals.add(ai5);
		Arrays_MergeOverlappingIntervals dd = new Arrays_MergeOverlappingIntervals();
		System.out.println(dd.merge(intervals));

	}
	
	public static ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> res = new ArrayList<>();
        
        if(intervals.isEmpty())
            return res;
        
        Comparator<Interval> comparator = (i1, i2) -> new Integer(i1.start).compareTo(new Integer(i2.start));
        Collections.sort(intervals, comparator);
        
        res.add(intervals.get(0));
        
        for (int i = 1; i < intervals.size(); i++) {
            Interval pi = res.get(res.size()-1);
            Interval ci = intervals.get(i);
            
            if(ci.start <= pi.end){
                pi.start = Math.min(pi.start, ci.start);
                pi.end = Math.max(pi.end, ci.end);
            } else{
                res.add(ci);
            }
        }
        
        return res;
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
