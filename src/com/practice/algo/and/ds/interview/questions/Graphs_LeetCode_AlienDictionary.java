package com.practice.algo.and.ds.interview.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
//This is my soln
public class Graphs_LeetCode_AlienDictionary {

	public static void main(String[] args) {
		//String[] words = {"baa", "abcd", "abca", "cab", "cad"};
		//String[] words = {"wrt", "wrf", "er","ett","rftt"};
		String[] words = {"a","b","ca","cc"};
		Graphs_LeetCode_AlienDictionary o = new Graphs_LeetCode_AlienDictionary();
		System.out.println(o.alienOrder(words));		  
	}
	HashSet<Character> visited = new HashSet<>();//blackened
	HashSet<Character> onStack = new HashSet<>();//greyed //if its on stack then its on cycle
	public String alienOrder(String[] words) {
		Set<Character> allWords = new HashSet<Character>(); //For cases like {"zy","zx"};
		Map<Character,List<Character>> graph2 = new HashMap<>();
		StringBuilder result = new StringBuilder();
		buildGraph(words,graph2,allWords);
		Stack<Character> stack = new Stack<>();

		for(String word:words){
			for(Character c: word.toCharArray()){
				if(!visited.contains(c)){
					stack.push(c);
					if(!dfs(graph2, result, stack))
						return "";
				}	
			}
		}

		return result.reverse().toString();
	}
	private boolean dfs(Map<Character, List<Character>> graph2, StringBuilder result, Stack<Character> stack) {
		while(!stack.isEmpty()){
			Character top = stack.peek();
			Character next = getNextChildren(top,graph2);
			if(onStack.contains(next)){
				return false;
			}
			if(next!=null){
				stack.push(next);
				onStack.add(next); //grey
				//visited.add(next);
			}else{
				Character c = stack.pop();
				onStack.remove(c);
				visited.add(c); //blacked
				result.append(c);
			}
		}
		return true;
	}
	private Character getNextChildren(Character top,Map<Character,List<Character>> graph2) {
		if(graph2.get(top)==null)
			return null;
		for(Character c : graph2.get(top)){
			if(!visited.contains(c)){
				return c;
			}
		}

		return null;
	}
	private void buildGraph(String[] words,Map<Character,List<Character>> graph2,Set<Character> allWords) {
		// TODO Auto-generated method stub
		for(int i=1;i<words.length;i++){
			String a = words[i-1];
			String b = words[i];
			int l = Math.min(a.length(), b.length());
			for(int j=0;j<l;j++){

				if(a.charAt(j)!=b.charAt(j)){
					List<Character> neigbors = graph2.get(a.charAt(j));
					if(neigbors==null){
						neigbors = new LinkedList<>();
						graph2.put(a.charAt(j),neigbors);
					}	
					neigbors.add(b.charAt(j));

					break;
				}
			}
		}
	}
}
