package com.practice.algo.and.ds.interviewbit;

public class Strings_PalindromeString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Strings_PalindromeString sp = new Strings_PalindromeString();
		System.out.println(sp.isPalindrome("''"));
	}
	public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
        	return true;
        }
        int head = 0, tail = s.length() - 1;
        char cHead, cTail;
        while(head <= tail) {
        	cHead = s.charAt(head);
        	cTail = s.charAt(tail);
        	if (!Character.isLetterOrDigit(cHead)) {
        		head++;
        	} else if(!Character.isLetterOrDigit(cTail)) {
        		tail--;
        	} else {
        		if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
        			return false;
        		}
        		head++;
        		tail--;
        	}
        }
        
        return true;
    }
}
