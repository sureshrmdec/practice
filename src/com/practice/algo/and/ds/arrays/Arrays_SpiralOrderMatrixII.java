package com.practice.algo.and.ds.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Arrays_SpiralOrderMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub	
		Arrays_SpiralOrderMatrixII p = new Arrays_SpiralOrderMatrixII();
		System.out.println(p.generateMatrix(3));
	}
	/*
	  1   2  3  4
	  12 13 14  5
	  11 16 15  6
	  10  9  8  7
	*/
	public ArrayList<ArrayList<Integer>> generateMatrix(int a) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		int max = a*a;
		int s = 1;
		Integer[][] matrix = new Integer[a][a];
		for(int i=0;i<a;i++){
			Arrays.fill(matrix[i], -1);
		}
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		int i=0;int j=0;int d=0;
		
		for(int k=0;k<a*a;k++){
				matrix[i][j]=s;
				s++;
				if((i+dx[d]>=a || i+dx[d]<0 || j+dy[d]>=a || j+dy[d]<0)){
					d = (d+1) % 4;

				}else if(matrix[i+dx[d]][j+dy[d]]!=-1){
					d = (d+1) % 4;
				}
				
				i+=dx[d];
				j+=dy[d];
				
		
		}
		for(int m=0;m<a;m++){
			ArrayList<Integer> ar = new ArrayList<>(Arrays.asList(matrix[m]));
			res.add(ar);
		}
		return res;
	
	}
	
}
