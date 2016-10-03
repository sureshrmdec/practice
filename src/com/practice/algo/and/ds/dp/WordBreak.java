package com.practice.algo.and.ds.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class WordBreak {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WordBreak wb = new WordBreak();
		String str = "samsung";
		list.addAll(Arrays.asList(dictionary));
		wb.canSegemented(str);
	}

	private boolean canSegemented(String str) {
		// TODO Auto-generated method stub
		int size = str.length();
		if(size==0)
			return true;
		  // Try all prefixes of lengths from 1 to size
	    for (int i=1; i<str.length(); i++)
	    {
	        // The parameter for dictionaryContains is str.substr(0, i)
	        // str.substr(0, i) which is prefix (of input string) of
	        // length 'i'. We first check whether current prefix is in
	        // dictionary. Then we recursively check for remaining string
	        // str.substr(i, size-i) which is suffix of length size-i
	        if (list.contains( str.substring(0, i) ) &&
	        		canSegemented( str.substring(i))){
	        	 return true;
	        }
	           
	    }
		return false;
	}

	private static String[] dictionary = {"mobile","samsung","man","mango",
        "icecream","and","go","i","like","ice","cream"};
	private static ArrayList<String> list = new ArrayList<String>();
	
}
