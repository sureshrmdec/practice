package com.practice.algo.and.ds.interviewbit;

public class Maths_BinaryRepresentation {

	public static void main(String[] args) {
		Maths_BinaryRepresentation ss = new Maths_BinaryRepresentation();
		ss.findDigitsInBinary(0);

	}
	public String findDigitsInBinary(int a) {
		if(a==0)
			return "0";
		String s="";
		while(a!=1){
			int r = a%2;
			a = a/2;
			s=r+s;
		}
		s=1+s;
		return s;
	}
}
