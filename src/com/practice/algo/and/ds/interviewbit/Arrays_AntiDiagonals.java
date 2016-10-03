package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays_AntiDiagonals {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Arrays_AntiDiagonals o = new Arrays_AntiDiagonals();
		Integer[][] in = {{1 ,2 ,3},
				{4 ,5 ,6},
				{7 ,8 ,9}};
		ArrayList<ArrayList<Integer>> a  = new ArrayList<>();
		for(int i=0;i<in.length;i++){
			ArrayList<Integer> aa = new ArrayList<>(Arrays.asList(in[i]));
			a.add(aa);
		}
		System.out.println(o.diagonal(a));
		
	}

	public ArrayList<ArrayList<Integer>> diagonal(ArrayList<ArrayList<Integer>> a) {
		int[][] matrix = new int[a.size()][a.size()];
		ArrayList<ArrayList<Integer>> res = new ArrayList<>();
		for(int i=0;i<a.size();i++){
			ArrayList<Integer> ina = a.get(i);
			for(int j=0;j<a.size();j++){
				matrix[i][j] = ina.get(j);
			}	
		}
		int rvv = 1;
		int cvv = -1;
		int[] dx = {0,1};
		int[] dy = {1,0};
		int d=0;
		int rh =0;int ch=0;
		for(int i=0;i<(a.size()*2)-1;i++){
			
			ArrayList<Integer> ap = new ArrayList<>();
			
			int rv = rh;
			int cv = ch;
			while(cv>=0 && rv<a.size()){
				ap.add(matrix[rv][cv]);
				rv+=rvv;
				cv+=cvv;
			}
			
			
			if((ch+dy[d]) >= a.size()){
				d=d+1;
			}
			rh+=dx[d];
			ch+=dy[d];
			
			res.add(ap);
		}
		return res;
	}
	
}
