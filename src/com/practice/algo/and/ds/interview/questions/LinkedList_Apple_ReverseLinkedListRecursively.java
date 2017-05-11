package com.practice.algo.and.ds.interview.questions;


public class LinkedList_Apple_ReverseLinkedListRecursively {

	public static void main(String[] args) {
		ListNode a = new ListNode(0);
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		
		a.next = a1;
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		LinkedList_Apple_ReverseLinkedListRecursively o = new LinkedList_Apple_ReverseLinkedListRecursively();
		Dog myDog = new Dog("Rover");
		o.foo(myDog);
		System.out.println(myDog.name);
		
		o.reverse(a);
	}

	public void swap(Dog one,Dog two){
		//one.
		
	}
	public void foo(Dog someDog) {
	    someDog.setName("Max");     // AAA
	    someDog = new Dog("Fifi");  // BBB
	    someDog.setName("Rowlf");   // CCC
	}
	
	private ListNode reverse(ListNode a) {
		
		return null;
	}
	static class Dog{
		
		public Dog(String name) {
			super();
			this.name = name;
		}

		String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
	}

}
