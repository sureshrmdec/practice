package com.practice.algo.and.ds.Trie;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Trie_Facebook_Dev {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie_Facebook_Dev o = new Trie_Facebook_Dev();

		
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
			if (ch == '.')
				continue;
			
			TrieNode child = current.children.get(ch);
			if (child != null) {
				current = child;
			} else {
				child = new TrieNode(ch);
				current.children.put(ch, child);
				current = child;
			}
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
			for(Character cc : node.children.keySet()){
				TrieNode child = node.children.get(cc);
				if(dfs(child,word,i+1))
					return true;
			}
			return false;
		}else{
			TrieNode child = node.children.get(c);
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
	Map<Character, TrieNode> children = new HashMap<>();
	boolean isEnd;

	public TrieNode(char content) {
		this.content = content;

	}

	@Override
	public String toString() {
		return "TrieNode [content=" + content + ", children=" + children + ", isEnd=" + isEnd + "]";
	}

}
