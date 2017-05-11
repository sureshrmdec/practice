package com.practice.algo.and.ds.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackTracking_KthPermutationSequenceRe {

	public static void main(String[] args) {
		BackTracking_KthPermutationSequenceRe o = new BackTracking_KthPermutationSequenceRe();
		System.out.println(o.getPermutation(4, 13));

	}
	Map<Integer,Integer> map  = new HashMap<>();
    public String getPermutation(int n, int k) {
        
    	buildMap(n);
    	List<Integer> list = new ArrayList<>();
    	for(int i=1;i<=n;i++){
    		list.add(i);
    	}
    	return getPermutationHelper(list,n,k,"");
    	
    	
    }
	private String getPermutationHelper(List<Integer> list, int n, int k,String result) {
		if(list.isEmpty())
			return result;
		int total = map.get(n);
		int oneSet = total/n;
		int index = getIndex(total,oneSet,k);
		result+=list.get(index);
		list.remove(index);
		return getPermutationHelper(list, n-1, k-(oneSet*index), result);
		
		
	}
	private int getIndex(int total, int oneSet,int k) {
		int a = 1;
		while(oneSet*a<k){
			a = a+1;
		}
		
		return a-1;
	}
	private void buildMap(int n) {
		map.put(1, 1);
		for(int i=2;i<=n;i++){
			map.put(i, i*map.get(i-1));
		}
		
	}
}
