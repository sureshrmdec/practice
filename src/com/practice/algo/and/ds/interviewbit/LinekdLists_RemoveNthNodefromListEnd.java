package com.practice.algo.and.ds.interviewbit;


public class LinekdLists_RemoveNthNodefromListEnd<T> {
	
	public static void main(String[] args) {
		LinekdLists_RemoveNthNodefromListEnd<Integer> intList = new LinekdLists_RemoveNthNodefromListEnd<>();
		intList.insertFirst(5);
		intList.insertFirst(4);
		intList.insertFirst(3);
		intList.insertFirst(2);
		intList.insertFirst(1);
		
		System.out.println(intList.removeNthFromEnd(intList.head,5));
		
	}
	ListNode head;
	private int size;
	ListNode end;
	
	public void insertFirst(int val){
		if(head==null){
			head = new ListNode(val);
			end = head;
			size++;
			return;
		}
		ListNode newNode = new ListNode(val);
		newNode.next = head;
		head = newNode;
		size++;
	}
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        ListNode prev = null;
        int i = 0;
        while(first!=null ){
            first = first.next;
            if(i>=n){
                prev = second;
                second = second.next;
            }
            i++;
        }
        if(prev!=null)
        	prev.next = second.next;
        else{
        	return second.next;
        }
        return head;
    }
    
}	
class ListNode {
	   public int val;
	      public ListNode next;
	      ListNode(int x) { 
	    	  val = x; 
	    	  next = null; 
	    	 }
	  }