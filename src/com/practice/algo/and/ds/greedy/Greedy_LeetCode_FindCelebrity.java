package com.practice.algo.and.ds.greedy;

public class Greedy_LeetCode_FindCelebrity {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public int findCelebrity(int n) {
        int candidate = 0;
        for(int i = 1; i < n; i++){
            if(knows(candidate, i))
                candidate = i;
        }
        for(int i = 0; i < n; i++){
            if(i != candidate && (knows(candidate, i) || !knows(i, candidate))) //candidate = potential celeb knows somebody i.e. knows(candidate, i)
            	return -1;														//or somebody does not know potential celeb i.e. !knows(i, candidate)
            	
        }
        return candidate;
    }
	  
	  boolean knows(int a, int b){
		  return true;
	  }
}
