package com.practice.algo.and.ds.graph;

import java.util.HashSet;
import java.util.Stack;
//This is my soln
public class AlienDictionary {

	public static void main(String[] args) {
		//String[] words = {"baa", "abcd", "abca", "cab", "cad"};
		String[] words = {"aba", "bba", "aaa"};
		AlienDictionary o = new AlienDictionary();
		System.out.println(o.alienOrder(words));

	}
	HashSet<Character> visited = new HashSet<>();//blackened
	HashSet<Character> onStack = new HashSet<>();//greyed
	public String alienOrder(String[] words) {
		int[][] graph = new int[26][26];
		StringBuilder result = new StringBuilder();
		buildGraph(words,graph);

		Stack<Character> stack = new Stack<>();
		stack.push(words[0].charAt(0));
		
		onStack.add(words[0].charAt(0));
		while(!stack.isEmpty()){
			Character top = stack.peek();
			Character next = getNextChildren(top,graph);
			if(onStack.contains(next)){
				System.out.println("Cycle Detecetd");
				return "";
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
		return result.reverse().toString();
	}
	private Character getNextChildren(Character top,int[][] graph) {
		// TODO Auto-generated method stub
		for(int i=0;i<graph.length;i++){
			if(graph[top-'a'][i]==1){
				Character cc = (char) ('a'+i);
				if(!visited.contains(cc))
					return cc;
			}
		}
		return null;
	}
	private void buildGraph(String[] words,int[][] graph) {
		// TODO Auto-generated method stub
		for(int i=1;i<words.length;i++){
			String a = words[i-1];
			String b = words[i];
			int l = Math.min(a.length(), b.length());
			for(int j=0;j<l;j++){
				if(a.charAt(j)!=b.charAt(j)){
					graph[a.charAt(j)-'a'][b.charAt(j)-'a'] = 1;
					break;
				}
			}
		}
	}
}
