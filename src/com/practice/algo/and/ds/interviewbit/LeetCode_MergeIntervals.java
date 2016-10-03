package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


//https://leetcode.com/problems/merge-intervals/
//Same as Interview's bit Arrays_MergeInterval
public class LeetCode_MergeIntervals {
	
	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1,3));
		intervals.add(new Interval(2,6));
		intervals.add(new Interval(8,10));
		intervals.add(new Interval(15,18));
		
		LeetCode_MergeIntervals o = new LeetCode_MergeIntervals();
		o.merge(intervals);
	}
	public List<Interval> merge(List<Interval> intervals) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		if(intervals==null || intervals.size()==0)
			return res;
		
		Collections.sort(intervals, new Comparator<Interval>() {

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
		
		
		Interval prev = intervals.get(0);
		for(int i=1;i<intervals.size();i++){
			Interval current = intervals.get(i);
			if(isOverlapping(prev, current)){
				int minStart = Math.min(prev.start, current.start);
				int maxEnd = Math.max(prev.end, current.end);
				Interval mergedInterval = new Interval(minStart,maxEnd);
				current = mergedInterval;
			}else{
				res.add(prev);
			}
			prev = current;
		}
		res.add(prev);
		return res;
	}
	private boolean isOverlapping(Interval i1,Interval i2){
		if(i1.start<=i2.end && i2.start<=i1.end){
			return true;
		}
		return false;
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
