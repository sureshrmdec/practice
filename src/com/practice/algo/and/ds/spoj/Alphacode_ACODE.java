package com.practice.algo.and.ds.spoj;

import java.math.BigInteger;
import java.util.Scanner;

public class Alphacode_ACODE {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		while(true){
			String s = sc.next();
			if(s.equals("0")){
				break;
			}
			if(s.length()==1){
				System.out.println(1);
			}else{
				BigInteger[] dp = new BigInteger[s.length()];
				dp[0] = BigInteger.ONE;
				boolean pz = false;
				for(int i=1;i<s.length();i++){

					if(Integer.parseInt(Character.toString(s.charAt(i-1)).concat(Character.toString(s.charAt(i)))) <= 26){
						if(i>=2){
							if(s.charAt(i)=='0'){
								dp[i] = dp[i-2];
								pz=true;
							}else{

								if(pz){
									dp[i] = dp[i-1];
									pz=false;
								}else
									dp[i] = dp[i-1].add(dp[i-2]);
							}


						}
						else{
							if(s.charAt(i)=='0'){
								dp[i] = dp[i-1];
								pz = true;
							}else{
								dp[i] = dp[i-1].add(BigInteger.ONE);
							}
						}
					}else{
						dp[i] = dp[i-1];
					}	

				}
				System.out.println(dp[s.length()-1]);
			}

		}

	}

}
