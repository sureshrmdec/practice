package com.practice.algo.and.ds.binarysearch;

import java.util.ArrayList;

public class BinarySearch_SquareRootofInteger {

	public static void main(String[] args) {
		
		BinarySearch_SquareRootofInteger o = new BinarySearch_SquareRootofInteger();
		System.out.println(o.sqrt(35));

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
		int h = 46340;
		//int h = (int)Math.sqrt(Integer.MAX_VALUE);
		//int h = a-1;;
		int result = 0;
		while(l<=h){

			int mid = (l+h)/2;
			if(mid*mid > a){
				h = mid-1;
			}else if(mid*mid < a){
				l = mid+1;
				result = mid;
			}else{
				return mid;
			}

		}
		return result;	
	}
}
