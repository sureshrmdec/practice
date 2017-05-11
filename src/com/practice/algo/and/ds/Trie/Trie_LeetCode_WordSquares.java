package com.practice.algo.and.ds.Trie;

import java.util.ArrayList;
import java.util.List;

//https://discuss.leetcode.com/topic/63516/explained-my-java-solution-using-trie-126ms-16-16/2
public class Trie_LeetCode_WordSquares {

	public static void main(String[] args) {
		String[] words = {"area","lead","wall","lady","ball"};
		Trie_LeetCode_WordSquares o = new Trie_LeetCode_WordSquares();
		System.out.println(o.wordSquares(words));
	}
	
    public List<List<String>> wordSquares(String[] words) {
    	List<List<String>> result = new ArrayList<>();
    	TrieNode root = buildTrie(words);
    	List<String> content = new ArrayList<>();
    	for (String w : words) {
    		content.add(w);
            search(words[0].length(),root, result, content);
            content.remove(content.size() - 1);
        }
    	
    	return result;
    }

	private void search(int len,TrieNode root,List<List<String>> result ,List<String> content ) {
		
		if(content.size()==len){
			result.add(new ArrayList<>(content));
			return;
		}
		int idx = content.size();
        StringBuilder prefixBuilder = new StringBuilder();
        for (String s : content)
            prefixBuilder.append(s.charAt(idx));
        List<String> startWith = findByPrefix(prefixBuilder.toString(),root);
        for (String sw : startWith) {
        	content.add(sw);
            search(len, root, result, content);
            content.remove(content.size() - 1);
        }
	}

	List<String> findByPrefix(String prefix,TrieNode root) {
        List<String> ans = new ArrayList<>();
        TrieNode cur = root;
        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (cur.next[idx] == null)
                return ans;

            cur = cur.next[idx];
        }
        ans.addAll(cur.startWith);
        return ans;
    }

	private TrieNode buildTrie(String[] words) {
		TrieNode root = new TrieNode();
		for(String s:words){
			char[] cArr = s.toCharArray();
			TrieNode current = root;
			for(char c : cArr){
				TrieNode newNode = new TrieNode();
				if(current.next[c-'a']==null){
					current.next[c-'a'] = newNode;	
				}
				current.next[c-'a'].startWith.add(s);
				current = current.next[c-'a'];
			}
		}
		return root;
	}
	
	class TrieNode{
		List<String> startWith;
		TrieNode[] next;
		TrieNode() {
            startWith = new ArrayList<>();
            next = new TrieNode[26];
        }
		
	}
}