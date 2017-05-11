package com.practice.algo.and.ds.interview.questions;
//https://www.careercup.com/question?id=5673460861763584
//Remove 3 consecutive duplicates from string. 
//INPUT:aabbbaccddddc 
//OUTPUT:ccdc

public class CarrerCup_Amazon_Remove3DuplicatesFromStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CarrerCup_Amazon_Remove3DuplicatesFromStrings o = new CarrerCup_Amazon_Remove3DuplicatesFromStrings();
		o.removeThreeDuplicates("aabbbaccddddc");
	}

	public String removeThreeDuplicates(String in){
		int[] a = new int[in.length()];
		String result = "";

		for(int i=0;i<in.length();i++){
			if(i==0){
				a[i]=1;
				continue;
			}
			if(in.charAt(i)==in.charAt(i-1)){
				a[i]=a[i-1]+1;
			}else
				a[i]=1;
			if(a[i]==3){
				in = in.substring(0, i-2).concat(in.substring(i+1));
				i = i-3;
			}
		}
		return in;
	}
	
	//Soln fron CareerCup
	private static String removeTriplicate(StringBuilder input) {
		int start = 0;
		
		while (start < input.length() - 2) {
			if (input.charAt(start) == input.charAt(start + 1) && input.charAt(start) == input.charAt(start + 2)) {
				input.deleteCharAt(start);
				input.deleteCharAt(start);
				input.deleteCharAt(start);

				start = 0;
			} else {
				start = start + 1;
			}

		}

		return input.toString();
	}
}
