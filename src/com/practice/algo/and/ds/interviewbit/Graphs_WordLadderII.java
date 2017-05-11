package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Graphs_WordLadderII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String beginWord = "hit";
		String endWord = "cog";
		ArrayList<String> wordDict = new ArrayList<String>();
		wordDict.add("hot");
		wordDict.add("dot");
		//wordDict.add("dog");
		wordDict.add("lot");
		//wordDict.add("log");
		wordDict.add("cot");
		Graphs_WordLadderII o = new Graphs_WordLadderII();
		
		System.out.println(o.findLadders2(beginWord, endWord, wordDict));
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

	//public List<List<String>> ladderLength(String beginWord, String endWord, Set<String> wordDict) {
	public ArrayList<ArrayList<String>> findLadders(String beginWord, String endWord, ArrayList<String> wordDict) {		
		ArrayList<ArrayList<String>> res = new ArrayList<>();
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
					ArrayList<String> current = new ArrayList<>();
					while(top!=null){
						current.add(0,top.word);
						top = top.parent;
					}
					res.add(current);
				}else if(top.numSteps==step){
					step = top.numSteps;
					ArrayList<String> current = new ArrayList<>();
					while(top!=null){
						current.add(0,top.word);
						top = top.parent;
					}
					res.add(current);
				}
			}
			//This check is about, when we get the element from the queue whose steps is greater than the previous elements then this means 
			// we can delete this previous element from unvisited
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
	
	
	//Dev Soln
	
	public ArrayList<ArrayList<String>> findLadders2(String beginWord, String endWord, ArrayList<String> wordList) {
		Set<String> dictSet = new HashSet<>(wordList);
		return findLadders(beginWord, endWord, dictSet);
	}

	public ArrayList<ArrayList<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
		ArrayList<ArrayList<String>> result = new ArrayList<>();
		Map<String, Node> visited = new HashMap<>();
		
		wordList.add(endWord);
		Queue<Node> Q = new LinkedList<>();
		Q.add(new Node(beginWord, 0, null));
		wordList.remove(beginWord);

		while (!Q.isEmpty()) {
			Node n = Q.poll();
			String currentWord = n.word;

			if (currentWord.equals(endWord)) {
				result.add(createList(n));
				continue;
			}

			ArrayList<Node> nextNodes = getNextNodes(visited, n, wordList);
			for (Node nextNode : nextNodes) {
				Q.add(nextNode);
			}
		}

		return result;
	}

	private ArrayList<Node> getNextNodes(Map<String, Node> visited, Node currentNode, Set<String> wordList) {
		ArrayList<Node> nextNodes = new ArrayList<>();
		
		String word = currentNode.word;
		for (int i = 0; i < word.length(); i++) {
			char[] charArr = word.toCharArray();
			for (char j = 'a'; j <= 'z'; j++) {
				charArr[i] = j;
				String s = new String(charArr);

				if (wordList.contains(s)){
					if(!visited.containsKey(s) || visited.get(s).step > currentNode.step){
						Node nextNode = new Node(s, currentNode.step + 1, currentNode);
						nextNodes.add(nextNode);
						visited.put(s, nextNode);
					}
				}
			}
		}

		return nextNodes;
	}
	
	private ArrayList<String> createList(Node node) {
		ArrayList<String> list = new ArrayList<>();

		while (node != null) {
			list.add(0, node.word);
			node = node.prev;
		}

		return list;
	}

	class Node {
		String word;
		int step;
		Node prev;

		public Node(String word, int count, Node prev) {
			super();
			this.word = word;
			this.step = count;
			this.prev = prev;
		}
	}
	
	
	
	
	
	
	
}
