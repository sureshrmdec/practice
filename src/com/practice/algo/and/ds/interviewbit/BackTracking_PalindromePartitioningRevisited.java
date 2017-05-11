package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class BackTracking_PalindromePartitioningRevisited {

	public static void main(String[] args) {
		BackTracking_PalindromePartitioningRevisited o = new BackTracking_PalindromePartitioningRevisited();
		System.out.println(o.partitionLeetCode("aaba"));
		System.out.println(o.partition("aaba"));

	}
	
	public List<List<String>> partitionLeetCode(String s) {
		   List<List<String>> list = new ArrayList<>();
		   backtrack(list, new ArrayList<>(), s, 0);
		   return list;
		}

		public void backtrack(List<List<String>> list, List<String> tempList, String s, int start){
		   if(start == s.length())
		      list.add(new ArrayList<>(tempList));
		   else{
		      for(int i = start; i < s.length(); i++){
		         if(isPalindrome(s, start, i)){
		            tempList.add(s.substring(start, i + 1));
		            backtrack(list, tempList, s, i + 1);
		            tempList.remove(tempList.size() - 1);
		         }
		      }
		   }
		}

		public boolean isPalindrome(String s, int low, int high){
		   while(low < high)
		      if(s.charAt(low++) != s.charAt(high--)) return false;
		   return true;
		} 
		
	//-------------------------- My Soln -----------
	//--------------------------
	public ArrayList<ArrayList<String>> partition(String s) {

		ArrayList<ArrayList<String>> result = new ArrayList<>();
		if(s==null || s.length()==0)
			return result;		
		if(isPalindrome(s)){
			ArrayList<String> full = new ArrayList<>();
			full.add(s);
			result.add(full);
		}
		for(int i=0;i<s.length();i++){
			String part = s.substring(0, i+1);
			
			if(isPalindrome(part)){

				ArrayList<ArrayList<String>> r = partition(s.substring(i+1));
				for(int l=0;l<r.size();l++){
					ArrayList<String> ll = r.get(l);
					ll.add(0,part);
					result.add(ll);
				}
				
			}
		}
		return result;
	}

	public boolean isPalindrome(String s) {
		int l = 0;
		int h = s.length()-1;
		while(l<h){
			if (s.charAt(l) != s.charAt(h)) {
				return false;
			}
			l++;
			h--;
		}
		return true;
	}

}
