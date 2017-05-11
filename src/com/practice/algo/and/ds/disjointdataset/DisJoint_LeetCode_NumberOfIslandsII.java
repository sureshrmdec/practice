package com.practice.algo.and.ds.disjointdataset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DisJoint_LeetCode_NumberOfIslandsII {

	public static void main(String[] args) {
		DisJoint_LeetCode_NumberOfIslandsII o = new DisJoint_LeetCode_NumberOfIslandsII();
		int[][] positions = {{2,1},{4,3},{3,3},{4,2},{1,1},{1,3}};
		System.out.println(o.numIslands2(5, 4, positions));

	}
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
		
		//create parent array
		int[] root = new int[m*n];
		Arrays.fill(root,-1);
		
		ArrayList<Integer> result = new ArrayList<>();
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,1,-1};
		int count=0;
		
		for(int k=0; k<positions.length; k++){
			count++;
			int[] p = positions[k];
			int index = p[0]*n+p[1];
			root[index]=index;//set root to be itself for each node
			for(int d=0;d<4;d++){
	            int i=p[0]+dx[d];
	            int j=p[1]+dy[d];
	            if(i>=0&&j>=0&&i<m&&j<n&&root[i*n+j]!=-1){
	                //get neighbor's root
	                int thisRoot = getRoot(root, i*n+j);
	                if(thisRoot!=index){
	                    root[thisRoot]=index;//set previous root's root
	                    count--;
	                }
	            }
	        }
			result.add(count);
			
			
		}
		return result;
	}
	public int getRoot(int[] arr, int i){
	    while(i!=arr[i]){
	        i=arr[i];
	    }
	    return i;
	}
	
}
