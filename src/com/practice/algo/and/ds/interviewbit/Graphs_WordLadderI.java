package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Graphs_WordLadderI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord = "hit";
		String endWord = "cog";
		Set<String> wordDict = new HashSet<String>();
		wordDict.add("hot");
		wordDict.add("dot");
		wordDict.add("dog");
		wordDict.add("lot");
		wordDict.add("log");
		Graphs_WordLadderI o = new Graphs_WordLadderI();
		System.out.println(o.ladderLength(beginWord, endWord, wordDict));
	}
	
	public int ladderLength(String beginWord, String endWord, Set<String> wordDict) {
	    int step = Integer.MAX_VALUE;
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(beginWord, 1));

		wordDict.add(endWord);
		
		while(!queue.isEmpty()){
			WordNode top = queue.remove();
			String word = top.word;
			int currNumSteps = top.numSteps;

			if(word.equals(endWord)){
					step = top.numSteps;
					return step;
			}
			
			char[] arr = word.toCharArray();
			for(int i=0; i<arr.length; i++){
				for(char c='a'; c<='z'; c++){
					char temp = arr[i];
					if(arr[i]!=c){
						arr[i]=c;
					}

					String newWord = new String(arr);
					if(wordDict.contains(newWord)){
						queue.add(new WordNode(newWord, top.numSteps+1));
						wordDict.remove(newWord);//This is imp step
					}

					arr[i]=temp;
				}
			}
		}
		return 0;
	
	} 
	class WordNode{
		String word;
		int numSteps;
		WordNode parent;
		public WordNode(String word, int numSteps){
			this.word = word;
			this.numSteps = numSteps;
		}
		
	}

}
