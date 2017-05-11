package com.practice.algo.and.ds.implementation;

import java.util.Scanner;

public class CheckSubString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String s2 = sc.next();
		int j=0;int i;
		for(i=0;i<s.length();){
			char c = s.charAt(i);
			for(;j<s2.length();){
				char c2 = s2.charAt(j);
				if(c==c2){
					i++;
					j++;
					if(j==s2.length()){
						System.out.println("valid");
					}
					break;
				}else{
					i=i;
					j=0;
					break;
				}
				
			}
		}
	}

}
