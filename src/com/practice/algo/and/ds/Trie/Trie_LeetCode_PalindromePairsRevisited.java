package com.practice.algo.and.ds.Trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

//Image attached Trie_LeetCode_PalindromePairsRevisited.jpeg
public class Trie_LeetCode_PalindromePairsRevisited {

	public static void main(String[] args) {
		String[] words1 = {"abcd", "dcba", "lls", "s", "sssll"};
		String[] words2 = {"a",""};
		String[] words3 = {"a","abc","aba",""};
		Trie_LeetCode_PalindromePairsRevisited o = new Trie_LeetCode_PalindromePairsRevisited();
		System.out.println(o.palindromePairs(words1));
		System.out.println(o.palindromePairs(words2));
		System.out.println(o.palindromePairs(words3));

	}

	TrieNode root = null;
	public List<List<Integer>> palindromePairs(String[] words) {
		root = new TrieNode(' ');
		List<List<Integer>> result = new ArrayList<>();
		for(int i=0;i<words.length;i++){
			insert(words[i],i);
		}
		for(int i=0;i<words.length;i++){

			search(words[i],i,result);
		}
		return result;
	}

	private void search(String word,int i,List<List<Integer>> result) {
		TrieNode current = root;

		for(int j =0;j<word.length();j++){
			char c = word.charAt(j);

			if(current.isEnd && current.index!=i && isPalindrome(word, j, word.length() - 1)){ //If current is end,i.e some word ends here at current and remaining substring of word is palindrome then it is palindrome
				result.add(Arrays.asList(i, current.index));
			}

			if(current.children.containsKey(c)){
				current = current.children.get(c);
			}else{
				return;
			}
		}
		for(int j : current.indexesMakingPalindromeBelow){  //If you consume all the char of current word, then the node it ends up in..check if below that node it makes palindrome.This you can find in indexesMakingPalindromeBelow list of the node.So together they makes a palindrome.
			if(i != j)
				result.add(Arrays.asList(i, j));
		}
	}
	private void insert(String string, int i) {
		TrieNode current = root;
		for(int j =string.length()-1;j>=0;j--){
			TrieNode child = null;
			char c = string.charAt(j);
			if(current.children.get(c)==null){
				child = new TrieNode(c);
				current.children.put(c, child);
			}
			if(isPalindrome(string, 0, j)){
				current.indexesMakingPalindromeBelow.add(i);
			}
			current = current.children.get(c);
		}
		current.indexesMakingPalindromeBelow.add(i); //This is added because when last char is consumed, string becomes of length 0, so its palindrome.
		current.isEnd = true;
		current.index = i;
	}

	private boolean isPalindrome(String word, int i, int j) {
		while (i < j) {
			if (word.charAt(i++) != word.charAt(j--)) return false;
		}
		return true;
	}

	static class TrieNode{
		char content;
		Map<Character,TrieNode> children = new HashMap<>();
		List<Integer> indexesMakingPalindromeBelow = new ArrayList<>();
		boolean isEnd;
		public TrieNode(char content){
			this.content = content;
		}
		int index;
	}

}
