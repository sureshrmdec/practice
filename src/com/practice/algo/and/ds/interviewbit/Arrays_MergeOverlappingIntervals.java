package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

import com.practice.algo.and.ds.interviewbit.Arrays_MergeIntervals.Interval;

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
	public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
		Collections.sort(intervals, new Comparator<Interval>(){

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
		ArrayList<Interval> res = new ArrayList<>();
		Stack<Interval> stack = new Stack<>();
		Interval ciz = intervals.get(0);
		stack.push(ciz);
		for(int i=1;i<intervals.size();i++){
			boolean merged = false;
			Interval ci = stack.pop();
			Interval ni = intervals.get(i);
			if(    	//   a----------------b       ci
					//               c---------d  ni
					ci.end >= ni.start && ci.end <= ni.end){
				 stack.push(new Interval(ci.start,ni.end));
				 merged = true;
			}
							//         a----------------b
							//     c---------d
			else if	(ci.start >= ni.start && ci.start <= ni.end){
				stack.push(new Interval(ni.start,ci.end));
				merged = true;
			}
					//       a------b
					//     c-----------d
			else if (ci.start>=ni.start && ci.start<=ni.end || ci.end>=ni.start && ci.end <= ni.end ){
				stack.push(new Interval(ni.start,ni.end));
				merged = true;
			}
			//if cd is in ab
			//  a----------------b
			//     c---------d
			else if(ni.start>=ci.start && ni.start<=ci.end && ni.end>=ci.start && ni.end<=ci.end){
				stack.push(new Interval(ci.start,ci.end));
				merged = true;
			}
			if(!merged){
				stack.push(ci);
				stack.push(ni);
			}
			
		}
		res.addAll(stack);
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
