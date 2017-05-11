package com.practice.algo.and.ds.String;

public class Strings_MinimumCharactersRequiredToMakeStringPalindromic {

	public static void main(String[] args) {
		Strings_MinimumCharactersRequiredToMakeStringPalindromic o = new Strings_MinimumCharactersRequiredToMakeStringPalindromic();
		System.out.println(o.minCharacters("AACECAAAA"));

	}
	public int minCharacters(String in){
		int result = Integer.MAX_VALUE;
		for(int i=0;i<in.length();i++){
			if(isPalindrome(in.substring(0, i+1))){
				result = Integer.min(result, in.length()-(i+1));
			}
		}
		return result;
	}
	private boolean isPalindrome(String substring) {
		if(substring.length()==1 || substring.length()==0){
			return true;
		}
		else{
			int l = 0;
			int h = substring.length()-1;
			while(l<h){
				if(substring.charAt(l)!=substring.charAt(h))
					return false;
				l++;
				h--;
			}
		}
		return true;
	}

}
