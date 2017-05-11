package com.practice.algo.and.ds.interviewbit;

import java.util.HashMap;

public class Strings_StrStr {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings_StrStr o = new Strings_StrStr();
		System.out.println(o.strStr("bbaabbbbbaabbaabbbbbbabbbabaabbbabbabbbbababbbabbabaaababbbaabaaaba", "babaaa"));
	}
	public int strStr(final String haystack, final String needle) {
		if(needle.length()>haystack.length()){
			return -1;
		}
		if(needle.isEmpty()){
			return 0;
		}
		HashMap<Character, Integer> target = new HashMap<>();
		HashMap<Character, Integer> current = new HashMap<>();
		
		for(int i=0;i<needle.length();i++){
			char c = needle.charAt(i);
			if(target.containsKey(c)){
				target.put(c, target.get(c)+1);
			}else{
				target.put(c, 1);
			}
		}
		
		for(int i=0;i<needle.length();i++){
			char c = haystack.charAt(i);
			if(current.containsKey(c)){
				current.put(c, current.get(c)+1);
			}else{
				current.put(c, 1);
			}
		}
		if(checkCurrent(current,target)){
			return 0;
		}
		int j = 0;
		for(j=needle.length();j<haystack.length();j++){
			
			if(checkCurrent(current,target)){
				if(needle.equals(haystack.substring(j-needle.length(),j)))
				return j-needle.length();
			}
			int a = current.get(haystack.charAt(j-needle.length()));
			current.put(haystack.charAt(j-needle.length()),a-1);
			current.put(haystack.charAt(j),current.get(haystack.charAt(j))!=null?current.get(haystack.charAt(j))+1:1);
		}
		
		
		
		
		
		
		return -1;
	}
	private boolean checkCurrent(HashMap<Character, Integer> current,HashMap<Character, Integer> target) {
		for(Character c:target.keySet()){
			if(current.get(c)!=target.get(c))
				return false;
		}
		return true;
	}
}
