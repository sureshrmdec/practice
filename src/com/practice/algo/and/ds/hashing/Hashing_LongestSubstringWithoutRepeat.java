package com.practice.algo.and.ds.hashing;

import java.util.HashMap;
import java.util.Map;

public class Hashing_LongestSubstringWithoutRepeat {

	public static void main(String[] args) {
		Hashing_LongestSubstringWithoutRepeat o = new Hashing_LongestSubstringWithoutRepeat();
		System.out.println(o.getLongest("abcabcbb"));
		System.out.println(o.getLongest("abba"));
	}
	
	public int getLongest(String s){
		int result = 0;
		
		Map<Character,Integer> map = new HashMap<>();
		int start = 0;
		int j=0;
		for(j=0;j<s.length();j++){
			char c = s.charAt(j);
			Integer b = map.put(c,j);
			if(b!=null){
				int ss = (j)-start;
				if(ss>=result){
					result = ss;
					
				}
				for(int k=start;k<b;k++){
					map.remove(s.charAt(k));
				}
				start=b+1;
			}
		}
		if(j-start+1>result){
			result = j-start;
			
		}
		return result;
	}

}
