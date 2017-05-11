package com.practice.algo.and.ds.backtracking;

import java.util.ArrayList;
import java.util.List;

/*For example, given s = "aab",
Return

[
  ["aa","b"],
  ["a","a","b"]
]
 */		
public class BackTracking_PalindromePartitioning {

	public static void main(String[] args) {
		BackTracking_PalindromePartitioning o = new BackTracking_PalindromePartitioning();
		System.out.println(o.partition("caabb"));

	}
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
		partitionHelper(s,result,new ArrayList<>(),0);
		return result;
	}
	private void partitionHelper(String s, List<List<String>> result, ArrayList<String> tmpList, int start) {

		if(start==s.length()){
			result.add(new ArrayList<>(tmpList));
			return;
		}

		for(int j=start+1;j<=s.length();j++){
			if(isPalindrome(s.substring(start,j))){
				tmpList.add(s.substring(start,j));
				partitionHelper(s, result, tmpList, j);
				tmpList.remove(tmpList.size()-1);
			}
		}
	}

	private boolean isPalindrome(String s) {
		int i=0;
		int j = s.length()-1;
		while(i<j){
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
}
