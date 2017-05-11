package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.List;

import com.practice.algo.and.ds.interviewbit.Arrays_MergeIntervals.Interval;

public class Arrays_MergeIntervalsRevisited {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {

        ArrayList<Interval> res = new ArrayList<>();
        res.add(newInterval);

        if (intervals.isEmpty()) {
            return res;
        }
        
        for (int i = 0; i < intervals.size(); i++) {
            Interval ci = intervals.get(i);
            
            if(ci.end < newInterval.start){
                res.add(res.size() - 1, ci);
            } else if (ci.start > newInterval.end){
                res.add(ci);
            } else{
                res.get(res.size()-1).start = Math.min(ci.start, newInterval.start);
                res.get(res.size()-1).end = Math.max(ci.end, newInterval.end);
            }
            
        }

        return res;

    }
}
