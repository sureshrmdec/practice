package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;


public class Graphs_WordLadderIISecondAttempt {

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
		Graphs_WordLadderIISecondAttempt o = new Graphs_WordLadderIISecondAttempt();

		System.out.println(o.ladderLength(beginWord, endWord, wordDict));
	}
	public List<List<String>> ladderLength(String beginWord, String endWord, Set<String> wordDict) {
		List<List<String>> result = new  ArrayList<>();
		wordDict.add(endWord);
		LinkedList<WordNode> queue = new LinkedList<WordNode>();
		List<String> path = new ArrayList<>();
		path.add(beginWord);
		WordNode node = new WordNode(beginWord, 1,path);
		queue.add(node);

		int shortestPath = Integer.MAX_VALUE;
		while(!queue.isEmpty()){
			WordNode current = queue.poll();
			String word = current.word;
			if(current.path.size()>shortestPath)
				continue;
			if(word.equals(endWord)){
				if(current.path.size()<=shortestPath){
					result.add(current.path);
					System.out.println(current.path);
					shortestPath = current.path.size();
				}
			}
			char[] arr = word.toCharArray();
			for(int i=0; i<arr.length; i++){
				for(char c='a'; c<='z'; c++){
					char temp = arr[i];
					if(arr[i]!=c){
						arr[i]=c;
					}

					String newWord = new String(arr);
					if(wordDict.contains(newWord) && !current.path.contains(newWord)){
						List<String> appendPath = new ArrayList<>();
						appendPath.addAll(current.path);
						appendPath.add(newWord);
						queue.add(new WordNode(newWord, current.numSteps+1,appendPath));
					}

					arr[i]=temp;
				}
			}
		}
		return result;

	}
	class WordNode{
		String word;
		int numSteps;
		List<String> path = new ArrayList<>();
		public WordNode(String word, int numSteps,List<String> path){
			this.word = word;
			this.numSteps = numSteps;
			this.path = path;
		}

	}

}
