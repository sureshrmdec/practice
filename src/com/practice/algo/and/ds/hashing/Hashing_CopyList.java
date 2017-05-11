package com.practice.algo.and.ds.hashing;

import java.util.HashMap;

public class Hashing_CopyList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomListNode one = new RandomListNode(1);
		RandomListNode two = new RandomListNode(2);
		RandomListNode three = new RandomListNode(3);
		one.next = two;
		one.random = three;
		two.next = three;
		two.random = one;
		three.next = null;
		three.random = one;
		Hashing_CopyList o = new Hashing_CopyList();
		o.copyRandomList(one);

	}

	public RandomListNode copyRandomList(RandomListNode head) {
		HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
		RandomListNode orignal = head;
		RandomListNode newHead = null;

		while(orignal!=null){
			int label = orignal.label;
			RandomListNode node = null;
			if(newHead==null){
				node = new RandomListNode(label);
				newHead = node;
				map.put(orignal, node);
			}
			if(!map.containsKey(orignal)){
				node = new RandomListNode(label);
				map.put(orignal, node);	 
			}else{
				node = map.get(orignal);
			}

			//next
			if(orignal.next!=null){
				RandomListNode next = new RandomListNode(orignal.next.label);

				if(map.containsKey(orignal.next)){
					RandomListNode nextAlready = map.get(orignal.next);
					node.next = nextAlready;	 
				}else{
					map.put(orignal.next, next);
					node.next = next;	 
				}
			}

			//random
			if(orignal.random!=null){
				RandomListNode random = new RandomListNode(orignal.random.label);
				if(map.containsKey(orignal.random)){
					RandomListNode randomAlready = map.get(orignal.random);
					node.random = randomAlready;	 
				}else{
					map.put(orignal.random, random);
					node.random = random;	 
				}
			}

			orignal = orignal.next;

		}


		return newHead;

	}

}
class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
}
