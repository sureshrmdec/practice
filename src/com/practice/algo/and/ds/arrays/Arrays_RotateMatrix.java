package com.practice.algo.and.ds.arrays;import java.util.ArrayList;
import java.util.Arrays;

public class Arrays_RotateMatrix {
 
	/*
	 1  2   3  4
	 5  6   7  8
	 9  10  11 12
	13  14  15 16
	
	 [13 9 5 1 ] 
	 [14 10 6 2 ] 
	 [15 11 7 3 ] 
     [16 12 8 4 ]*/
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays_RotateMatrix ii = new Arrays_RotateMatrix();
		Integer[][] matrix = {{1, 2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		ArrayList<ArrayList<Integer>> a = new ArrayList<>();
		for(int i=0;i<matrix.length;i++){
			a.add(new ArrayList<>(Arrays.asList(matrix[i])));
		}
		ii.rotate(a);
	}

	public void rotate(ArrayList<ArrayList<Integer>> a) {
	
		Integer[][] matrix = new Integer[a.size()][a.size()];
		for(int i=0;i<a.size();i++){
			ArrayList<Integer> ina = a.get(i);
			for(int j=0;j<a.size();j++){
				matrix[i][j] = ina.get(j);
				
				
			}	
		}

	  /*00 01 02 03
		10 11 12 13
		20 21 22 23
		30 31 32 33*/
		int n = a.size();
		for(int i=0;i<n/2;i++){
			for(int j=i;j<n-i-1;j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[n-j-1][i];//02<10
				matrix[n-j-1][i] =matrix[n-i-1][n-j-1];//10 < 31
				matrix[n-i-1][n-j-1] = matrix[j][n-i-1];//31 < 23
				matrix[j][n-i-1] = temp; //23 < 02;
			}
		
		}
		a.clear();
		for(int i=0;i<matrix.length;i++){
			a.add(new ArrayList<Integer>(Arrays.asList(matrix[i])));
		}
		
	}
}
