package com.practice.algo.and.ds.hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class HackerRank_SamAndSubStrings {
    private final static int MOD = 1000000007;
    
    public static void main(String[] args) throws IOException {
        
        int[] balls = strNumToArr((new BufferedReader(new InputStreamReader(System.in))).readLine());
      
        int n = balls.length;
        int total = 0;
        
        int[] dp = new int[n];
        
        dp[0] = balls[0];
        total+=dp[0];
        
        for(int i = 1; i < n; i++){
        	BigInteger a = (BigInteger.valueOf(dp[i-1]).multiply(BigInteger.valueOf(10))).mod(BigInteger.valueOf(MOD));
        	
            dp[i] = (int)(((i+1)*balls[i])+((a.intValue())%MOD)%MOD);
            total = (int)((total + dp[i])%MOD);
        }
        
        
        
        System.out.print(total);
    }
    
    private static int[] strNumToArr(String str){
        int n = str.length();
        int[] ar = new int[n];
        int i=0;
        for(char c : str.toCharArray()){
            ar[i++] = c - '0';
        }
        return ar;
    }}
