package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class BackTracking_LetterPhoneRevisited {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackTracking_LetterPhoneRevisited o = new BackTracking_LetterPhoneRevisited();
		o.letterCombinations("234");
	}

	public ArrayList<String> letterCombinations(String digits) {
		ArrayList<String> result = new ArrayList<>();
		Map<String,String> letterMap = new HashMap<>();
			letterMap.put("0", "0");
		letterMap.put("1", "1");
		letterMap.put("2", "abc");
		letterMap.put("3", "def");
		letterMap.put("4", "ghi");
		letterMap.put("5", "jkl");
		letterMap.put("6", "mno");
		letterMap.put("7", "pqrs");
		letterMap.put("8", "tuv");
		letterMap.put("9", "wxyz");
		getCombinations(result,new String(),digits,0,letterMap);
		return result;
    }

	private void getCombinations(ArrayList<String> result, String soFar, String digits, int i,Map<String, String> letterMap) {
		
		if(i==digits.length()){
			result.add(soFar);
			return;
		}
		String str = digits.substring(i, i+1);
		for(int j=0;j<letterMap.get(str).length();j++){
			soFar+=(letterMap.get(str).charAt(j));
			getCombinations(result, soFar, digits, i+1, letterMap);
			soFar= soFar.substring(0, soFar.length()-1);
		}
	}
}
