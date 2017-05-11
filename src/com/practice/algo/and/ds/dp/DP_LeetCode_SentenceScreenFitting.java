package com.practice.algo.and.ds.dp;

public class DP_LeetCode_SentenceScreenFitting {

	public static void main(String[] args) {
		DP_LeetCode_SentenceScreenFitting o = new DP_LeetCode_SentenceScreenFitting();
		String[] sentence = {"a", "b", "e"};
		System.out.println(o.wordsTyping(sentence, 8, 7));
		
	}
	  public int wordsTyping(String[] sentence, int rows, int cols) {
	        int spaces = sentence.length-1;
	        int wordsL = 0;
	        for(String s : sentence){
	        	wordsL+=s.length();
	        }
	        wordsL+=spaces;
	        int totalSpace = rows*cols;
	        int num = 1;
	        int words = wordsL;
	        while(words<=totalSpace){
   	        	num++;
	        	words+=wordsL + 1;
	        }
	        
	        return num;
	    }
}
