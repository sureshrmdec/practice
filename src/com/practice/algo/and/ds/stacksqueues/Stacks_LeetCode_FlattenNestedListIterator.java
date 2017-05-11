package com.practice.algo.and.ds.stacksqueues;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;


public class Stacks_LeetCode_FlattenNestedListIterator implements Iterator<Integer> {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	Queue<Integer> queue;
	public Stacks_LeetCode_FlattenNestedListIterator(List<NestedInteger> nestedList) {
		queue = new LinkedList<Integer>();
		makeQueue(nestedList);
    }

    private void makeQueue(List<NestedInteger> nestedList) {
    	for(NestedInteger n:nestedList){
        	if(n.isInteger()){
        		queue.add(n.getInteger());
        	}else{
        		makeQueue(n.getList());
        	}
        }
	}

	@Override
    public Integer next() {
        if(hasNext()){
        	return queue.poll();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return queue.size()>0;
    }
    
    
    
    //Another Soln (LeetCode) using stack
    
    Stack<NestedInteger> stack = new Stack<>();
    //remove void (added for compile errors)
    public void NestedIterator(List<NestedInteger> nestedList) {
        for(int i = nestedList.size() - 1; i >= 0; i--) {
            stack.push(nestedList.get(i));
        }
    }

    
    public Integer next2() {
        return stack.pop().getInteger();
    }

    
    public boolean hasNext2() {
        while(!stack.isEmpty()) {
            NestedInteger curr = stack.peek();
            if(curr.isInteger()) {
                return true;
            }
            stack.pop();
            for(int i = curr.getList().size() - 1; i >= 0; i--) {
                stack.push(curr.getList().get(i));
            }
        }
        return false;
    }
}
interface NestedInteger {
	 
	      // @return true if this NestedInteger holds a single integer, rather than a nested list.
	      public boolean isInteger();
	 
	      // @return the single integer that this NestedInteger holds, if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	      public Integer getInteger();
	 
	      // @return the nested list that this NestedInteger holds, if it holds a nested list
	      // Return null if this NestedInteger holds a single integer
	      public List<NestedInteger> getList();
	  }