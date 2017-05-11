package com.practice.algo.and.ds.dp;

import java.util.ArrayList;
import java.util.Arrays;

public class DP_KthManhattanDistanceNeighbourhood {

	public static void main(String[] args) {
		//Integer[] a = {1,2,4};
		//Integer[] b = {4,5,8};

		Integer[] a = {1, 2, 4, 6, 8};
		Integer[] b = {2, 10, 5, 3, 10};
		Integer[] c = {8, 7, 7, 3, 1};
		Integer[] d = {4, 5, 6, 8, 7};
		Integer[] e = {10, 12, 5, 9, 2};
		Integer[] f = {13, 15, 14, 2, 6};
		ArrayList<Integer> aa = new ArrayList<>(Arrays.asList(a));
		ArrayList<Integer> bb = new ArrayList<>(Arrays.asList(b));
		ArrayList<Integer> cc = new ArrayList<>(Arrays.asList(c));
		ArrayList<Integer> dd = new ArrayList<>(Arrays.asList(d));
		ArrayList<Integer> ee = new ArrayList<>(Arrays.asList(e));
		ArrayList<Integer> ff = new ArrayList<>(Arrays.asList(f));
		ArrayList<ArrayList<Integer>> B = new ArrayList<>();
		B.add(aa);
		B.add(bb);
		B.add(cc);
		B.add(dd);
		B.add(ee);
		B.add(ff);
		DP_KthManhattanDistanceNeighbourhood o = new DP_KthManhattanDistanceNeighbourhood();
		o.solve(2, B);
		System.out.println(B);
	}
	public ArrayList<ArrayList<Integer>> solve(int A, ArrayList<ArrayList<Integer>> B) {
		if(A==0)
			return B;
		ArrayList<ArrayList<Integer>> BB = new ArrayList<ArrayList<Integer>>();
		int[] dx = {-1,0,1,0};
		int[] dy = {0,1,0,-1};
		for(int k=1;k<=A;k++){
			BB.clear();
			for(int i=0;i<B.size();i++){
				BB.add(new ArrayList<>());
				for(int j=0;j<B.get(0).size();j++){
					BB.get(i).add( 0);
				}
			}
			for(int i=0;i<B.size();i++){
				for(int j=0;j<B.get(0).size();j++){
					BB.get(i).set(j, B.get(i).get(j));
					for(int d = 0;d<4;d++){
						int ii = i+dx[d];
						int jj = j+dy[d];
						if(ii<0 || ii > B.size()-1 || jj<0 || jj > B.get(0).size()-1 || B.get(i).get(j) > B.get(ii).get(jj))
							continue;
						if(BB.get(i).get(j)<B.get(ii).get(jj))
							BB.get(i).set(j, B.get(ii).get(jj));
					}
				}
			}
			B = new ArrayList<>(BB);
		}
		return BB;
	}
}
