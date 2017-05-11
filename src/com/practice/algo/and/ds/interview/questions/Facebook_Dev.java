package com.practice.algo.and.ds.interview.questions;

import java.util.HashMap;
import java.util.Map;
//https://leetcode.com/problems/add-and-search-word-data-structure-design/?tab=Description

public class Facebook_Dev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Facebook_Dev o = new Facebook_Dev();

		
		o.insert("a");
		o.insert("ab");
		o.insert("bad");
		o.insert("dad");
		o.insert("mad");
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

	TrieNode root = new TrieNode(' ');

	public void insert(String word) {
		// if (search(word) == true)
		// return;
		TrieNode current = root;
		for (char ch : word.toCharArray()) {
			TrieNode child = current.children[ch-'a'];
			if (child == null) {
				child = new TrieNode(ch);
				current.children[ch-'a']= child;
			}
			current = child;
		}
		current.isEnd = true;
	}

	public boolean search(String word) {
		
		return dfs(root,word,0);
	}
	public boolean dfs(TrieNode node,String word,int i){
		if(i==word.length() && node.isEnd==true)
			return true;
		if(i==word.length() && node.isEnd==false)
			return false;

		char c = word.charAt(i);
		if(c=='.'){
			for(int cc=0;cc<node.children.length;cc++){
				if(node.children[cc]!=null){
					TrieNode child = node.children[cc];
					if(dfs(child,word,i+1))
						return true;
				}
			}			
			return false;
		}else{
			TrieNode child = node.children[c-'a'];
			if(child==null){
				return false;
			}
			 if(!dfs(child,word,i+1))
				 return false;
		}
		return true;
		
	}


}

class TrieNode {
	char content;
	//Map<Character, TrieNode> children = new HashMap<>();
	boolean isEnd;
	public TrieNode[] children = new TrieNode[26];

	public TrieNode(char content) {
		this.content = content;

	}

	@Override
	public String toString() {
		return "TrieNode [content=" + content + ", children=" + children + ", isEnd=" + isEnd + "]";
	}

}
