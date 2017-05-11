package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class Arrays_MaximumUnsortedSubarray {

	public static void main(String[] args) {
		Arrays_MaximumUnsortedSubarray o = new Arrays_MaximumUnsortedSubarray();
		//Integer[] a = {1,2,4,3,9,5,6,8,10};
		//Integer[] a = {1,2,4,3,6,5,7,8,9};
		Integer[] a = {1, 2, 3, 5, 6, 13, 15, 16, 17, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19};
		ArrayList<Integer> input = new ArrayList<>(Arrays.asList(a));
		System.out.println(o.getIndexes(input));


	}
	public ArrayList<Integer> getIndexes(ArrayList<Integer> input){
		ArrayList<Integer> result = new ArrayList<>();
		if(input.size()<2){
			result.add(-1);
			return result;
		}
		int l = -1;
		int r = -1;
		int max = -1;
		for(int i=1;i<input.size();i++){
			int current = input.get(i);
			max = Math.max(max, current);
			if(current<input.get(i-1) || current<max){
				if(l==-1){
					l=i-1;
					r = i;
				}else{
					r = i;
				}

			}
		}
		
		int ll = -1;
		int rr = -1;
		int min = input.get(input.size()-1);
		for(int i=input.size()-2;i>=0;i--){
			int current = input.get(i);
			min = Math.min(min, current);
			if(current>input.get(i+1) || current>min){
				if(ll==-1){
					ll=i;
					rr = i;
				}else{
					rr = i;
				}

			}
		}
		
		if(l==-1){
		    result.add(l);
		}else{
		result.add(Math.min(l, rr));
		result.add(Math.max(r, ll));
		}
		return result;
	}

}
