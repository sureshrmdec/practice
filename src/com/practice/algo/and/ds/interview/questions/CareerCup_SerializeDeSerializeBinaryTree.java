package com.practice.algo.and.ds.interview.questions;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.practice.algo.and.ds.interviewbit.Trees_DiameterOfTree;

//Using Java Serializable interface it can be done though....
public class CareerCup_SerializeDeSerializeBinaryTree {

	public static void main(String[] args) {
		CareerCup_SerializeDeSerializeBinaryTree o = new CareerCup_SerializeDeSerializeBinaryTree();
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
		TreeNode t12 = new TreeNode(12);
		TreeNode t13 = new TreeNode(13);
		TreeNode f14 = new TreeNode(14);
		TreeNode f15 = new TreeNode(15);
		TreeNode s16 = new TreeNode(16);
		TreeNode s17 = new TreeNode(17);

		o1.left = t2;
		o1.right = t3;

		t3.left = f4;
		t3.right = f5;

		f4.left = s6;
		f4.right = s7;

		f5.right = e8;
		
		
		s6.left = n9;
		s6.right = t10;

		s7.left = e11;
		s7.right = t12;

		e8.right = t13;
		
		n9.right = f14;

		t12.left=f15;

		t13.right=s16;

		f15.left = s17;

		testSerialization(o1);
		testDeSerialization();
	}
	private static void testSerialization(TreeNode root) {
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream("/tmp/tree.ser");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(root);
	         out.close();
	         fileOut.close();
	         System.out.printf("Serialized data is saved in /tmp/employee.ser");
	      }catch(IOException i) {
	         i.printStackTrace();
	      }
		
	}
	private static void testDeSerialization() {
		
		TreeNode e = null;
		try {
        FileInputStream fileIn = new FileInputStream("/tmp/tree.ser");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        e = (TreeNode) in.readObject();
        in.close();
        fileIn.close();
     }catch(IOException i) {
        i.printStackTrace();
        return;
     }catch(ClassNotFoundException c) {
        System.out.println("Employee class not found");
        c.printStackTrace();
        return;
     }
	}
	static class TreeNode implements Serializable{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
}
