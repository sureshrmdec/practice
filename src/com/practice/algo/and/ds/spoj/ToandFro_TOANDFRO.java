package com.practice.algo.and.ds.spoj;

import java.util.Scanner;

public class ToandFro_TOANDFRO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int x = 0;
		while((x=sc.nextInt())!=0){
			//int x = ;
			System.out.println();
			String msg = sc.next();
			char[][] arr = new char[msg.length()/x][x];
			int row = -1;
			boolean dir = true;
			int common = 0;
			for(int i=0;i<msg.length();i++){
					if(i%x==0){
						dir = dir==true?false:true;
						row+=1;
						if(dir){
							common = x-1;
						}else{
							common = 0;
						}
					}
					arr[row][dir==false?(common++):(common--)]=msg.charAt(i);
			}

			for(int j=0;j<x;j++){
				for(int i=0;i<msg.length()/x;i++){
					System.out.print(arr[i][j]);
					
			}
			}
		}
		
	
	}

}
