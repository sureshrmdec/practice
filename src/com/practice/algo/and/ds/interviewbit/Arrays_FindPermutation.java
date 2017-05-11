package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;

public class Arrays_FindPermutation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays_FindPermutation o = new Arrays_FindPermutation();
		System.out.println(o.findPermutation(6, "IDDII"));
	}

	public ArrayList<Integer> findPermutation(int n,String s){
		ArrayList<Integer> result = new ArrayList<>();
		int Is = 0;
		int Ds = 0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='I'){
				Is++;
			}else{
				Ds++;
			}
		}
		int iStart = n-Is+1;
		int dDstart = iStart-1;
		result.add(dDstart);
		dDstart--;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)=='I'){
				result.add(iStart);
				iStart++;
			}else{
				result.add(dDstart);
				dDstart--;
			}
		}
		return result;
	}
}
