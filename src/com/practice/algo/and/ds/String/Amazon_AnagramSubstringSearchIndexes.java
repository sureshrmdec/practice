package com.practice.algo.and.ds.String;

import java.util.ArrayList;
import java.util.List;

//Encountered this question in Amazon Coding
public class Amazon_AnagramSubstringSearchIndexes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Amazon_AnagramSubstringSearchIndexes o = new Amazon_AnagramSubstringSearchIndexes();
		o.getIndexesAnagram("saurabhsassa", "sa");
	}

	public List<Integer> getIndexesAnagram(String haystack,String needle){
		List<Integer> result = new ArrayList<>();
		int[] h = new int[256];
		int[] n = new int[256];
		int nL = needle.length();
		for(int i=0;i<needle.length();i++){
			h[haystack.charAt(i)]++;
			n[needle.charAt(i)]++;
		}

		for(int i=nL;i<haystack.length();i++){
			if(isAnagram(h,n)){
				result.add(i-nL);
			}
			//Add next character
			h[haystack.charAt(i)]++;
			h[haystack.charAt(i-nL)]--;
		}
		if(isAnagram(h,n)){
			result.add(haystack.length()-nL);
		}
		return result;
	}

	private boolean isAnagram(int[] h, int[] n) {
		for(int i=0;i<h.length;i++)
			if(h[i]!=n[i])
				return false;
		return true;
	}
}
