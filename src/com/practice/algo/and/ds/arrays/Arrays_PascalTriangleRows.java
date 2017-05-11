package com.practice.algo.and.ds.arrays;

import java.util.ArrayList;

public class Arrays_PascalTriangleRows {

	public static void main(String[] args) {
		Arrays_PascalTriangleRows a = new Arrays_PascalTriangleRows();
		System.out.println(a.generate2(4));

	}
	
	public ArrayList<ArrayList<Integer>> generate2(int numRows) {
		ArrayList<ArrayList<Integer>> triangle = new ArrayList<ArrayList<Integer>>();
        if (numRows <=0){
            return triangle;
        }
        for (int i=0; i<numRows; i++){
        	ArrayList<Integer> row =  new ArrayList<Integer>();
            for (int j=0; j<i+1; j++){
                if (j==0 || j==i){
                    row.add(1);
                } else {
                    row.add(triangle.get(i-1).get(j-1)+triangle.get(i-1).get(j));
                }
            }
            triangle.add(row);
        }
        return triangle;
    }

}
