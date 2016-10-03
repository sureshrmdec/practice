package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BackTracking_LetterPhone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		letterCombinations("23");
	}
	
	
	public static List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		Map<String,String> letterMap = new HashMap<>();
		letterMap.put("2", "abc");
		letterMap.put("3", "def");
		getCombinations(result,new StringBuilder(),digits,0,letterMap);
		return result;
    }


	private static void getCombinations(List<String> result,StringBuilder soFar,String digits, int i, Map<String,String> letterMap) {
		// TODO Auto-generated method stub
		if(soFar.length()==digits.length()){
			result.add(soFar.toString());
			return ;
		}
		String currIndex = digits.substring(i, i+1);
		String currString = letterMap.get(currIndex);
		
		for(int c=0; c<currString.length(); c++){
	        soFar.append(currString.charAt(c));
	        getCombinations(result, soFar, digits, i+1, letterMap);
	        soFar.deleteCharAt(soFar.length()-1);
	    }
	}
}
