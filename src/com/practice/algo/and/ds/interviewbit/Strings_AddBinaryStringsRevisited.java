package com.practice.algo.and.ds.interviewbit;

public class Strings_AddBinaryStringsRevisited {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings_AddBinaryStringsRevisited o = new Strings_AddBinaryStringsRevisited();
		System.out.println(o.addBinary("100","111"));
	}
	public String addBinary(String a, String b) {
		
		int i = a.length()-1;
		int j = b.length()-1;
		int carry = 0;
		String res = "";
		int sum = 0;
		
		while(i>=0 || j>=0 || carry!=0){
			int ai = 0;
			sum=carry;
			if(i>=0)
				ai = a.charAt(i)-'0';
			int bj = 0;
			if(j>=0)
				bj = b.charAt(j)-'0';
			sum+=(ai+bj);
			res= (sum)%2 + res;
			carry = sum/2;
			i--;
			j--;
		}
		return res;
		
	}
}
