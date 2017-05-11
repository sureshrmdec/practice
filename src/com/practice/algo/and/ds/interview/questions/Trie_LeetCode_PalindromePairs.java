package com.practice.algo.and.ds.interview.questions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Trie_LeetCode_PalindromePairs {

	public static void main(String[] args) {
		//String[] words = {"abcd", "dcba", "lls", "s", "sssll"};
		String[] words = {"aba","ba","a","caba"};
		Trie_LeetCode_PalindromePairs o = new Trie_LeetCode_PalindromePairs();
		System.out.println(o.palindromePairs(words));
	}



	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();

		TrieNode root = new TrieNode();
		for (int i = 0; i < words.length; i++){ 
			addWord(root, words[i], i);
		}
		for (int i = 0; i < words.length; i++){ 
			search(words, i, root, res);
		}

		return res;
	}

	private void addWord(TrieNode root, String word, int index) {
		for (int i = word.length() - 1; i >= 0; i--) {
			int j = word.charAt(i) - 'a';
			if (root.next[j] == null){
				TrieNode child = new TrieNode(); 
				root.next[j] = child;
			}
			if (isPalindrome(word, 0, i)){ 
				root.list.add(index);
			}
			root = root.next[j];
		}

		root.list.add(index);
		root.index = index;
	}

	private void search(String[] words, int i, TrieNode root, List<List<Integer>> res) {
		for (int j = 0; j < words[i].length(); j++) {	
			if (root.index >= 0 && root.index != i && isPalindrome(words[i], j, words[i].length() - 1)) {
				res.add(Arrays.asList(i, root.index));
			}

			root = root.next[words[i].charAt(j) - 'a'];
			if (root == null) 
				return;
		}

		for (int j : root.list) {
			if (i == j) continue;
			res.add(Arrays.asList(i, j));
		}
	}

	/*	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> result = new ArrayList<>();
		for(int i=0;i<words.length;i++){
			String word = words[i];
			insert(word,i,true);
			//insert(reverse(word),i,false);
		}
		for(int i=0;i<words.length;i++){
			String word = reverse(words[i]);
			TrieNode existing = search(word,root,0);

		}
		return result;
	}*/

	private String reverse(String word) {
		// TODO Auto-generated method stub
		int i=0;
		int j = word.length()-1;
		char[] wordArr = word.toCharArray();
		while(i<j){
			char ci = wordArr[i];
			wordArr[i] = wordArr[j];
			wordArr[j] = ci;
			i++;
			j--;
		}
		return new String(wordArr);
	}
	/*TrieNode root = new TrieNode(' ');x
	private TrieNode insert(String word,int index,boolean forward) {
		//		TrieNode existing = search(word,root,0);
		//		if(existing!=null)
		//			return existing;
		TrieNode current = root;
		for(int i=0;i<word.length();i++){
			char c = word.charAt(i); 
			TrieNode child = current.children[c-'a']; 
			if(child==null){
				child = new TrieNode(c);
				current.children[c-'a'] = child;
				child.str = word.substring(i+1);
				child.index = index;
			}
			current = child;
		}
		current.isEnd = true;
		return null;
	}
	//-1 not exists
	private TrieNode search(String word,TrieNode node,int i) {

		if(i>=word.length()){
			for(int k=0;k<node.children.length;k++){
				if(node.children[k]!=null){
					if(isPalindrome(node.children[k].str)){
						return node;
					}
				}
			}
		}

		char c = word.charAt(i);
		if(node.children[c-'a']!=null){
			return search(word, node.children[c-'a'], i+1);
		}else{
			return null;
		}
	}*/

	private boolean isPalindrome(String word, int i, int j) {
		while (i < j) {
			if (word.charAt(i++) != word.charAt(j--)) return false;
		}

		return true;
	}

	private boolean isPalindrome(String s){
		if(s==null || s.isEmpty())
			return true;
		int i=0;
		int j = s.length()-1;
		while(i<j){
			if(s.charAt(i)!=s.charAt(j))
				return false;
			i++;
			j--;
		}
		return true;
	}
	class TrieNode {
		TrieNode[] next;
		int index;
		List<Integer> list;

		TrieNode() {
			next = new TrieNode[26];
			index = -1;
			list = new ArrayList<>();
		}
	}
}
