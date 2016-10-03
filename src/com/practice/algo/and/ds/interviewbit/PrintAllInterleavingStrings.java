package com.practice.algo.and.ds.interviewbit;

public class PrintAllInterleavingStrings {

	public static void main(String[] args) {
		PrintAllInterleavingStrings o = new PrintAllInterleavingStrings();
		o.printStrings("abc","def",new String());

	}
	
	public void printStrings(String a,String b,String sa){
		String soFar = new String(sa);
		
		if(a.isEmpty()){
			System.out.println(soFar+b);
			return;
			}
		if(b.isEmpty()){
			System.out.println(soFar+a);
			return;
		}
		if(a.isEmpty() && b.isEmpty()){
			return;
		}
		printStrings(a.substring(1), b,soFar + a.charAt(0));
		printStrings(a, b.substring(1),soFar + b.charAt(0));

	}

}
