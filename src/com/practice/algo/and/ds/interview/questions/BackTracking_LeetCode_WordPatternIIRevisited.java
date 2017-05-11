package com.practice.algo.and.ds.interview.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class BackTracking_LeetCode_WordPatternIIRevisited {

	public static void main(String[] args) {
		String pattern = "abab";
		String str = "redblueredblue";
		BackTracking_LeetCode_WordPatternIIRevisited o = new BackTracking_LeetCode_WordPatternIIRevisited();
		System.out.println(o.wordPatternMatch(pattern, str));
		System.out.println();
	}
	public boolean wordPatternMatch(String pattern, String str) {

		Map<Character,String> map = new HashMap<>();
		HashSet<String> set = new HashSet<String>();
		return wordPatternOL(pattern,str,0,0,map,set);
	}
	private boolean wordPatternOL(String pattern, String str, int patternIndex, int strIndex, Map<Character, String> map,HashSet<String> set) {

		if(patternIndex==pattern.length() && strIndex==str.length()){
			return true;
		}
		 if(patternIndex>=pattern.length() || strIndex>=str.length())
		        return false;		
		char c = pattern.charAt(patternIndex);
		for(int j=strIndex+1;j<=str.length();j++){
			String possibleMatch = str.substring(strIndex,j);

			if(map.containsKey(c)){
				String existing = map.get(c);
				if(possibleMatch.equals(existing)){
					if(wordPatternOL(pattern, str, patternIndex+1, j, map,set))
						return true;
				}else if(existing.length()<possibleMatch.length())
					return false;
			}else if(!map.containsKey(c) && !set.contains(possibleMatch)){
				map.put(c, possibleMatch);
				set.add(possibleMatch);
				if(wordPatternOL(pattern, str, patternIndex+1, j, map,set)){
					return true;
				}
				map.remove(c);
				set.remove(possibleMatch);
			}
			
		}
		return false;
	}

}
