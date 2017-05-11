package com.practice.algo.and.ds.greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class Greedy_Bulbs {

	public static void main(String[] args) {
		Greedy_Bulbs o = new Greedy_Bulbs();
		Integer[] in = {0,1,0,0};
		ArrayList<Integer> bulbs = new ArrayList<>(Arrays.asList(in));
		System.out.println(o.getMin(bulbs));

	}

	public int getMin(ArrayList<Integer> bulbs){
		
		int state = 0;int result = 0;
		for(int i=0;i<bulbs.size();i++){
			if(bulbs.get(i)==state){
				result++;
				state = 1-state;
			}
		}
		return result;
	}
}
