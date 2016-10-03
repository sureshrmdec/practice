package com.practice.algo.and.ds.interviewquestions.google;

import java.util.Scanner;

//https://www.glassdoor.com/Interview/Given-two-strings-with-the-same-characters-except-for-one-additional-character-in-one-string-return-that-additional-charac-QTN_1419665.htm
//http://www.practice.geeksforgeeks.org/problem-page.php?pid=414
//If you XOR a number with itself it will return 0 because 0^0=0 and 1^1=0
public class FindMissingNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(T-- > 0){
			int in = sc.nextInt();
			for(int i=1;i<in;i++){
				int s = sc.nextInt();
				if((i^s) != 0){
					System.out.println(i);
				}
			}
		}
	}

}
