package com.practice.algo.and.ds.Tree;

import java.util.ArrayList;
import java.util.List;


//https://www.careercup.com/question?id=5713295928459264

/*Given a binary tree and a target number, return whether or not there exist a path that can create target number.
 *  All inputs are integers. Target is not a string. 

NOTE:: this is not path sums to target number 
ex: 
     3 
  4     5 
6   7  8  9 

359 = return true 
38 = return false 
47 = return true 
6 = return true
*/
public class CareerCup_Amazon_FindGivenNumberInTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(0);
		TreeNode o1 = new TreeNode(3);
		TreeNode t2 = new TreeNode(1);
		TreeNode t3 = new TreeNode(3);
		TreeNode f4 = new TreeNode(4);
		TreeNode f5 = new TreeNode(4);
		TreeNode s6 = new TreeNode(6);
		TreeNode s7 = new TreeNode(7);
		TreeNode e8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);

		root.left = o1;
		root.right = t2;

		o1.left = t3;
		o1.right = f4;
		
		t2.left = f5;
		t2.right = s6;
		
		t3.left = s7;
		t3.right = e8;
		f5.left = n9;

		CareerCup_Amazon_FindGivenNumberInTree o = new CareerCup_Amazon_FindGivenNumberInTree();
		System.out.println(o.hasNumberInTree(root,338));
	}
	public boolean hasNumberInTree(TreeNode root,Integer n){
		List<Integer> nL = new ArrayList<>();
		
		while(!(n<10)){
			int nR = n%10;
			n = n/10;
			nL.add(0,nR);
		}
		nL.add(0,n);
		return hasNumberInTreeHelper2(root,nL,0);
		//return hasNumberInTreeHelper(root,nL,-1,0,0);
	}
/*	ex: 
	     3 
	  4     5 
	6   7  8  9*/

	
	public boolean hasNumberInTreeHelper(TreeNode root,List<Integer> nL,int previosLevel,int level,int i){

		if(root==null)
			return false;
		
		if(root.val == nL.get(i)){
			if(previosLevel==-1)
				previosLevel = level;
			else if(level-previosLevel>1)
				return false;
			previosLevel = level;
			i=i+1;			
		}
		if(i==nL.size()){
			return true;
		}
		
		if(hasNumberInTreeHelper(root.left, nL,previosLevel,level+1,i) || hasNumberInTreeHelper(root.right, nL,previosLevel,level+1,i))
			return true;
		
		return false;
	}
	
	
	public boolean hasNumberInTreeHelper2(TreeNode root,List<Integer> nL,int i){
		if(root==null)
			return false;
		
		if(i==nL.size()-1 && root.val==nL.get(nL.size()-1))
			return true;
		if(root.val == nL.get(i)){
			return hasNumberInTreeHelper2(root.left, nL, i+1) || 
					hasNumberInTreeHelper2(root.right, nL, i+1); 
		}else{
			
			if(root.val == nL.get(0)){
				return hasNumberInTreeHelper2(root.left, nL, 1) ||
						hasNumberInTreeHelper2(root.right, nL, 1) ; 
			}else{
				return hasNumberInTreeHelper2(root.left, nL, 0) ||
						hasNumberInTreeHelper2(root.right, nL, 0) ;
			}
					
					
		}
	}
	
	

}
