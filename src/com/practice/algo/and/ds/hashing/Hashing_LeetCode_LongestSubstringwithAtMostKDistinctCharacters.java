package com.practice.algo.and.ds.hashing;

import java.util.HashMap;
import java.util.Map;

public class Hashing_LeetCode_LongestSubstringwithAtMostKDistinctCharacters {

	public static void main(String[] args) {
		String s = "aa";
		int k = 2;
		Hashing_LeetCode_LongestSubstringwithAtMostKDistinctCharacters o = new Hashing_LeetCode_LongestSubstringwithAtMostKDistinctCharacters();
		System.out.println(o.lengthOfLongestSubstringKDistinct(s, k));

	}
    public int lengthOfLongestSubstringKDistinct(String s, int k) {

    	int max = 0;
    	Map<Character,Integer> map =  new HashMap<>();
    	int start = 0;
    	for(int i =0;i<s.length();i++){
    		char c = s.charAt(i);
    		map.put(c, map.getOrDefault(c, 0) + 1);
    			while(map.size()>k){
    				char cStart = s.charAt(start);
    				if(map.get(cStart)==1)
    					map.remove(cStart);
    				else{
    					map.put(cStart,map.get(cStart)-1);
    				}
    				start++;
    			}
    			max = Math.max(max,i - start+1);    		
    	}
    	
    	return max>map.size()?max:map.size();
    }
}
