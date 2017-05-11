package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Hashing_SubstringConcatenationRevisited {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashing_SubstringConcatenationRevisited o = new Hashing_SubstringConcatenationRevisited();
		//ArrayList<String> words = new ArrayList<>();
		//words.add("ab");
		//words.add("ba");
		//words.add("is");
		String[] words = {"foo", "bar"};
		String str = "barfoobarfoothefoobarman";		
		System.out.println(o.findSubstring(str, words));


	}
	public List<Integer> findSubstring(String s, String[] words) {

		ArrayList<Integer> res = new ArrayList<>();
		HashMap<String,Integer> countMap = new HashMap<>();
		int wordSize = words[0].length();
		int orignalCount=0;
		for(int i=0;i<words.length;i++){
			String word = words[i];
			if(countMap.containsKey(word)){
				countMap.put(word, countMap.get(word)+1);
			}else{
				countMap.put(word, 1);
			}
			orignalCount++;
		}
		HashMap<String, Integer> mainMap = new HashMap<>();
		int count=0;
		int start=0;
		for(int i=0;i<s.length()-wordSize;i++){
			String currentWord = s.substring(i, i+wordSize);
			if(countMap.containsKey(currentWord)){
				if(mainMap.containsKey(currentWord)){
					if(countMap.get(currentWord)>mainMap.get(currentWord)){
						mainMap.put(currentWord, mainMap.get(currentWord)+1);
						count++;
					}else{
						start+=wordSize;
					}
						
				}else{
					mainMap.put(currentWord, 1);
					count++;
				}
			}
			if(orignalCount==count){
				mainMap.put(s.substring(start, start+wordSize),mainMap.get(s.substring(start, start+wordSize))-1);
				res.add(start);
				start+=wordSize;
				count--;
			}
		}
		return res;
	}
}
