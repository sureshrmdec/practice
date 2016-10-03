package com.practice.algo.and.ds.interviewquestions.google;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*http://www.geeksforgeeks.org/find-the-longest-substring-with-k-unique-characters-in-a-given-string/
https://www.glassdoor.com/Interview/Given-a-string-find-the-longest-substring-T-that-contains-m-distinct-characters-need-O-n-solution-QTN_1397954.htm
*/		
public class LongestSubstringWithKUniqueCharacters {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		
		String s = "abbacccddd";
		int sindex = 0;
		int k =2;
		int start = 0;
		int maxLen = 0;
		String maxSubstring = null;
		Set<Character> set = new HashSet<Character>();
		for(int i=0;i<s.length();i++){
			
			char c = s.charAt(i);
			if(map.containsKey(c)){
				map.put(c, map.get(c)+1);
			}else{
				map.put(c, 1);
			}
			
			if(map.size() == k+1){
				//get maximum
				int range = i-start;
				if(range > maxLen){
					maxLen = range;
					maxSubstring = s.substring(start, i);
				}
	 
				//move left cursor toward right, so that substring contains only k chars
				while(map.size()>k){
					char first = s.charAt(start);
					int count = map.get(first);
					if(count>1){
						map.put(first,count-1);
					}else{
						map.remove(first);
					}
					start++;
				}
			}
	    }
		if (map.size() == k) {
			System.out.println(s.substring(start));
		}
		System.out.println(maxSubstring);
}
}