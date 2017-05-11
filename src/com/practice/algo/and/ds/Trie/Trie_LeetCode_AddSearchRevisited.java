package com.practice.algo.and.ds.Trie;

//Complexity O(26^n)...need to confirm..

public class Trie_LeetCode_AddSearchRevisited {

	public static void main(String[] args) {
		Trie_LeetCode_AddSearchRevisited o = new Trie_LeetCode_AddSearchRevisited();


		o.addWord("a");
		o.addWord("ab");
		o.addWord("bad");
		o.addWord("dad");
		o.addWord("mad");
		System.out.println(o.search("a"));
		System.out.println(o.search("ab"));
		System.out.println(o.search("pad"));
		System.out.println(o.search("bad"));
		System.out.println(o.search(".ad"));
		System.out.println(o.search("b.."));
		//true
		System.out.println(o.search("foo")); //true
		System.out.println(o.search("foc"));  //false
		System.out.println(o.search("fo")); //false
		System.out.println(o.search("b.r"));  //true
		System.out.println(o.search("ba."));  //true
		System.out.println(o.search(".ax"));  //true

	}

	TrieNode root = null;
	/** Initialize your data structure here. */
	public Trie_LeetCode_AddSearchRevisited() {
		root = new TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		char[] cArray = word.toCharArray();
		TrieNode current = root;
		for(char c : cArray){
			TrieNode node = new TrieNode();
			if(current.next[c-'a']==null){
				current.next[c-'a'] = node;
			}
			current = current.next[c-'a'];
		}
		current.isEnd = true;
	}

	/** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
	public boolean search(String word) {
		return dfs(word,root,0);
	}

	private boolean dfs(String word, TrieNode node,int index) {
		if(node.isEnd && index==word.length())
			return true;
		if(!node.isEnd && index==word.length())
			return false;
		char c = word.charAt(index);
		if(c=='.'){
			for(TrieNode n:node.next){
				if(n!=null){
					if(dfs(word,n,index+1))
						return true;
				}
			}

		}else{
			if(node.next[c-'a']!=null){
				node = node.next[c-'a'];
				if(dfs(word,node,index+1))
					return true;
			}else{
				return false;
			}

		}
		return false;
	}

	class TrieNode{
		boolean isEnd;
		TrieNode[] next = new TrieNode[26];
	}
}
