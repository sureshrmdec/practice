package com.practice.algo.and.ds.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class DP_JumpGameSecondAttempt {

	public static void main(String[] args) {
		DP_JumpGameSecondAttempt o = new DP_JumpGameSecondAttempt();
		Integer[] a = {10, 0, 1, 1, 0 };
		System.out.println(o.canJump(new ArrayList<Integer>(Arrays.asList(a))));

	}
	public int canJump(ArrayList<Integer> a) {
		if(a.size()==1 || a.isEmpty()){
			return 1;
		}
		int max = 0;
		for(int i =0;i<a.size();i++){
			if(i<=max){
				if(max>=a.size()-1)
					return 1;
				if(a.get(i)+i>max){
					max = a.get(i)+i;
				}
			}
		}
		return 0;
	}
}
