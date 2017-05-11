package com.practice.algo.and.ds.arrays;

import java.util.ArrayList;
import java.util.List;

import com.practice.algo.and.ds.arrays.Arrays_MergeOverlappingIntervals.Interval;



public class Arrays_MergeIntervalsRevisited {

	public static void main(String[] args) {
		Arrays_MergeIntervalsRevisited a = new Arrays_MergeIntervalsRevisited();
		Arrays_MergeIntervalsRevisited.Interval ai1 = a. new Interval(1,2);
		Arrays_MergeIntervalsRevisited.Interval ai2 = a. new Interval(3,5);
		//Arrays_MergeIntervalsRevisited.Interval ai2 = a. new Interval(3,5);
		Arrays_MergeIntervalsRevisited.Interval ai3 = a. new Interval(6,7);
		Arrays_MergeIntervalsRevisited.Interval ai4 = a. new Interval(8,10);
		Arrays_MergeIntervalsRevisited.Interval ai5 = a. new Interval(12,16);
		ArrayList<Interval> intervals = new ArrayList<>();
		intervals.add(ai1);
		intervals.add(ai2);
		intervals.add(ai3);
		intervals.add(ai4);
		intervals.add(ai5);
		Arrays_MergeIntervalsRevisited.Interval newInterval = a. new Interval(6,9);
		a.insert(intervals, newInterval);

	}
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	    List<Interval> result = new ArrayList<Interval>();
	    for (Interval i : intervals) {
	        if (newInterval == null || i.end < newInterval.start)
	            result.add(i);
	        else if (i.start > newInterval.end) {
	            result.add(newInterval);
	            result.add(i);
	            newInterval = null;
	        } else {
	            newInterval.start = Math.min(newInterval.start, i.start);
	            newInterval.end = Math.max(newInterval.end, i.end);
	        }
	    }
	    if (newInterval != null)
	        result.add(newInterval);
	    return result;
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
