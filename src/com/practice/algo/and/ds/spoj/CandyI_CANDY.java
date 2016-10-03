package com.practice.algo.and.ds.spoj;

import java.math.BigInteger;
import java.util.Scanner;

public class CandyI_CANDY {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//int n = 0;
		while(true){
			int n = sc.nextInt();
			if(n==-1){
				break;
			}
			int[] arr = new int[n];
			BigInteger count = BigInteger.ZERO;
			for(int i=0;i<n;i++){
				arr[i] = sc.nextInt();
				count = count.add(BigInteger.valueOf(arr[i]));
			}
			if(count.remainder(BigInteger.valueOf(n)) != BigInteger.ZERO){
				System.out.println(-1);
			}else{
				BigInteger ans=BigInteger.ZERO;
				BigInteger res = count.divide(BigInteger.valueOf(n));
				for(int i=0;i<n;i++){
					if(BigInteger.valueOf(arr[i]).compareTo(res) > 0)
						ans = ans.add(BigInteger.valueOf(arr[i]).subtract(res));
				}
				System.out.println(ans);
			}
			
		}
	}

}
