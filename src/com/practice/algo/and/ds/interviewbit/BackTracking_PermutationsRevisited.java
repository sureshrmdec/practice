package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;

public class BackTracking_PermutationsRevisited {

	public static void main(String[] args) {

		// TODO Auto-generated method stub
		BackTracking_PermutationsRevisited o = new BackTracking_PermutationsRevisited();
		//int[] nums = {1,2,3,4};
		String string = new String("anan");
		o.permute(string,0,"");
	

	}

	private void permute(String string,int i,String permuataionSofar) {
		if(permuataionSofar.length()==string.length()){
			System.out.println(permuataionSofar);
			return;
		}
		for(int j = i;j<string.length();j++){
			string = swap(j,i,string);
			permute(string,i+1,permuataionSofar+string.charAt(i));
			string = swap(i,j,string);
		}
	}

	private String swap(int j, int i, String string) {
		char[] arr = string.toCharArray();
		char c = arr[j];
		arr[j] = arr[i];
		arr[i] = c;
		return new String(arr);
		
	}

}
