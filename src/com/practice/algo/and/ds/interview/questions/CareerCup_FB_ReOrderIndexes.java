package com.practice.algo.and.ds.interview.questions;

//https://www.careercup.com/question?id=5756151524229120

public class CareerCup_FB_ReOrderIndexes {
	public static void main(String[] args) {
		CareerCup_FB_ReOrderIndexes o = new CareerCup_FB_ReOrderIndexes();
		Character[] val= {'C', 'D', 'E', 'F', 'G'};
		int[] indexes = {3, 0, 4, 1, 2};
		System.out.println(o.reOrder(val, indexes));
	}
	public Character[] reOrder(Character[] val,int[] indexes){
		
		for(int i=0;i<val.length;i++){
			char c = val[i];
			int index = indexes[i];
			
			char cc = val[index];
			int index2 = indexes[index];
			
			
			val[index] = c;
			indexes[index] = index;
			
			val[i] = cc;
			indexes[i] = index2;
		}
	return val;	
	}
}
