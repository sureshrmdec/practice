package com.practice.algo.and.ds.interviewbit;

public class LengthofLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = " hello d ";
		
		LengthofLastWord o = new LengthofLastWord();
		System.out.println(o.lengthOfLastWord(s));
	}
	public int lengthOfLastWord(final String a) {
		int c = 0;
		boolean found = false;
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
