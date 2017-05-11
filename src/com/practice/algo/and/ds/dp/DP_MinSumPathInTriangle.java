package com.practice.algo.and.ds.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DP_MinSumPathInTriangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] a =  {1};
		Integer[] b =   {2,3};
		/*Integer[] c = {6,5,2};
		Integer[] d = {-8,-2,-7,3};
		Integer[] e = {-2,6,-6,-1,4};*/
		  List<ArrayList<Integer>> triangle = new ArrayList<>();
		  triangle.add(new ArrayList<>(Arrays.asList(a)));
		  triangle.add(new ArrayList<>(Arrays.asList(b)));
		/*  triangle.add(new ArrayList<>(Arrays.asList(c)));
		  triangle.add(new ArrayList<>(Arrays.asList(d)));
		  triangle.add(new ArrayList<>(Arrays.asList(e)));*/
		  DP_MinSumPathInTriangle o = new DP_MinSumPathInTriangle();
		  System.out.println(o.minimumTotal(triangle));
	}

	public int minimumTotal(List<ArrayList<Integer>> triangle) {
        for(int i = triangle.size() - 2; i >= 0; i--)
            for(int j = 0; j <= i; j++)
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i + 1).get(j), triangle.get(i + 1).get(j + 1)));
        return triangle.get(0).get(0);
    }
}
