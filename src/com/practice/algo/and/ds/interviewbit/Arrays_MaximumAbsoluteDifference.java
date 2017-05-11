package com.practice.algo.and.ds.interviewbit;

public class Arrays_MaximumAbsoluteDifference {

	public static void main(String[] args) {
		int[] a = {1, 3, -1};
		Arrays_MaximumAbsoluteDifference o = new Arrays_MaximumAbsoluteDifference();
		System.out.println(o.maxDiff(a));

	}

	public int maxDiff(int[] a){
		int result = Integer.MIN_VALUE;
		for(int i=0;i<a.length-1;i++){
			for(int j=i+1;j<a.length;j++){
				result = Math.max(result, Math.abs(a[i]-a[j])+Math.abs(i-j));
			}
		}
		return result;
	}
}
