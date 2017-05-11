package com.practice.algo.and.ds.arrays;

import java.util.Arrays;

//http://www.programcreek.com/2012/12/leetcode-3sum/
// Asked in FB
public class LeetCode_3SumToZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] s = {-1,2};
		LeetCode_3SumToZero o = new LeetCode_3SumToZero();
		int[] a = (o.ThreeSumToZero(s));
		System.out.println(s[a[0]]+" "+s[a[1]]+" "+s[a[2]]);
		
		
	}
	
	private int[] ThreeSumToZero(int[] s){
		int[] a = new int[3];
		Arrays.sort(s);
		
		for(int i=0;i<s.length;i++){
			int remaining = 0-s[i];
			
			int l = i;
			int r = s.length-1;
			while(l<r){
				if(s[l]+s[r]==remaining){
					a[0]=i;a[1]=l;a[2]=r;
					break;
				}
				if(s[l]+s[r]>remaining){
					r--;
				}else{
					l++;
				}
			}
			
		}
		
		
		return a;
		
	}

}
