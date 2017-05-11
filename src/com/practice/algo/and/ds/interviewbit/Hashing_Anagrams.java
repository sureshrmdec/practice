package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;

public class Hashing_Anagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hashing_Anagrams o = new Hashing_Anagrams();
		ArrayList<String> input = new ArrayList<>();
		input.add("cat");
		input.add("dog");
		input.add("god");
		input.add("tca");
		input.add("cas");
		input.add("sac");
		input.add("tca");
		System.out.println(o.getAnagrams(input));
	}

	public ArrayList<ArrayList<Integer>> getAnagrams(ArrayList<String> input){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		LinkedHashMap<String,ArrayList<Integer>> map = new LinkedHashMap<>();
		
		for(int i=0;i<input.size();i++){
			String s = input.get(i);
			char[] ca = s.toCharArray();
			Arrays.sort(ca);
			String sortStr = new String(ca);
			if(map.containsKey(sortStr)){
				ArrayList<Integer> l = map.get(sortStr);
				l.add(i+1);
			}else{
				ArrayList<Integer> l = new ArrayList<>();
				l.add(i+1);
				map.put(sortStr, l);
			}
			
		}
		for(String s : map.keySet()){
			result.add(map.get(s));
		}
		return result;
	}
}
