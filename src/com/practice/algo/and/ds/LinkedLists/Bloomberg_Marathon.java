package com.practice.algo.and.ds.LinkedLists;

import java.util.HashMap;
import java.util.Map;

public class Bloomberg_Marathon {

	public static void main(String[] args) {
		Bloomberg_Marathon o = new Bloomberg_Marathon();

		o.update(3, 1);
		o.update(4, 1);
		o.update(5, 1);

		o.update(3, 2);
		o.update(4, 2);
		o.update(5, 2);
		o.update(1, 1);
		o.update(2, 1);


		o.update(5, 3);
		o.update(3, 3);
		o.update(4, 3); 
		o.update(1, 2);
		o.update(2, 2);

		o.printTopNRunners(4);

	}

	Map<Integer, Node> referenceMap = new HashMap<>();
	Map<Integer,DoublyLinkedList> runnersByCheckPointMap = new HashMap<>();
	public void update(Integer runner_id,Integer checkpoint_id){

		if(!referenceMap.containsKey(runner_id)){
			Node newNode =  new Node(runner_id);
			referenceMap.put(runner_id, newNode);
			addInTreeMap(checkpoint_id, newNode);
		}else{
			Node ref = referenceMap.get(runner_id);
			runnersByCheckPointMap.get(checkpoint_id-1).remove(ref);
			addInTreeMap(checkpoint_id, ref);
		}
	}
	private void addInTreeMap(Integer checkpoint_id, Node newNode) {
		DoublyLinkedList list = runnersByCheckPointMap.get(checkpoint_id);
		if(list==null){
			list = new DoublyLinkedList();
			runnersByCheckPointMap.put(checkpoint_id, list);
		}
		list.addLast(newNode);
	}
	public void printTopNRunners(int n){
		for(int i =5;i>=1 && n>0;i--){
			DoublyLinkedList list = runnersByCheckPointMap.get(i);
			if(list!=null){
				Node head = list.head;
				while(head!=null && n>0){
					System.out.println(head.runner_id);
					head = head.next;
					n--;
				}
			}
		}
	}
	class Node{
		Node next;
		Node prev;
		int runner_id;
		Node(Integer runner_id){
			this.runner_id = runner_id;
		}
		Node(){}
	}
	class DoublyLinkedList{
		Node head;
		Node tail;
		public DoublyLinkedList(){}
		public void addLast(Node node){
			if(head==null){
				tail = node;
				head = tail;
			}else{
				tail.next = node;
				node.prev = tail;
				tail = node;
			}
		}
		public void remove(Node node){
			Node prev = node.prev;
			Node next = node.next;
			if(prev!=null){
				prev.next = next;
			}else{
				head = node.next;
			}
			if(next!=null){
				next.prev = prev;
			}else{
				tail = node.prev;
			}
			node.next=null;
			node.prev = null;
		}
	}
}
