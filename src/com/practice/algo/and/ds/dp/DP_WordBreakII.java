package com.practice.algo.and.ds.dp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DP_WordBreakII {

	public static void main(String[] args) {
		DP_WordBreakII o = new DP_WordBreakII();
		Set<String> wordDict = new HashSet<>();
		wordDict.add("cat");
		wordDict.add("cats");
		wordDict.add("and");
		wordDict.add("sand");
		wordDict.add("dog");
		
		wordDict.add("kesor");
		wordDict.add("r");
		wordDict.add("i");
		wordDict.add("li");
		wordDict.add("likes");
		wordDict.add("likeso");
		wordDict.add("ili");

		System.out.println(o.wordBreak("ilikesor", wordDict));
		//System.out.println(o.wordBreak("aaaaaaa", wordDict));
		//System.out.println(o.wordBreak2("ilikesor", wordDict));
		//System.out.println(o.wordBreak2("aaaaaaa", wordDict));
		System.out.println(o.wordBreak3("ilikesor", wordDict));
	}
	
	
	
	//https://discuss.leetcode.com/category/148/word-break-ii
		//Another Solution
	//I will go with this one!!!
		//I can go with this one too...as it is recursive and DP (using map to store the results)(memoization)
		public List<String> wordBreak3(String s, Set<String> wordDict) {
		    return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
		}       

		// DFS function returns an array including all substrings derived from s.
		List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
		    if (map.containsKey(s)) 
		        return map.get(s);
		        
		    LinkedList<String>res = new LinkedList<String>();     
		    if (s.length() == 0) {
		        res.add("");
		        return res;
		    }               
		    for (String word : wordDict) {
		        if (s.startsWith(word)) {
		            List<String>sublist = DFS(s.substring(word.length()), wordDict, map);
		            for (String sub : sublist) 
		                res.add(word + (sub.isEmpty() ? "" : " ") + sub);               
		        }
		    }       
		    map.put(s, res); //put it in map once find all the break downs of the string...in other terms memoize
		    return res;
		}
	
	
	
	
	
	public static List<String> wordBreak(String s, Set<String> dict) {
	    //create an array of ArrayList<String>
	    List<String>[] dp = new ArrayList[s.length()+1];
	    dp[0] = new ArrayList<String>();
	 
	    for(int i=0; i<s.length(); i++){
	        if( dp[i] == null ) 
	            continue; 
	 
	        for(String word:dict){
	            int len = word.length();
	            int end = i+len;
	            if(end > s.length()) 
	                continue;
	            String current = s.substring(i,end);
	            if(current.equals(word)){
	                if(dp[end] == null){
	                    dp[end] = new ArrayList<String>();
	                }
	                dp[end].add(word);
	            }
	        }
	    }
	 
	    List<String> result = new LinkedList<String>();
	    if(dp[s.length()] == null) 
	        return result; 
	 
	    ArrayList<String> temp = new ArrayList<String>();
	    dfs(dp, s.length(), result, temp);
	 
	    return result;
	}
	 
	public static void dfs(List<String> dp[],int end,List<String> result, ArrayList<String> tmp){
	    if(end <= 0){
	        String path = tmp.get(tmp.size()-1);
	        for(int i=tmp.size()-2; i>=0; i--){
	            path += " " + tmp.get(i) ;
	        }
	 
	        result.add(path);
	        return;
	    }
	 
	    for(String str : dp[end]){
	        tmp.add(str);
	        dfs(dp, end-str.length(), result, tmp);
	        tmp.remove(tmp.size()-1);
	    }
	}
	
	
	
	
}
