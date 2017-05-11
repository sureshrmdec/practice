package com.practice.algo.and.ds.twopointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoPointers_LeetCode_ShortestWordDistanceII {

	public static void main(String[] args) {
		String[] words = {"practice","makes","perfect","coding","makes"};
		TwoPointers_LeetCode_ShortestWordDistanceII o = new TwoPointers_LeetCode_ShortestWordDistanceII(words);
		System.out.println(o.shortest("makes", "coding"));
		System.out.println(o.shortest("coding", "practice"));

	}
	Map<String,List<Integer>> indexMap = new HashMap<>();
	public TwoPointers_LeetCode_ShortestWordDistanceII(String[] words){
		for(int i=0;i<words.length;i++){
			List<Integer> indexes = null;
			if(indexMap.containsKey(words[i])){
				indexMap.get(words[i]).add(i);
			}else{
				indexes = new ArrayList<Integer>();
				indexes.add(i);
				indexMap.put(words[i], indexes);
			}
		}	
	}
	// 1 4 7
	// 2 5 9 10

	public int shortest(String word1, String word2) {
		List<Integer> indexes1 = indexMap.get(word1);
		List<Integer> indexes2 = indexMap.get(word2);
		Integer res = Integer.MAX_VALUE;
		int i=0;
		int j=0;

		while(i<indexes1.size() && j<indexes2.size()){
			res = Math.min(Math.abs(indexes2.get(j)-indexes1.get(i)), res);
			if(indexes1.get(i)<indexes2.get(j)){
				i++; 
			}else{
				j++;
			}
		}

		return res;
	}
}
