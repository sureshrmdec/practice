package com.practice.algo.and.ds.spoj;

import java.util.Scanner;

public class NumberSteps_NSTEPS {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i =0;i<t;i++){
			int x = sc.nextInt();
			int y = sc.nextInt();
			if(x==y){
				if(x%2 == 0){
					System.out.println(x*2);
				}else{
					System.out.println(((x/2)*4)+1);
				}
			}else{
				if((x>y) && (x-y==2)){
				if(y%2==0){
					System.out.println(y*2+2);
				}else{
					System.out.println(y*2+1);
				}
				}else{
					System.out.println("No Number");
				}
			}
		}
	}

}
