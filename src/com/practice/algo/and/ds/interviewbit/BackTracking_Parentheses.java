package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.List;

public class BackTracking_Parentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BackTracking_Parentheses o = new BackTracking_Parentheses();
		System.out.println(o.generateParenthesis(3));
	}

	public ArrayList<String> generateParenthesis(int n) {
		ArrayList<String> list = new ArrayList<String>();
        backtrack(list, "", 0, 0, n);
        return list;
    }
    
    public void backtrack(List<String> list, String str, int open, int close, int max){
        
        if(str.length() == max*2){
            list.add(str);
            return;
        }
        
        if(open < max)
            backtrack(list, str+"(", open+1, close, max);
        if(close < open)
            backtrack(list, str+")", open, close+1, max);
    }
}
