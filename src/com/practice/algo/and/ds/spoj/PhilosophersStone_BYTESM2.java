package com.practice.algo.and.ds.spoj;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class PhilosophersStone_BYTESM2 {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	    PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	    
		int T = Integer.parseInt(in.readLine());
		for(int ii=0;ii<T;ii++){
			StringTokenizer tokenizer = new StringTokenizer(in.readLine());
			int h = Integer.parseInt(tokenizer.nextToken());
			int w = Integer.parseInt(tokenizer.nextToken());
			int[][] dp = new int[102][102];
			
			for(int i=1;i<=1;i++){
			for (int j = 1; j <= w; j++) {
		            if (!tokenizer.hasMoreTokens())
		                tokenizer = new StringTokenizer(in.readLine());
		            dp[i][j] = Integer.parseInt(tokenizer.nextToken());
		        }
			}
			
			for(int i=2;i<=h;i++){
				for(int j=1;j<=w;j++){
					if (!tokenizer.hasMoreTokens())
	                    tokenizer = new StringTokenizer(in.readLine());
					dp[i][j] += Integer.parseInt(tokenizer.nextToken()) +Math.max(dp[i-1][j+1],Math.max(dp[i-1][j], dp[i-1][j-1]));
				}
			}
			int max = 0;
	        for (int j = 1; j <= w; j++)
	            max = (max < dp[h][j]) ? dp[h][j] : max;
			
	            out.println(max);	
		}
	}

}
