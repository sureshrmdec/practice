package com.practice.algo.and.ds.Trie;

public class Trie_LeetCode_MaximumXORofTwoNumbersInArray {

	public static void main(String[] args) {
		int[] nums = {3, 10, 5, 25, 2, 8};
		Trie_LeetCode_MaximumXORofTwoNumbersInArray o = new Trie_LeetCode_MaximumXORofTwoNumbersInArray();
		System.out.println(o.findMaximumXOR(nums));

	}
	TrieNode root = new TrieNode();
    public int findMaximumXOR(int[] nums) {
    	for(int num:nums){
    		 TrieNode curNode = root;
             for(int i = 31; i >= 0; i --) {
            	 System.out.println((num >>> i));
                 int curBit = (num >>> i) & 1;
                 if(curNode.children[curBit] == null) {
                     curNode.children[curBit] = new TrieNode();
                 }
                 curNode = curNode.children[curBit];
             }
    	}
    	int result = 0;
    	
    	 for(int num: nums) {
             TrieNode curNode = root;
             int curSum = 0;
             for(int i = 31; i >= 0; i --) {
                 int curBit = (num >>> i) & 1;
                 if(curNode.children[curBit ^ 1] != null) { //if currBit is 1 then check 0 or vice versa
                     curSum += (1 << i);
                     curNode = curNode.children[curBit ^ 1];
                 }else {
                     curNode = curNode.children[curBit];
                 }
             }
             result = Math.max(result, curSum);
         }

    	return result;
    }
    
    
    //My attempt below...100% right...but just not optimized in a way i was inserting a string..  
    private int searchTrie(String str,int n) {
    	char[] cA = str.toCharArray();
    	TrieNode current = root;
    	int xor = 0;
		for(int i=0;i<cA.length;i++){
			char c = cA[i];
			if(c=='0'){
				if(current.children[1]!=null){
					xor+=Math.pow(2, n-1);
					current = current.children[1];
				}else
					current = current.children[0];
			}else if(c=='1'){
				if(current.children[0]!=null){
					xor+=Math.pow(2, n-1);
					current = current.children[0];
				}else
					current = current.children[1];
			}
			
			n--;
		}
 		return xor;
	}
	
	private void insertInTrie(String str) {
		char[] cA = str.toCharArray();
		TrieNode current = root;
		for(int i=0;i<cA.length;i++){
			char c = cA[i];
			if(current.children[c-'0']==null){
				current.children[c-'0'] = new TrieNode();
			}
			current = current.children[c-'0']; 
		}
		
	}

	
	static class TrieNode{
		char ch;
		TrieNode[] children = new TrieNode[2];
	}
}
