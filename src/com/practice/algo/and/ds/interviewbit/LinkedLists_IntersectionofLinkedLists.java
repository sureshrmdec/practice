package com.practice.algo.and.ds.interviewbit;

import java.util.HashSet;
import java.util.Set;

import com.practice.algo.and.ds.interviewbit.LinkedLists_PalindromeList.ListNode;

public class LinkedLists_IntersectionofLinkedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public ListNode getIntersectionNode(ListNode a, ListNode b) {
	
		int sizeA=0;
		
		ListNode aa = a;
		//calculate Size
		while(aa!=null){
			sizeA++;
			aa = aa.next;
			
		}
		
		int sizeB=0;
		
		ListNode bb = b;
		//calculate Size
		while(bb!=null){
			sizeB++;
			bb = bb.next;
			
		}
		if(sizeA>sizeB){
			for(int i=0;i<(sizeA-sizeB);i++){
				a = a.next;
			}
		}else if(sizeB>sizeA){
			for(int i=0;i<(sizeB-sizeA);i++){
				b = b.next;
			}
		}
		
		Set<ListNode> set = new HashSet<>();
		while(a!=null || b!=null){
			set.add(a);
			a = a.next;
			if(set.contains(b)){
				return b;
			}
			b=b.next;
		}
		
		return null;
	}
	class ListNode {
		   public int val;
		      public ListNode next;
		      ListNode(int x) { 
		    	  val = x; 
		    	  next = null; 
		    	 }
		  }

}
