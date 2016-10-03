package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;

public class BinarySearch_SquareRootofInteger {

	public static void main(String[] args) {
		
		BinarySearch_SquareRootofInteger o = new BinarySearch_SquareRootofInteger();
		System.out.println(o.sqrt(16));

	}
	//1 - 1
	//4 - 2
	//9 - 3
	//16 - 4
	//25 - 5
	//36 - 6
	//49 - 7
	//64 - 8
	public int sqrt(int a) {
		int l = 0;
		//int h = 46340;
		int h = (int)Math.sqrt(Integer.MAX_VALUE);

		while(l<=h){
			
			int mid = (l+h)/2;
			if(l*l <a && h*h<a){
				return h;
			}
			if(l*l >a && h*h>a){
				return l-1;
			}
			if(mid*mid > a){
				h = mid-1;
			}else if(mid*mid < a){
				l = mid+1;
			}else{
				return mid;
			}

		}
		return 0;	
	}
}
