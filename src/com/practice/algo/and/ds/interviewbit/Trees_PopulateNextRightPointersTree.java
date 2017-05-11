package com.practice.algo.and.ds.interviewbit;

public class Trees_PopulateNextRightPointersTree {

	public static void main(String[] args) {
		TreeLinkNode one = new TreeLinkNode(1);
        TreeLinkNode two = new TreeLinkNode(2);
        TreeLinkNode three = new TreeLinkNode(3);
        TreeLinkNode four = new TreeLinkNode(4);
        TreeLinkNode five = new TreeLinkNode(5);

        one.left = two;
        one.right = three;

        two.left = four;
        three.right = five;
        Trees_PopulateNextRightPointersTree o = new Trees_PopulateNextRightPointersTree();
        o.connect(one);

	}
	public void connect(TreeLinkNode root) {

		
		helper(root,root.next);
		
		
		
	}
	private void helper(TreeLinkNode root, TreeLinkNode next) {
		
		if(root==null)
			return ;
		if(root.left!=null && root.right!=null){
			root.left.next = root.right;
			//nextt = root.right;
		}
		
		if(root.next==null){
		  while(next!=null){
			if(next.left!=null){
				root.next = next.left; 
				 break;
			}else if(next.right!=null){
				root.next = next.right;
				break;
			}
			next = next.next;
			
		}  
		}
		
		helper(root.right, root.next);
		helper(root.left, root.next);
		
		
	}


	
}
class TreeLinkNode {
	int val;
	TreeLinkNode left, right, next;
	TreeLinkNode(int x) { val = x; }
}