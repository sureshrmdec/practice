package com.practice.algo.and.ds.Tree;

//http://www.geeksforgeeks.org/print-nodes-distance-k-given-node-binary-tree/
//Asked in Amazona and Microsoft
//Very important Problem
public class Amazon_Trees_FindNodesAtKDistance {

	public static void main(String[] args) {
		TreeNode o1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode f4 = new TreeNode(4);
		TreeNode f5 = new TreeNode(5);
		TreeNode s6 = new TreeNode(6);
		TreeNode s7 = new TreeNode(7);
		TreeNode e8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode t10 = new TreeNode(10);
		TreeNode e11 = new TreeNode(11);

		o1.left = t2;
		o1.right = t3;
		t2.left = f4;
		t2.right = f5;
		f4.left = s6;
		f4.right = s7;
		f5.left = e8;
		f5.right = n9;
		s6.left = t10;
		s6.right = e11;

		Amazon_Trees_FindNodesAtKDistance o = new Amazon_Trees_FindNodesAtKDistance();
		o.printKDistance(o1, 6, 4);
	}


	public int printKDistance(TreeNode root, int n,int K){

		if(root==null)
			return -1;
		if(root.val==n){	
			printKDistanceDown(root,K);
			return 0;
		}
		int l = printKDistance(root.left,n,K);
		if(l!=-1){
			//either one of them will be true...If root is at correct distance then no need of going right
			if (l + 1 == K) 
			{
				System.out.print(root.val);
				System.out.println("");
			}else
				printKDistanceDown(root.right,K-l-2);
			return l+1;
		}
		int r = printKDistance(root.right,n,K);
		if(r!=-1){
			//either one of them will be true...If root is at correct distance then no need of going left
			if (r + 1 == K) 
			{
				System.out.print(root.val);
				System.out.println("");
			}else
				printKDistanceDown(root.left,K-r-2);
			return r+1;
		}
		return -1;
	}

	private void printKDistanceDown(TreeNode root, int K) {
		// TODO Auto-generated method stub
		if(root==null)
			return;
		if(K==0){
			System.out.println(root.val);
			return;
		}
		printKDistanceDown(root.left,K-1);
		printKDistanceDown(root.right,K-1);
	}
}
