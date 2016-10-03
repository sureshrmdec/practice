package com.practice.algo.and.ds.interview.questions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LeetCode_InsertIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(12,16));
		intervals.add(new Interval(6,7));
		intervals.add(new Interval(3,5));
		LeetCode_InsertIntervals o = new LeetCode_InsertIntervals();
		System.out.println(o.insert(intervals, new Interval(4,9)));
		
	}
	
	public List<Interval> insert(List<Interval> a, Interval newInterval) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		Collections.sort(a, new Comparator<Interval>() {

			@Override
			public int compare(Interval o1, Interval o2) {
				// TODO Auto-generated method stub
				if(o1.start<o2.start)
					return -1;
				else if(o1.start>o2.start)
					return 1;			
				return 0;
			}
		});	
		
		int minStart = -1;
		int maxEnd = -1;
		boolean added = false;
		for(int i=0;i<a.size();i++){
			Interval current = a.get(i);
			if(current.end<newInterval.start){
				res.add(current);
				continue;
			}else if(current.start > newInterval.end){
				if(!added){
					res.add(new Interval(minStart,maxEnd));
					added = true;
				}
				res.add(current);
				continue;
			}else{
				minStart = Math.min(newInterval.start, current.start);
				if(minStart!=-1){
					maxEnd = Math.max(newInterval.end, current.end);
				}
			}
			
			
			
		}
		return res;
	}
	
	
	
	
	static class Interval {
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
