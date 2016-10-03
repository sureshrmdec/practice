package com.practice.algo.and.ds.interviewbit;



public class LinkedLists_BasicImplementation<T> {

	Node<T> head;
	private int size;
	Node<T> end;
	
	public void insertFirst(T val){
		if(head==null){
			head = new Node<T>(val);
			end = head;
			size++;
			return;
		}
		Node<T> newNode = new Node<T>(val);
		head.previous = newNode;
		newNode.next = head;
		head = newNode;
		size++;
	}
	
	public void insertLast(T val){
		if(end == null){
			end = new Node<T>(val);
			head = end;
			size++;
			return;
		}
		Node<T> newNode = new Node<T>(val);
		end.next = newNode;
		newNode.previous = end;
		end = newNode;
		size++;
		
	}
	
	public Node<T> deleteNth(int N){
            Node<T> x = head;
            for (int i = 0; i < N; i++)
                x = x.next;
            if(x.previous!=null)
            	x.previous.next = x.next;
            else{
            	Node<T> temp = head;
    			head = temp.next;
    			head.previous = null;
    			x = temp;
            }
            if(x.next!=null)
            	x.next.previous = x.previous;
            else{
            	Node<T> temp = end;
    			end = temp.previous;
    			end.next = null;
    			x = temp;
            }
            size--;
            return x;
 
	}
	
	public static void main(String[] args) {
		LinkedLists_BasicImplementation<Integer> intList = new LinkedLists_BasicImplementation<>();
		intList.insertFirst(4);
		intList.insertFirst(5);
		intList.insertFirst(6);
		intList.insertLast(7);
		intList.printLinkedList();
		intList.deleteNth(0);
		intList.deleteNth(intList.size-1);
		System.out.println();
		System.out.println(intList.getIndex(2));
		intList.printLinkedList();
	}
	
	public T getIndex(int index){
		 if (index < (size >> 1)) {
	            Node<T> x = head;
	            for (int i = 0; i < index; i++)
	                x = x.next;
	            return x.val;
	        } else {
	            Node<T> x = end;
	            for (int i = size - 1; i > index; i--)
	                x = x.previous;
	            return x.val;
	        }
		
	}
	
	public int getSize(){
		return size;
	}
	
	public void printLinkedList(){
		Node<T> temp = head;
		while(temp!=null){
			System.out.print(temp.val+"--->");
			temp=temp.next;
		}
		System.out.print("null");
	}
}
