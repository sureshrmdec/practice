package com.practice.algo.and.ds.interview.questions;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

//https://www.careercup.com/question?id=4855286160424960
public class CareerCup_MinSubStringContaingAllCharacters {

	public static void main(String[] args) {
		CareerCup_MinSubStringContaingAllCharacters c = new CareerCup_MinSubStringContaingAllCharacters();
		c.findMinSubString("adobecodebanc", "abc");
	}
	public String findMinSubString(String a,String str){
		int bestL = 0;
		int startIndex = -1;
		int endIndex = -1;
		int[] indexes = new int[26];
		Arrays.fill(indexes, -1);
		Set<Character> set = new HashSet<Character>();
		for(int i=0;i<a.length();i++){
			char c = a.charAt(i);
			if(str.contains(a.substring(i, i+1))){
				if(startIndex==-1){
					startIndex = i;
					endIndex = startIndex;
					indexes[c-'a'] = i;
				}else{
					if(indexes[c-'a']!=-1){
						int indeofThat = indexes[c-'a'];
						int sd = startIndex;
						for(int k = sd;k<=indeofThat;k++){
							char cc = a.charAt(k);
							if(indexes[cc-'a']!=-1){
								indexes[cc-'a']=-1;
							}
							startIndex++;
						}
						while(indexes[a.charAt(startIndex)-'a'] == -1){
							startIndex++;
						}
						indexes[c-'a'] = i;
						endIndex=i;
					}else{
						indexes[c-'a'] = i;
						endIndex=i;
					}
				}
			}
		}

		return "";
	}

	
	/*class Solution {
		  public static void main(String[] args) {
		    Solution s = new Solution();
		    int[] a = {1, 3, 5, 23, 2};
		    int sum = 24;
		    System.out.println(s.isSumContigous(a,sum));
		  }
		  
		  public boolean isSumContigous(int[] a,int sum){
		    int startIndex=0;
		    int currSum=a[0];
		    for(int i=1;i<a.length;i++){
		        currSum+=a[i];
		        if(currSum>sum){
		            while(currSum>sum){
		                currSum = currSum - a[startIndex];
		                startIndex++;
		            }
		        }
		      if(currSum==sum)
		              return true;
		    }
		    return false;
		  }
		  
		}*/

}




