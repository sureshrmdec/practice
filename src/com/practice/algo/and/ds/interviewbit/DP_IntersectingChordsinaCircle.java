package com.practice.algo.and.ds.interviewbit;

import java.math.BigInteger;

public class DP_IntersectingChordsinaCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DP_IntersectingChordsinaCircle o = new DP_IntersectingChordsinaCircle();
		System.out.println(o.chordCnt(5));
	}
	 public int chordCnt(int A) {
	if(A==0){
		return 0;
	}
	if(A==1){
		return 1;
	}
	
	 BigInteger[] dp = new BigInteger[A+1];
	 dp[1]=BigInteger.ONE;
	 dp[2]=BigInteger.ONE.add(BigInteger.ONE);
 	 
	 for(int i=3;i<=A;i++){
		 BigInteger y = BigInteger.valueOf(2).multiply((dp[i-1])).mod(BigInteger.valueOf(1000000007));
		 int totalPoints = i*2;
		 int j=4;
		 while(j<=totalPoints-2){
			 //int b = j-2>totalPoints-j?j-2:totalPoints-j;
			 BigInteger x = (dp[(j-2)/2]).multiply(dp[(totalPoints-j)/2]).mod(BigInteger.valueOf(1000000007));
			// dp[i]+=dp[(j-2)/2]*dp[(totalPoints-j)/2];
			 //dp[i]+=dp[b/2];
			 y = y.add(x);
			 j=j+2;
		 }
		 dp[i] = y;
	 }
	 return (dp[dp.length-1]).mod(BigInteger.valueOf(1000000007)).intValue();
	 }
}
