package com.practice.algo.and.ds.interviewbit;

public class Strings_ReversetheString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings_ReversetheString d = new Strings_ReversetheString();
		System.out.println(d.reverseWords(" ankrqzzcel  dyaiug y rkicv t"));

	}
	public String reverseWords(String a) {
		String r = "";
		String rs = "";
		boolean justFormed = false;
		for(int i=a.length()-1;i>=0;i--){
			if(a.charAt(i) != ' '){
				r=a.charAt(i)+r;
				justFormed = true;
			}
			if((a.charAt(i) == ' ' && justFormed)){
				rs+= r + ' ';
				r  = "";
				justFormed = false;
			}
			if(i==0  && justFormed){
				rs+= r + ' ';
				
			}
		}
		return rs.substring(0, rs.length()-1);
	}
}
