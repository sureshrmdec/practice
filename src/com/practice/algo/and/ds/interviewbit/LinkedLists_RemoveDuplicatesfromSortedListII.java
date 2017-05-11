package com.practice.algo.and.ds.interviewbit;


public class LinkedLists_RemoveDuplicatesfromSortedListII {

/*	Given dummy->1->2->3->3->4->4->5, return 1->2->5.
	Given dummy->1->1->1->2->3, return 2->3.
*/	
	public static void main(String[] args) {
		

	}
	//Program Creek
	public ListNode deleteDuplicatesProgramCreek(ListNode head) {
	    ListNode t = new ListNode(0);
	    t.next = head;
	 
	    ListNode p = t;
	    while(p.next!=null&&p.next.next!=null){
	        if(p.next.val == p.next.next.val){
	            int dup = p.next.val;
	            while(p.next!=null&&p.next.val==dup){
	                p.next = p.next.next;
	            }
	        }else{
	            p=p.next;
	        }
	 
	    }
	 
	    return t.next;
	}
	
	public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode FakeHead=new ListNode(0);
        FakeHead.next=head;
        ListNode pre=FakeHead;
        ListNode cur=head;
        while(cur!=null){
            while(cur.next!=null&&cur.val==cur.next.val){
                cur=cur.next;
            }
            if(pre.next==cur){
                pre=pre.next;
            }
            else{
                pre.next=cur.next;
            }
            cur=cur.next;
        }
        return FakeHead.next;
    }
	
	static class ListNode {
		   public int val;
		      public ListNode next;
		      ListNode(int x) { 
		    	  val = x; 
		    	  next = null; 
		    	 }
		  }
}
