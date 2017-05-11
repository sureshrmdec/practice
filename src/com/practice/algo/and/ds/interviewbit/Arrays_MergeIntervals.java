package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Arrays_MergeIntervals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays_MergeIntervals a = new Arrays_MergeIntervals();
		Arrays_MergeIntervals.Interval ai1 = a. new Interval(1,2);
		Arrays_MergeIntervals.Interval ai2 = a. new Interval(3,6);
		//Arrays_MergeIntervals.Interval ai2 = a. new Interval(3,5);
		Arrays_MergeIntervals.Interval ai3 = a. new Interval(6,7);
		Arrays_MergeIntervals.Interval ai4 = a. new Interval(8,10);
		Arrays_MergeIntervals.Interval ai5 = a. new Interval(12,16);
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(ai1);
		intervals.add(ai2);
		intervals.add(ai3);
		intervals.add(ai4);
		intervals.add(ai5);
		Arrays_MergeIntervals.Interval newInterval = a. new Interval(10,8);
		a.insert(intervals, newInterval);


	}
	//Did this second time....during revision
	public ArrayList<Arrays_MergeIntervals.Interval> insert(ArrayList<Arrays_MergeIntervals.Interval> intervals, Arrays_MergeIntervals.Interval newInterval) {
		ArrayList<Arrays_MergeIntervals.Interval> result = new ArrayList<>();
		if(intervals.isEmpty()){
			result.add(newInterval);
			return result;
		}
		int newStart = Math.min(newInterval.start, newInterval.end);
		int newEnd = Math.max(newInterval.start, newInterval.end);
		newInterval.start = newStart;
		newInterval.end = newEnd;
		boolean inserted = false;
		Interval merged = null;
		for(int i=0;i<intervals.size();i++){
			Interval ci = intervals.get(i);
			if(overlapped(ci,newInterval)){
				if(merged == null){
					merged = new Interval();
					merged.start = Math.min(ci.start, newInterval.start);
					merged.end = Math.max(ci.end, newInterval.end);
					result.add(merged);
				}else{
					//This means we have already merged and looking for next interval if it can be merged with the last one...so removing and adding
					merged = result.get(result.size()-1);
					merged.start = Math.min(ci.start, merged.start);
					merged.end = Math.max(ci.end, merged.end);
					result.remove(result.size()-1);
					result.add(merged);	
				}
				inserted = true;
			}else{
				if(newInterval.end<=ci.start && !inserted){
					result.add(newInterval);
					inserted = true;
				}
					
				result.add(ci);
			}
		}

		if(merged ==null && !inserted){
			//To check if new Interval should be put at the end.
				result.add(newInterval);
		}

		return result;
	}
	private boolean overlapped(Interval ci, Interval newInterval) {
		//a---------b            a------------b  a-----------b     a----b
		//		a1------b1   a1-------b1			a1---b1     a1---------b1
		if(newInterval.start<= ci.end && newInterval.end>=ci.start){
			return true;
		}

		return false;
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
