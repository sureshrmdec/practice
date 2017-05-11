package com.practice.algo.and.ds.Tree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

public class Trees_VerticalOrderTraversalofBT {

	public static void main(String[] args) {
		TreeNode one = new TreeNode(1);
		TreeNode two = new TreeNode(2);
		TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;
        three.left = six;
        three.right = seven;
        Trees_VerticalOrderTraversalofBT o = new Trees_VerticalOrderTraversalofBT();
        System.out.println(o.verticalOrderTraversal(one));

	}

	public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode root){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<Integer,ArrayList<Integer>>();
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Queue<Integer> values = new LinkedList<Integer>();
		queue.offer(root);
		values.offer(0);
		
		
		
		
		while(!queue.isEmpty()){
			TreeNode top = queue.poll();
			Integer dist = values.poll();
			if(map.containsKey(dist)){
				map.get(dist).add(top.val);				
			}else{
				ArrayList<Integer> list = new ArrayList<>();
				list.add(top.val);
				map.put(dist, list);
			}
			
			if(top.left!=null){
				queue.offer(top.left);
				values.offer(dist-1);
			}
			if(top.right!=null){
				queue.offer(top.right);
				values.offer(dist+1);
			}
		}
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			result.add(map.get(it.next()));
		}
		return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	//This is right but it wont give you correct order
	//For example refer http://www.geeksforgeeks.org/print-a-binary-tree-in-vertical-order-set-3-using-level-order-traversal/
	public ArrayList<ArrayList<Integer>> verticalOrderTraversal2(TreeNode root){
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		TreeMap<Integer,ArrayList<Integer>> map = new TreeMap<Integer,ArrayList<Integer>>();
		helper(root,map,result,0);
		Set<Integer> set = map.keySet();
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()){
			result.add(map.get(it.next()));
		}
		return result;
	}
	
	private void helper(TreeNode root, Map<Integer, ArrayList<Integer>> map, ArrayList<ArrayList<Integer>> result,int sum) {
		if(root==null)
			return;
		if(map.containsKey(sum)){
			map.get(sum).add(root.val);
		}else{
			ArrayList<Integer> list = new ArrayList<>();
			list.add(root.val);
			map.put(sum, list);
		}
		helper(root.left, map, result, sum-1);
		helper(root.right, map, result, sum+1);
		
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
