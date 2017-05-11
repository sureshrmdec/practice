package com.practice.algo.and.ds.interview.questions;

public class TwoPointers_LeetCode_ShortestDistanceI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
    public int shortestDistance(String[] words, String firstWord, String secondWord) {
        int p1 = -1;
        int p2 = -1;
    int distance = Integer.MAX_VALUE;
     for (int i = 0; i < words.length; i++) {
        if (words[i].equals(firstWord)) {
            p1 = i;
        } else if (words[i].equals(secondWord)) {
            p2 = i;
        }

        if (p1 != -1 && p2 != -1) {
            distance = Math.min(distance, Math.abs(p1 - p2));
        }
    }

    return distance;
    
}
}
