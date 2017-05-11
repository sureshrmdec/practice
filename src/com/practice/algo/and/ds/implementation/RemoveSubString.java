package com.practice.algo.and.ds.implementation;

import java.util.ArrayList;
import java.util.List;

public class RemoveSubString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = new String("abcdbabcd");
		String[] set = {"ac","b"};
		List<String> subStrs = new ArrayList<String>();
		subStrs.add("ab");
		subStrs.add("bcd");
		removeStrings(s);
		
		String curr = new String();
		for(int i=0;i<s.length();i++){
			curr+=s.charAt(i);
			for(String st:set){
				if(curr.contains(st)){
					curr = curr.substring(0,curr.indexOf(st));
				}
			}
			
		}
		System.out.println(curr);
	}
	private static String removeStrings(String str) {
		if(str.contains("ab") || str.contains("bcd")) {
			str = str.replace("bcd", "");
			str = str.replace("ab", "");
			
			
			return removeStrings(str);
		}	
		return str;	
	}
	
}
