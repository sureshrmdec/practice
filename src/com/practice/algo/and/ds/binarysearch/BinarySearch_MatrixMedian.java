package com.practice.algo.and.ds.binarysearch;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch_MatrixMedian {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Integer[][] matrixArr = {{1,1,3,3,3} };
		//Integer[][] matrixArr = {{1,2,2,2,2,2,3,3,3,3,3} };
		  Integer[][] matrixArr = {{1, 3, 5}
				  				  ,{2, 6, 9}
				  				  ,{3, 6, 9}};
		ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
		for(int i=0;i<matrixArr.length;i++){
			ArrayList<Integer> l = new ArrayList<Integer>();
			l.addAll(Arrays.asList(matrixArr[i]));
			matrix.add(l);
		}
		BinarySearch_MatrixMedian o = new BinarySearch_MatrixMedian();
		System.out.println(o.getMedian(matrix));
	}

	public int getMedian(ArrayList<ArrayList<Integer>> matrix){
		int low = Integer.MAX_VALUE;
		int high = Integer.MIN_VALUE;
		int midF = (matrix.size()*matrix.get(0).size())/2;
		for(int i=0;i<matrix.size();i++){
			for(int j=0;j<matrix.get(0).size();j++){
				low = Math.min(low, matrix.get(i).get(j));
				high = Math.max(high, matrix.get(i).get(j));
			}
		}
		
		while(low<=high){
			int mid = (low + high)/2;
			
			int nSmall=0,nBig=0;
			for(int i=0;i<matrix.size();i++){
				for(int j=0;j<matrix.get(0).size();j++){
					
					int num = matrix.get(i).get(j);
					if(num<=mid)
						nSmall++;
					if(num>=mid)
						nBig++;

				}
			}
				if(nSmall>=midF)
					return mid;
				if(nSmall>nBig){
					high = mid-1;
				}else{
					low = mid+1;
				}
		}
		return 0;
	}
}
