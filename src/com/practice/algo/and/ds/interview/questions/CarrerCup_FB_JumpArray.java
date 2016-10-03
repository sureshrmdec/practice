package com.practice.algo.and.ds.interview.questions;

//https://www.careercup.com/question?id=5728188153987072

public class CarrerCup_FB_JumpArray {

	public static void main(String[] args) {
		Integer[] aa = {0, 4, 0, 0, 0, 1 };
		CarrerCup_FB_JumpArray o = new CarrerCup_FB_JumpArray();
		o.isPossible(aa);
	}
	private boolean isPossible(Integer[] a){

		int max = 0;

		for(int i =0;i<a.length;i++){
			if(i<=max){
				if(max>=a.length-1)
					return true;
				if(a[i]+i>max){
					max = a[i]+i;
				}
			}
		}

		return false;
	}
}
