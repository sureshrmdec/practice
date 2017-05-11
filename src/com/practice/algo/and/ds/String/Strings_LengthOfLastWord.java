package com.practice.algo.and.ds.String;

public class Strings_LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int lengthOfLastWord(final String a) {
		int c = 0;
		boolean found = false; //Found atleast one character
		for(int s=a.length()-1;s>=0;s--){
			if(a.charAt(s)==' '){
				if(found){
					break;
				}
				continue;
			}else{
				found = true;
				c++;
			}
		}
		return c;
	
	}
}
