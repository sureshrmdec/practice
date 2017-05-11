package com.practice.algo.and.ds.interview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Hashing_LeetCode_GroupAnagrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		Hashing_LeetCode_GroupAnagrams o = new Hashing_LeetCode_GroupAnagrams();
		System.out.println(o.groupAnagrams(strs));
	}
	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> result = new ArrayList<>();

		Map<String,List<String>> map = new HashMap<>();
		for(String str : strs){
			String strC = new String(str);
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			String srted = new String(arr);
			List<String> strList = null;
			if(map.containsKey(srted)){
				map.get(srted).add(strC);
			}else{
				strList = new LinkedList<>();
				strList.add(strC);
				map.put(srted, strList);
			}

		}
		for(String key:map.keySet()){
			result.add(map.get(key));
		}
		return result;
	}

}
