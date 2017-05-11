package com.practice.algo.and.ds.interview.questions;

import java.util.ArrayList;
import java.util.List;

/*[
 [1, 2,  3,  4],
 [5, 6,  7,  8],
 [9,10, 11, 12]
]
return [1, 2, 5, 9, 6, 3, 4, 7, 10, 11, 8, 12]
*/		
public class CareerCup_Google_MatrixZigZag {

	public static void main(String[] args) {
		int[][] matrix = {{1,2,3,4},
						  {5,6,7,8},
						  {9,10,11,12}
						  };
		CareerCup_Google_MatrixZigZag o = new CareerCup_Google_MatrixZigZag();
		System.out.println(o.printZigZagMatrix(matrix));

	}
	public List<Integer> printZigZagMatrix(int[][] matrix ){
		List<Integer> result = new ArrayList<>();
		int i=0,j=0;
		int[] dx = {-1,1};//up,down
		int[] dy = {1,-1};
		int d=0;
		int[] ex = {0,1};//right,down
		int[] ey = {1,0};
		int e = 0;
		while(true){
			result.add(matrix[i][j]);
			//if no up, then go right and start coming down diagnally
			//if no down go down and start going up	
			int ii  = i+dx[d];
			int jj  = j+dy[d];
			if(ii<0 || jj<0 || ii>=matrix.length || jj>=matrix[0].length){
				//change direction
				d = (d+1)%2;
				if(i==matrix.length-1){
					i = i+ex[0];
					j = j+ey[0];
				}else if(j==matrix[0].length-1){
					i = i+ex[1];
					j = j+ey[1];
				}else{
					i = i+ex[e];
					j = j+ey[e];	
				}
				
				result.add(matrix[i][j]);
				if(i==matrix.length-1 && j==matrix[0].length-1){
					break;
				}
				e = (e+1)%2;				
			}
			i  = i+dx[d];
			j  = j+dy[d];			
		}
		return result;
	}

}
