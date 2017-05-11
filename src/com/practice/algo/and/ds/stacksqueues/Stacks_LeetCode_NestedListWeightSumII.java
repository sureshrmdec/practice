package com.practice.algo.and.ds.stacksqueues;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/** 
 * Given a nested list of integers, returns the sum of all integers in the list weighted by their REVERSED depth. 
 * For example, given the list {{1,1},2,{1,1}} the deepest level is 2. Thus the function should return 8 (four 1's with weight 1, one 2 with weight 2) 
 * Given the list {1,{4,{6}}} the function should return 17 (one 1 with weight 3, one 4 with weight 2, and one 6 with weight 1)


 */


public class Stacks_LeetCode_NestedListWeightSumII {

	public static void main(String[] args) {
		NestedInteger n1 = new NestedInteger() {
			int a = 1;
			@Override
			public boolean isInteger() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public List<NestedInteger> getList() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Integer getInteger() {
				// TODO Auto-generated method stub
				return a;
			}
		};

		NestedInteger n2 = new NestedInteger() {
			int a = 4;
			@Override
			public boolean isInteger() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public List<NestedInteger> getList() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Integer getInteger() {
				// TODO Auto-generated method stub
				return a;
			}
		};
		NestedInteger n3 = new NestedInteger() {
			int a = 6;
			@Override
			public boolean isInteger() {
				// TODO Auto-generated method stub
				return true;
			}

			@Override
			public List<NestedInteger> getList() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Integer getInteger() {
				// TODO Auto-generated method stub
				return a;
			}
		};
		NestedInteger n3L = new NestedInteger() {
			List<NestedInteger> list = new ArrayList<>();
			@Override
			public boolean isInteger() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<NestedInteger> getList() {
				// TODO Auto-generated method stub
				return list;
			}

			@Override
			public Integer getInteger() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		n3L.getList().add(n3);


		NestedInteger n4L = new NestedInteger() {
			List<NestedInteger> list = new ArrayList<>();
			@Override
			public boolean isInteger() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<NestedInteger> getList() {
				// TODO Auto-generated method stub
				return list;
			}

			@Override
			public Integer getInteger() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		n4L.getList().add(n3L);
		n4L.getList().add(n2);

		NestedInteger n1L = new NestedInteger() {
			List<NestedInteger> list = new ArrayList<>();
			@Override
			public boolean isInteger() {
				// TODO Auto-generated method stub
				return false;
			}

			@Override
			public List<NestedInteger> getList() {
				// TODO Auto-generated method stub
				return list;
			}

			@Override
			public Integer getInteger() {
				// TODO Auto-generated method stub
				return null;
			}
		};
		n1L.getList().add(n4L);
		n1L.getList().add(n1);


		List<NestedInteger> list = new ArrayList<>();
		list.add(n1L);

		Stacks_LeetCode_NestedListWeightSumII o = new Stacks_LeetCode_NestedListWeightSumII();
		System.out.println(o.depthSumInverse(n1L.getList()));
		//System.out.println(o.depthSumInverseMy(n1L.getList()));

	}
	
	
	public int depthSumInverse(List<NestedInteger> nestedList) {
        return helper(nestedList, 0);
    }
    
    private int helper(List<NestedInteger> niList, int prev) {
        int intSum = prev;
        List<NestedInteger> levelBreak = new ArrayList<>();
        
        for (NestedInteger ni : niList) {
            if (ni.isInteger()) {
                intSum += ni.getInteger();
            } else {
                levelBreak.addAll(ni.getList());
            }
        }
        
        int listSum = levelBreak.isEmpty()? 0 : helper(levelBreak, intSum);

        return listSum + intSum;
    }
	
	
	
	
	
	
	
	
	/* My Soln*/
	int res = 0;
	public int depthSumInverseMy (List<NestedInteger> input)
	{
		depthSumInverseMyHelper(input);
		return res;
	}
	public int depthSumInverseMyHelper (List<NestedInteger> input)
	{
		
		int level = 1;
		Stack<NestedInteger>  stack = new Stack<>();
		List<NestedInteger> inputL = new ArrayList<>();
		for(NestedInteger n:input){
			if(n.isInteger()){
				stack.push(n);
			}else{
				inputL.addAll(n.getList());
			}
		}
		if(inputL.size()>0)
			level=depthSumInverseMyHelper(inputL)+1;
		while(!stack.isEmpty()){
			res+= (stack.pop().getInteger()*level);
		}
		return level;
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
}
