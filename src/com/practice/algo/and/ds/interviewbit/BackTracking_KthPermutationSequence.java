package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class BackTracking_KthPermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BackTracking_KthPermutationSequence o = new BackTracking_KthPermutationSequence();
		System.out.println(o.getPermutation(4, 2));
	}
	 
	public String getPermutation(int n, int k) {
		int[] factorial = {1,2,6,24,120,720,5040,40320,362880};
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<n;i++){
			list.add(i+1);
		}
		String str = "";
		int nn = n;
		for(int i=0;i<n;i++){
			int f = factorial[nn-1];
			int singleSize= f/list.size();
			int index = getNext(k,list,singleSize);
			str+=list.get(index);
			list.remove(index);
			k = k - (singleSize*(index));
			if(k==1){
				for(Integer s:list){
					str+=s;
				}
				return str;
			}
			nn--;
		}
		return str;
	}

	private int getNext(int k, List<Integer> list,int minSize) {
		// TODO Auto-generated method stub
		int index = 0;
		int s = 0;
		while(s<k){
			s+=minSize;
			index++;
		}
	
		return index-1;
	}

}
