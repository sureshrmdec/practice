package com.practice.algo.and.ds.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Graphs_LeetCode_RemoveInvalidParenthses {

	public static void main(String[] args) {
		Graphs_LeetCode_RemoveInvalidParenthses o = new Graphs_LeetCode_RemoveInvalidParenthses();
		//()())
		System.out.println(o.removeInvalidParentheses("()())"));

	}
	//https://discuss.leetcode.com/topic/28827/share-my-java-bfs-solution/2
	public List<String> removeInvalidParenthesesBFS(String s) {
	      List<String> res = new ArrayList<>();
	      
	      // sanity check
	      if (s == null) return res;
	      
	      Set<String> visited = new HashSet<>();
	      Queue<String> queue = new LinkedList<>();
	      
	      // initialize
	      queue.add(s);
	      visited.add(s);
	      
	      boolean found = false;
	      
	      while (!queue.isEmpty()) {
	        s = queue.poll();
	        
	        if (isValid(s)) {
	          // found an answer, add to the result
	          res.add(s);
	          found = true;
	        }
	      
	        if (found) continue;
	      
	        // generate all possible states
	        for (int i = 0; i < s.length(); i++) {
	          // we only try to remove left or right paren
	          if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
	        
	          String t = s.substring(0, i) + s.substring(i + 1);
	        
	          if (!visited.contains(t)) {
	            // for each state, if it's not visited, add it to the queue
	            queue.add(t);
	            visited.add(t);
	          }
	        }
	      }
	      
	      return res;
	    }
	    
	    // helper function checks if string s contains valid parantheses
	    boolean isValid(String s) {
	      int count = 0;
	    
	      for (int i = 0; i < s.length(); i++) {
	        char c = s.charAt(i);
	        if (c == '(') count++;
	        if (c == ')' && count-- == 0) return false;
	      }
	    
	      return count == 0;
	    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<String> removeInvalidParentheses(String s) {
	    int extraOpenBracket = 0, extraCloseBracket = 0;
	    for (int i = 0; i < s.length(); i++) {
	        if (s.charAt(i) == '(') {
	        	extraOpenBracket++;
	        } else if (s.charAt(i) == ')') {
	            if (extraOpenBracket != 0) {
	            	extraOpenBracket--;
	            } else {
	            	extraCloseBracket++;
	            }
	        }
	    }
	    Set<String> res = new HashSet<>();
	    dfs(s, 0, res, new StringBuilder(), extraOpenBracket, extraCloseBracket, 0);
	    return new ArrayList<String>(res);
	}

	public void dfs(String s, int i, Set<String> res, StringBuilder sb, int extraOpenBracket, int extraCloseBracket, int open) {
	    if (extraOpenBracket < 0 || extraCloseBracket < 0 || open < 0) { //if less tan zero...that means it shouldnt be removed...as this (rmL or rmR) is not extra.
	        return;
	    }
	    if (i == s.length()) {
	        if (extraOpenBracket == 0 && extraCloseBracket == 0 && open == 0) {
	            res.add(sb.toString());
	        }        
	        return;
	    }

	    char c = s.charAt(i); 
	    int len = sb.length();

	    if (c == '(') {
	        dfs(s, i + 1, res, sb, extraOpenBracket - 1, extraCloseBracket, open);		    // not use (
	    	dfs(s, i + 1, res, sb.append(c), extraOpenBracket, extraCloseBracket, open + 1);       // use (

	    } else if (c == ')') {
	        dfs(s, i + 1, res, sb, extraOpenBracket, extraCloseBracket - 1, open);	            // not use  )
	    	dfs(s, i + 1, res, sb.append(c), extraOpenBracket, extraCloseBracket, open - 1);  	    // use )

	    } else {
	        dfs(s, i + 1, res, sb.append(c), extraOpenBracket, extraCloseBracket, open);	
	    }

	    sb.setLength(len);        
	}
}
