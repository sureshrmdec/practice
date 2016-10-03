package com.practice.algo.and.ds.interview.questions;

import java.util.ArrayList;
import java.util.List;

//Same as https://www.interviewbit.com/problems/rotate-matrix/
public class LeetCode_RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public void rotate(int[][] matrix) {
		 int steps = matrix.length-1;
		 int ii=0;
		 int jj=0;
		 while(steps>0){
			 List<Integer> x = new ArrayList<>();
			 List<Integer> y = new ArrayList<>();
			 for(int d=0;d<=steps;d++){
				 x.add(d);
				 y.add(steps-d);
			 }
			 
			 for(int j=jj;j<steps;j++){
				 
				 
			 }
			 
			 
			 ii++;
			 jj++;
			 steps = steps -2;
		 }
		 
	 }
}
