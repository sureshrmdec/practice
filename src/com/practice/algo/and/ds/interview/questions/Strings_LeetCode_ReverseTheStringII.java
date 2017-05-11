package com.practice.algo.and.ds.interview.questions;

public class Strings_LeetCode_ReverseTheStringII {

	public static void main(String[] args) {
		String s = "the sky is blue";
		Strings_LeetCode_ReverseTheStringII o = new Strings_LeetCode_ReverseTheStringII();
		o.reverseWords(s.toCharArray());
		

	}
	public void reverseWords(char[] s) {
	    // Three step to reverse
	    // 1, reverse the whole sentence
	    reverse(s, 0, s.length - 1);
	    // 2, reverse each word
	    int start = 0;
	    for (int i = 0; i < s.length; i++) {
	        if (s[i] == ' ') {
	            reverse(s, start, i - 1);
	            start = i + 1;
	        }
	    }
	    // 3, reverse the last word, if there is only one word this will solve the corner case
	    reverse(s, start, s.length - 1);
	    System.out.println(s);
	}

	public void reverse(char[] s, int start, int end) {
	    while (start < end) {
	        char temp = s[start];
	        s[start] = s[end];
	        s[end] = temp;
	        start++;
	        end--;
	    }
	}
}
