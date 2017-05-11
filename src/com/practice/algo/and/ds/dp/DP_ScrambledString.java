package com.practice.algo.and.ds.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DP_ScrambledString {

	public static void main(String[] args) {
		DP_ScrambledString o = new DP_ScrambledString();
		System.out.println(o.isScrambled("a","a"));
		
		
	}

	public boolean isScrambled(String a, String b){
		map.clear();
		 int i=0;
		 divide(a);
		 for(i=0;i<a.length();){
			 char key = b.charAt(i);
			 if(!map.containsKey(key)){
				 return false;
			 }
			 ArrayList<Character> valueList = map.get(key);
			 Character nextC = null;
			 if(i+1<a.length()){
				 nextC = (Character)b.charAt(i+1);
			 }
			 int j=0;
			 for(Character c : valueList){
				 if(c == key){
					 j=0;
					 j = j+1;
				 }else 
				 if(nextC!=null && c==nextC){
					 j=0;
					 j=j+2;
					 break;
				 }
				 
			 }
			 if(j==0)
				 return false;
			 i+=j;
		 }
		
		return true;
	}
	Map<Character,ArrayList<Character>> map = new HashMap<>();
	private void divide(String a) {
		// TODO Auto-generated method stub
		if(a.length()==2){
			if(map.get(a.charAt(0))!=null){
				ArrayList<Character> exist = map.get(a.charAt(0));
				exist.add(a.charAt(1));
			} else{
				ArrayList<Character> newL = new ArrayList<>();
				newL.add(a.charAt(1));
				map.put(a.charAt(0),newL);


			}
			if(map.get(a.charAt(1))!=null){
				ArrayList<Character> exist = map.get(a.charAt(1));
				exist.add(a.charAt(0));
			}else{
				ArrayList<Character> newL2 = new ArrayList<>();
				newL2.add(a.charAt(0));
				map.put(a.charAt(1),newL2);
			}
			return;
		}else if(a.length()==1){
			if(map.get(a.charAt(0))!=null){
				ArrayList<Character> exist = map.get(a.charAt(0));
				exist.add(a.charAt(0));
			}else{
				ArrayList<Character> newL = new ArrayList<>();
				newL.add(a.charAt(0));
				map.put(a.charAt(0),newL);
			}
			
			return;
		}
		int part = a.length()/2;
		String aa = a.substring(0,part);
		String ab = a.substring(part,a.length());
		divide(aa);
		divide(ab);
		return;
	}
}
