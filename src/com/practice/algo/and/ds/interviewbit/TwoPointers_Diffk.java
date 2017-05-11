package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class TwoPointers_Diffk {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] ina = {1,2,3};
		ArrayList<Integer> in = new ArrayList<>(Arrays.asList(ina));
		TwoPointers_Diffk o = new TwoPointers_Diffk();
		System.out.println(o.findDiff(in, 0));


	}

	public int findDiff(ArrayList<Integer> in,int k){
		
		int back = 0;
		int front = back + 1;
		
		while(back<front && front<in.size()){
			
			
			int diff = Math.abs(in.get(front)-in.get(back));
			if(diff==k)
				return 1;
			if(diff>k){
				back++;
			}else if(diff<k){
				front++;
			}
			if(back==front)
				front = front + 1;
			
		}
		return 0;
		
		
	}
}
