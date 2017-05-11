package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.TreeSet;

public class Greedy_AssignMiceToHoles {

	public static void main(String[] args) {
		Greedy_AssignMiceToHoles o = new Greedy_AssignMiceToHoles();
		Integer[] m = {4,-4,2};
		Integer[] h = {4,0,5};
		ArrayList<Integer> mice = new ArrayList<>(Arrays.asList(m));
		ArrayList<Integer> holes = new ArrayList<>(Arrays.asList(h));
		System.out.println(o.assignMice(mice, holes));

	}

	public int assignMice(ArrayList<Integer> mice,ArrayList<Integer> holes){
		Collections.sort(mice);
		Collections.sort(holes);
		int result = Integer.MIN_VALUE;
		for(int i=0;i<mice.size();i++){
			int a = mice.get(i);
			int b = holes.get(i);
			result = Math.max(result, Math.abs(a-b));
		}
		return result;
	}
}
