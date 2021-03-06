package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class BackTracking_PalindromePartitioning {

	public static void main(String[] args) {
		BackTracking_PalindromePartitioning o = new BackTracking_PalindromePartitioning();
		System.out.println(o.partition("aaba"));

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


	public ArrayList<ArrayList<String>> partition(String s) {
		int length = s.length();

		ArrayList<ArrayList<String>> partitions = new ArrayList<>();

		if(isPalindrome(s)){
			ArrayList<String> p = new ArrayList<>();
			p.add(s);
			partitions.add(p);
		}

		for(int i=1; i<length; i++){
			String s1 = s.substring(0,i);
			String s2 = s.substring(i);

			// if s1 is palindrome then get partitions for s2, no need to check partitions of s1 as its alredy processed in previous iteration
			if(isPalindrome(s1)){
				ArrayList<ArrayList<String>> p2 = partition(s2);
				for(ArrayList<String> p : p2){
					// append s1 at beginning to all partitions returned for s2
					p.add(0, s1);
				}

				partitions.addAll(p2);
			}
		}

		return partitions;
	}
}
