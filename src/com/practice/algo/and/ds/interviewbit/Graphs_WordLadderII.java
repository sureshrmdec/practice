package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Graphs_WordLadderII {

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
		Graphs_WordLadderII o = new Graphs_WordLadderII();
		
		o.ladderLength(beginWord, endWord, wordDict);
	}

	class WordNode{
		String word;
		int numSteps;
		WordNode parent;

		public WordNode(String word, int numSteps,WordNode parent){
			this.word = word;
			this.numSteps = numSteps;
			this.parent = parent;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return word +" and parent word is "+ parent.word;
		}
	}

	public List<List<String>> ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		List<List<String>> res = new ArrayList<>();
		int step = Integer.MAX_VALUE;
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		queue.add(new WordNode(beginWord, 1,null));

		wordDict.add(endWord);
		HashSet<String> visited = new HashSet<String>();  
		HashSet<String> unvisited = new HashSet<String>();  
		unvisited.addAll(wordDict);

		int preNumSteps = 0;
		while(!queue.isEmpty()){
			WordNode top = queue.remove();
			String word = top.word;
			int currNumSteps = top.numSteps;

			if(word.equals(endWord)){
				if(top.numSteps<step){
					step = top.numSteps;
					res.clear();
					List<String> current = new ArrayList<>();
					while(top!=null){
						current.add(0,top.word);
						top = top.parent;
					}
					res.add(current);
				}else if(top.numSteps==step){
					step = top.numSteps;
					List<String> current = new ArrayList<>();
					while(top!=null){
						current.add(0,top.word);
						top = top.parent;
					}
					res.add(current);
				}
			}
			if(preNumSteps < currNumSteps){
				unvisited.removeAll(visited);
			}

			preNumSteps = currNumSteps;
			char[] arr = word.toCharArray();
			for(int i=0; i<arr.length; i++){
				for(char c='a'; c<='z'; c++){
					char temp = arr[i];
					if(arr[i]!=c){
						arr[i]=c;
					}

					String newWord = new String(arr);
					if(unvisited.contains(newWord)){
						queue.add(new WordNode(newWord, top.numSteps+1,top));
						visited.add(newWord);
					}

					arr[i]=temp;
				}
			}
		}
		return res;
	} 
}
