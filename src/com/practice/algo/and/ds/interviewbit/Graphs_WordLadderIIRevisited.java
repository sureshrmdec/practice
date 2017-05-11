package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.practice.algo.and.ds.interviewbit.Graphs_WordLadderI.WordNode;

public class Graphs_WordLadderIIRevisited {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord = "hit";
		String endWord = "cog";
		ArrayList<String> wordDict = new ArrayList<String>();
		wordDict.add("hot");
		wordDict.add("dot");
		wordDict.add("dog");
		wordDict.add("lot");
		wordDict.add("log");
		Graphs_WordLadderIIRevisited o = new Graphs_WordLadderIIRevisited();

		System.out.println(o.findLadders2(beginWord, endWord, wordDict));
	}

	private ArrayList<ArrayList<String>> findLadders2(String beginWord, String endWord, ArrayList<String> wordDict) {
		
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		wordDict.add(endWord);
		Queue<Node> queue = new LinkedList<>();
		Node start = new Node(beginWord,new ArrayList<>(),1);
		queue.add(start);
		int shortest = Integer.MAX_VALUE;
		while(!queue.isEmpty()){
			Node top = queue.poll();

			String word = top.word;
			int currNumSteps = top.numSteps;

			if(currNumSteps>shortest)
				continue;

			if(word.equals(endWord)){
				shortest = top.numSteps;
				top.soFarWords.add(beginWord);
				result.add(top.soFarWords);
				continue;
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
						ArrayList<String> newW = new ArrayList<>();
						newW.addAll(top.soFarWords);
						newW.add(newWord);
						queue.add(new Node(newWord,newW ,top.numSteps+1));
						//wordDict.remove(newWord);
					}

					arr[i]=temp;
				}
			}

		}

		return result;
	}

	static class Node{
		String word;
		ArrayList<String> soFarWords;
		int numSteps;
		public Node(String word, ArrayList<String> soFarWords,int numSteps) {
			super();
			this.word = word;
			this.soFarWords = soFarWords;
			this.numSteps = numSteps;
		}

	}

}
