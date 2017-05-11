package com.practice.algo.and.ds.String;

public class Strings_ReversetheString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings_ReversetheString d = new Strings_ReversetheString();
		System.out.println(d.reverseWordsProgramCreek("  the sky is blue"));
		System.out.println(d.reverseWords("   the  sky  is  blue"));

	}
	public String reverseWords(String a) {
		String word = "";
		String sentence = "";
		boolean justFormed = false;
		for(int i=a.length()-1;i>=0;i--){
			if(a.charAt(i) != ' '){
				word=a.charAt(i)+word;
				justFormed = true;
			}
			if((a.charAt(i) == ' ' && justFormed)){
				sentence+= word + ' ';
				word  = "";
				justFormed = false;
			}
			if(i==0  && justFormed){
				sentence+= word + ' ';
				
			}
		}
		return sentence.substring(0, sentence.length()-1);
	}
	
	//I ll go with this one..simple
	public String reverseWordsProgramCreek(String s) {
		if (s == null || s.length() == 0) {
			return "";
		}
 
		// split to words by space
		String[] arr = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = arr.length - 1; i >= 0; --i) {
			if (!arr[i].equals("")) {
				sb.append(arr[i]).append(" ");
			}
		}
		return sb.length() == 0 ? "" : sb.substring(0, sb.length() - 1);
	}
}
