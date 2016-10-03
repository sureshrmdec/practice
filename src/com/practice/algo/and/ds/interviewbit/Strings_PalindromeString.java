package com.practice.algo.and.ds.interviewbit;

public class Strings_PalindromeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings_PalindromeString sp = new Strings_PalindromeString();
		System.out.println(sp.isPalindrome("''"));
	}
	public int isPalindrome(String a) {
		a = a.toLowerCase();

		int i=0;
		int j = a.length()-1;
		while(i<=j){
			boolean ia = true;
			while(ia && i<=a.length()-1)
					if(!(a.charAt(i)-0>=48 && a.charAt(i)-0<=57 || (a.charAt(i)-0>=97 && a.charAt(i)-0<=122))){
						i++;
					}else{
						ia=false;

					}
			boolean ja = true;
			while(ja && j>=0)
					if(!(a.charAt(j)-0>=48 && a.charAt(j)-0<=57 || (a.charAt(j)-0>=97 && a.charAt(j)-0<=122))){
						j--;
					}else{
						ja=false;

					}
			if(i<=j)
			if(a.charAt(i)!=a.charAt(j)){
				return 0;
			}
			i++;
			j--;
		}
		
		return 1;
	}
}
