package com.practice.algo.and.ds.stacksqueues;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//FYI, https://discuss.leetcode.com/topic/20902/my-solution-on-java-using-dp
//Also See DP_LeetCode_MaximalSquare
public class DP_MaxRectangleInBinaryMatrix {

	public static void main(String[] args) {
		String[] input = { "101101",
				"111111",
				"011011",
				"111010",
				"011111",
		"110111" };

		// ["01101","11010","01110","11110","11111","00000"]
		// {"10100","10111","11111","10010"};
		// {"11111111","11111110","11111110","11111000","01111000"};
		// {"01101","11010","01110","11110","11111","00000"};

		char[][] matrix = new char[input.length][input[0].length()];
		int i = 0;
		for (String str : input) {
			matrix[i] = str.toCharArray();
			i++;
		}
		DP_MaxRectangleInBinaryMatrix o = new DP_MaxRectangleInBinaryMatrix();
		System.out.println(o.maximalRectangle(matrix));
	}

	public int maximalRectangle(char[][] matrix) {
		if(matrix.length==0 || matrix[0].length==0)
			return 0;
		int[][] dp = new int[matrix.length][matrix[0].length];

		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				if(j==0)
					dp[i][j] = matrix[i][j]-'0';
				else
					dp[i][j] = matrix[i][j]=='0'?0:dp[i][j-1]+1;
			}	
		}
		int max = 0;
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				int ii = i;
				int min = dp[i][j];
				int area = Integer.MIN_VALUE;
				while(ii>=0){
					if(dp[ii][j]==0)
						break;
					min = Math.min(dp[ii][j],min);
					area = (i-ii+1)*min;
					max = Math.max(max, area);
					ii--;
				}
			}
		}
		return max;
	}




	//Stack approach
	public int maximalRectangle(ArrayList<ArrayList<Integer>> matrix) {



		if (matrix==null||matrix.size()==0||matrix.get(0).size()==0)
			return 0;
		int cLen = matrix.get(0).size();    // column length
		int rLen = matrix.size();       // row length
		// height array 
		int[] h = new int[cLen+1];
		h[cLen]=0;
		int max = 0;


		for (int row=0;row<rLen;row++) {
			Stack<Integer> s = new Stack<Integer>();
			for (int i=0;i<cLen+1;i++) {
				if (i<cLen)
					if(matrix.get(row).get(i)==1)
						h[i]+=1;
					else h[i]=0;

				if (s.isEmpty()||h[s.peek()]<=h[i])
					s.push(i);
				else {
					while(!s.isEmpty()&&h[i]<h[s.peek()]){
						int top = s.pop();
						int area = h[top]*(s.isEmpty()?i:(i-s.peek()-1));
						if (area>max)
							max = area;
					}
					s.push(i);
				}
			}
		}
		return max;

	}

	public int maximalRectangleLeet(char[][] matrix) {
		if (matrix==null||matrix.length==0||matrix[0].length==0)
			return 0;
		int cLen = matrix[0].length;    // column length
		int rLen = matrix.length;       // row length
		int[] h = new int[cLen+1];
		int max = 0;
		for (int row=0;row<rLen;row++) {
			Stack<Integer> s = new Stack<Integer>();
			for (int i=0;i<cLen+1;i++) {
				if (i<cLen)
					if(matrix[row][i]=='1')
						h[i]+=1;
					else h[i]=0;

				if (s.isEmpty()||h[s.peek()]<=h[i])
					s.push(i);
				else {
					while(!s.isEmpty()&&h[i]<h[s.peek()]){
						int top = s.pop();
						int area = h[top]*(s.isEmpty()?i:(i-s.peek()-1));
						if (area>max)
							max = area;
					}
					s.push(i);
				}
			}
		}
		return max;
	}

}
