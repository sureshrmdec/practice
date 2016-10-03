package com.practice.algo.and.ds.spoj;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class PartySchedule_PARTY {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

		while(true){
			String line = r.readLine();
			if(line.equals(""))
				continue;
			int budget =0;
			int noOfParties =0;

			String[] str= line.split(" ");


			budget = Integer.parseInt(str[0]);
			noOfParties = Integer.parseInt(str[1]);
			if(budget ==0 && noOfParties==0){
				break;
			}

			int[] fee = new int[noOfParties];
			int[] value = new int[noOfParties];
			for(int i =0;i<noOfParties;i++){
				line = r.readLine();
				str= line.split(" ");


					fee[i] = Integer.parseInt(str[0]);
					value[i] = Integer.parseInt(str[1]);
				
			}	
			int[][] dp = new int[noOfParties+1][budget+1];
			int ww = 0;
			int vv = Integer.MIN_VALUE;
			for(int i=0;i<=noOfParties;i++){
				for(int w=0;w<=budget;w++){
					if(i==0||w==0){
						dp[i][w] = 0;
					}else if(fee[i-1] <= w){
						dp[i][w] = Math.max(dp[i-1][w],value[i-1]+dp[i-1][w-fee[i-1]]);
						if(dp[i][w] >= vv){
							if(dp[i][w] == vv){
								ww = Math.min(w, ww);	
							}else
								ww = w;
							vv = dp[i][w];

						}
						
					}else{
						dp[i][w] = dp[i-1][w];
					}
					
				}	
			}
			 out.println(ww+" "+dp[noOfParties][budget]);
		}
		out.flush();
	}

}
