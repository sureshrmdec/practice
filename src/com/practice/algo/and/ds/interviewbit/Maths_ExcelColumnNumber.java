package com.practice.algo.and.ds.interviewbit;

public class Maths_ExcelColumnNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Maths_ExcelColumnNumber o = new Maths_ExcelColumnNumber();
		o.titleToNumber("ABC");
	}
	public int titleToNumber(String a) {
		int r = 0;
		int p=0;
		for(int i=a.length()-1;i>=0;i--){
			int c = a.charAt(i)-3;
			c+= 1;
			r = r + (int)Math.pow(26, p)*c;
			p++;
		}
		return r;
	}
}
