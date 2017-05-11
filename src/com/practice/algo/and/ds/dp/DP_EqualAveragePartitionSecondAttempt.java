package com.practice.algo.and.ds.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

//https://www.quora.com/How-would-you-divide-an-integer-array-into-2-sub-arrays-such-that-their-averages-were-equal
//Another way using bitmasking approach
public class DP_EqualAveragePartitionSecondAttempt {

	public static void main(String[] args) {

		Integer [] Aa = {47, 14, 30, 19, 30, 4, 32, 32, 15, 2, 6, 24};
		//Integer [] Aa = {1,7,9,11,15,29};
		//int [] A = {5,6,10,1};
		ArrayList<Integer> A = new ArrayList<>(Arrays.asList(Aa));
		//isPossible(0, 24, 3);
		//isPossible(2, 0, A,24);
		DP_EqualAveragePartitionSecondAttempt o = new DP_EqualAveragePartitionSecondAttempt();
		System.out.println(o.avgset(A));

	}


	static int totalSize;
	static ArrayList<Integer> res = new ArrayList<Integer>();
	static ArrayList<Integer> original;
	static ArrayList<Integer> result = new ArrayList<>();
	static ArrayList<Integer> resultIndex = new ArrayList<>();
	static boolean[][][] dp;

	public  ArrayList<ArrayList<Integer>> avgset(ArrayList<Integer> A) {
		result.clear();
		resultIndex.clear();
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		totalSize = A.size();
		if(A == null || A.size() == 0)
			return result;


		Collections.sort(A);

		original = new ArrayList<Integer>(A);
		int totalSum = 0;
		for(int i = 0; i < A.size(); i++)
			totalSum += A.get(i);
		//System.out.println("Total Sum : " + totalSum + "  Total Size: " + totalSize);

		dp = new boolean[original.size()][totalSum + 1][totalSize];
		for(int i =0; i < original.size(); i++){
			for(int j = 0; j < totalSum + 1; j++){
				for(int k =0; k < totalSize; k++)
					dp[i][j][k] = true;
			}
		}
		for(int i = 1; i < totalSize; i++){
			if((totalSum * i) % totalSize != 0) 
				continue;
			int sumOfSet1 = (totalSum * i) / totalSize;
			if(isPossible(i, 0,A,sumOfSet1)){
				ArrayList<Integer> res1 = new ArrayList<Integer>(res);
				ArrayList<Integer> res2 = new ArrayList<Integer>();
				for(int k=0;k<A.size();k++){
					if(resultIndex.contains(k))
						res1.add(A.get(k));
					else
						res2.add(A.get(k));
				}
				result.add(res1);
				result.add(res2);
				return result;
			}
		}
		return result;

	}



	public static boolean isPossible(int size,int index,ArrayList<Integer> originalList,int sum){
		if(sum<0)
			return false;
		if(size==0){
					//System.out.println(result);
			return sum==0;
		}
		if(index >= totalSize) {
			//	System.out.println("returning False");
			return false;
		}
		if(dp[index][sum][size] == false){
			System.out.println("In DP returning False "+index +" "+sum+" "+size);
			return false;
		}

		for(int i=index;i<originalList.size();i++){
			int currentNum = originalList.get(i);
			result.add(currentNum);
			resultIndex.add(i);
			if(isPossible(size-1, i+1, originalList,sum-currentNum))
				return true;
			result.remove(result.size()-1);
			resultIndex.remove(resultIndex.size()-1);
			System.out.println("sum "+sum+" size "+size +" index "+i);
			dp[i][sum][size] = false;
		}

		return false;
	}

}
