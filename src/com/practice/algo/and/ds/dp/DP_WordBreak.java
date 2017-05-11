package com.practice.algo.and.ds.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DP_WordBreak {
	
	
	
	public static void main(String[] args) {
	
		//String s = "leetcode";
		Set<String> wordDict = new HashSet<String>();
		//wordDict.add("leet");
		//wordDict.add("code");
		
		String s = "ilikesor";
		//wordDict.add("i");
		//wordDict.add("li");
		//wordDict.add("likes");
	//	wordDict.add("likeso");
		//wordDict.add("kesor");
		wordDict.add("my");
		wordDict.add("interview");
		wordDict.add("trainer");
		
		DP_WordBreak o = new DP_WordBreak();
		//o.wordBreak(s, wordDict);
		//o.wordBreakDP("likesamsungmangogoicecreamicemobile");
		o.wordBreakLeetCodeDiscuss("myinterviewtrainer", wordDict);
		hasValidWords("ilikesor");
		
	}
	
	//Leet Code
	public boolean wordBreak(String s, Set<String> wordDict) {
     

		
		boolean[][] dp = new boolean[s.length()+1][s.length()+1];
		
		int j=0;
		for(int i=1;i<=s.length();i++){
			if(wordDict.contains(s.substring(i-1, i))){
				dp[i][i] = true;
			} 
		}
		
		for(int l=1;l<=s.length();l++){
			for(int i = 1;i<=s.length()-l+1;i++){
				j = i+l;
				if(wordDict.contains(s.substring(i-1, j-1))){
					dp[i][j-1] = true;
				}else{
					for(int ss=0;ss<j-i-1;ss++){
						if(dp[i][i+ss] && dp[i+ss+1][j-1]){
							dp[i][j-1] = true;		
						}
					}
				}
				
			}	
		}
		
		return dp[1][s.length()];
		
		
    }
	
	//Interview Bit but did not get accepted
	public int wordBreak(String s, ArrayList<String> b) {
		boolean[][] dp = new boolean[s.length()+1][s.length()+1];
		
		int j=0;
		for(int i=1;i<=s.length();i++){
			if(b.contains(s.substring(i-1, i))){
				dp[i][i] = true;
			} 
		}
		
		for(int l=1;l<=s.length();l++){
			for(int i = 1;i<=s.length()-l+1;i++){
				j = i+l;
				if(b.contains(s.substring(i-1, j-1))){
					dp[i][j-1] = true;
				}else{
					for(int ss=0;ss<j-i-1;ss++){
						if(dp[i][i+ss] && dp[i+ss+1][j-1]){
							dp[i][j-1] = true;		
						}
					}
				}
				
			}	
		}
		
		return dp[1][s.length()]?1:0;
		
		
    
	}

	boolean dictionaryContains(String word)
	{
	    String[] dictionary = {"mobile","samsung","sam","sung","man","mango",
	                           "icecream","and","go","i","like","ice","cream"};
	    ArrayList<String> d = new ArrayList<>(Arrays.asList(dictionary));
	    
	    
	        if (d.contains(word))
	           return true;
	    return false;
	}
	//GeeksForGeeks Recursion
	boolean wordBreak(String str)
	{
	    int size = str.length();
	 
	    // Base case
	    if (size == 0)  return true;
	 
	    // Try all prefixes of lengths from 1 to size
	    for (int i=1; i<=size; i++)
	    {
	        // The parameter for dictionaryContains is str.substr(0, i)
	        // str.substr(0, i) which is prefix (of input string) of
	        // length 'i'. We first check whether current prefix is in
	        // dictionary. Then we recursively check for remaining string
	        // str.substr(i, size-i) which is suffix of length size-i
	        if (dictionaryContains( str.substring(0, i) ) &&
	            wordBreak( str.substring(i, size) ))
	            return true;
	    }
	 
	    // If we have tried all prefixes and none of them worked
	    return false;
	}
	
	//http://www.ideserve.co.in/learn/word-break-problem
	//private static final Set<String> dictionary = new HashSet<String>(Arrays.asList("arrays" , "dynamic" , "heaps" , "IDeserve" , "learn" , "learning" , "linked" , "list" , "platform" , "programming" , "stacks" , "trees" ));
	private static final Set<String> dictionary = new HashSet<String>(Arrays.asList("i","li","like","sor"));
	//private static final Set<String> dictionary = new HashSet<String>(Arrays.asList("i","li","likes","likeso","r"));
	public static boolean hasValidWords(String words) {
			        
			         
			        if(words == null || words.length() == 0) {
			            return true;
			        }
			
			        int n = words.length();
			        boolean[] validWords = new boolean[n];
			        for (int i = 0; i < n; i++) {
			            if (dictionary.contains(words.substring(0, i + 1))) {
			                validWords[i] = true;
			            }
			            if (validWords[i]) {
			                for (int j = i + 1; j < n; j++) {
			                    if (dictionary.contains(words.substring(i + 1, j + 1))) {
			                        validWords[j] = true;
			                    }
			                    if (j == n - 1 && validWords[j] == true) {
			                        return true;
			                    }
			                }
			            }
			        }
			        return false;
			    }
	

	//I will go with this one
	public boolean wordBreakLeetCodeDiscuss(String s, Set<String> dictionary) {

        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        // i denote length of string, dp[i] = true implies string of length i (from beginning) is valid
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i-1; j >= 0; j--) {
                // start from end and check if string till length j is valid && substring from j+1 length to i is valid 
                /* example 
                     to find dp[5] check (all numbers in terms of length, not index)  
                            - or 1-4 is valid and 5 contains in dictionary  
                            - or 1-3 is valid and 4-5 contains in dictionary
                            - or 1-2 is valid and 3-5 contains in dictionary
                            - or 1 is valid and 2-5 contains in dictionary
                            - or if 1-5 contains in dictionary
                            
                            break on first true condition and set dp[5] = true
                            
                */
            	System.out.println(s.substring(j, i));
                if(dp[j] && dictionary.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }

}
