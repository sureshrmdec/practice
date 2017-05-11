package com.practice.algo.and.ds.interview.questions;

public class TwoPointers_LeetCode_ShortestWordDistanceIII {

	public static void main(String[] args) {

		String[] words = {"practice","makes","perfect","coding","makes"};
		TwoPointers_LeetCode_ShortestWordDistanceIII o = new TwoPointers_LeetCode_ShortestWordDistanceIII();
		System.out.println(o.shortestWordDistance(words,"makes", "makes"));
		System.out.println(o.shortestWordDistance(words,"coding", "practice"));
		System.out.println(o.shortestWordDistance(words,"coding", "makes"));
	}
	public int shortestWordDistance(String[] words, String word1, String word2) {
	    long dist = Integer.MAX_VALUE, i1 = dist, i2 = -dist;
	    for (int i=0; i<words.length; i++) {
	        if (words[i].equals(word1))
	            i1 = i;
	        if (words[i].equals(word2)) {
	            if (word1.equals(word2))
	                i1 = i2;
	            i2 = i;
	        }
	        dist = Math.min(dist, Math.abs(i1 - i2));
	    }
	    return (int) dist;
	}
}
