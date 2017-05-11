package com.practice.algo.and.ds.implementation;

public class AdditionalMissingCharacter {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//We have to find the longest string first, i am not doing here...
		String s = "saurabh";
		String s2 = "saurbh";
		int i =0;
		
		while(true){
			if(((s.charAt(i)-'0')^(s2.charAt(i)-'0'))!=0){
				System.out.println(s.charAt(i));
				
				break;
			}
			i++;
		}
	}

}
