package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Trees_ShortestUniquePrefix {

	public static void main(String[] args) {
		Trees_ShortestUniquePrefix o = new Trees_ShortestUniquePrefix();
		ArrayList<String> words = new ArrayList<>();
		words.add("devk");
		words.add("deh");
		words.add("dkvn");
		words.add("bearcat");
		words.add("bert");
		words.add("zebra");
		words.add("dog");
		words.add("dove");
		words.add("duck");
		//words.add("duck");
		System.out.println(o.getPrefixes(words));
		System.out.println(o.search2("dv",0,0,o.root));
	}
	
	public ArrayList<String> getPrefixes(ArrayList<String> words){
		ArrayList<String> result = new ArrayList<>();
		
		for(String word:words){
			insert(word);
		}
		for(String word:words){
			result.add(getUniquePrefix(word));
		}
		return result;
	}
	public String getUniquePrefix(String word){
		TrieNode current = root;
		int increment = 1;
		int lastShared = increment;
		for(Character ch : word.toCharArray()){
			TrieNode child = current.children.get(ch);
			increment++;
			if(child.children.size()>1){
				lastShared = increment;
			}
			current = child;
			
		}
		return word.substring(0,lastShared);
	}
	
	TrieNode root = new TrieNode(' ');
	
	public void insert(String word){		
		TrieNode current = root;
		for(Character ch : word.toCharArray()){
			TrieNode child = current.children.get(ch);
			if(child==null){
				child = new TrieNode(ch);
				current.children.put(ch, child);
			}
			current = child;
		}
	}
	    public boolean search2(String word,int offset,int i,TrieNode current)
	    {
	        for (char ch : word.toCharArray() )
	        {
	            if (!current.children.containsKey(ch)){
	            	offset++;
	            	if(offset>1)
		                  return false;
	            	boolean gotThat = false;
	            	for(Character cnode : current.children.keySet()){
	            		TrieNode cc = current.children.get(cnode);
	            			gotThat = search2(word.substring(i),offset,i,cc);
	            	}
	            	if(gotThat){
	            		return true;
	            	}else{
	            		return false;
	            	}
	            }
	            else
	                current = current.children.get(ch);
	            i++;
	        }      
	        return true;
	    }
	
	
	public boolean search(String word){
		TrieNode current = root;
		for(Character ch : word.toCharArray()){
			TrieNode child = current.children.get(ch);
			if(child==null){
				return false;
			}
			current = child;
		}		
		return true;
	}
	
	class TrieNode{
		char content;
		Map<Character,TrieNode> children = new HashMap<>();
		public TrieNode(char content){
			this.content = content;
		}
		
	}

}
