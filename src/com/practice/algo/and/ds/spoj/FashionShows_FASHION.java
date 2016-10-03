package com.practice.algo.and.ds.spoj;

import java.util.Arrays;
import java.util.Scanner;

public class FashionShows_FASHION {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		for(int i=0;i<n;i++){
			int c=sc.nextInt();
			int[] men = new int[c];
			
			for(int j=0;j<c;j++){
				men[j] = sc.nextInt();
			}
			
			int[] women = new int[c];
			for(int j=0;j<c;j++){
				women[j] = sc.nextInt();
			}
			Arrays.sort(men);
			Arrays.sort(women);
			int res = 0;
			for(int j=0;j<c;j++){
				res += (men[j]*women[j]);
			}
			System.out.println(res);
		}
	}
}
