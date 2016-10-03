/*Given a list of n integers, A={a1,a2,�,an}, and another integer, k representing the expected sum. 
Select zero or more numbers from A such that the sum of these numbers is as near as possible, 
but not exceeding, to the expected sum (k).

Note

Each element of A can be selected multiple times.
If no element is selected then the sum is 0.
Input Format

The first line contains T the number of test cases. 
Each test case comprises of two lines. First line contains two integers, n k, representing the 
length of list A and expected sum, respectively. Second line consists of n space separated integers, 
a1,a2,�,an, representing the elements of list A.*/

package com.practice.algo.and.ds.hackerrank;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class HackerRank_Knapsack {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int i=0;i<t;i++){
			int n = sc.nextInt();
			int k = sc.nextInt();
			Set<Integer> set = new TreeSet<Integer>();
			int[] a = new int[n];
			
			for(int j=0;j<n;j++){
				int in = sc.nextInt();
				a[j]=in;
				set.add(in);
			}
			
			Arrays.sort(a);
			int s = a[0];
			if(s>k){
				System.out.println(0);
				continue;
			}
			int result = s;
			
			for(int j=s;j<=k;j++){
				if(set.contains(j)){
					result = j;
					continue;
				}else{
					Iterator<Integer> it = set.iterator();
					while(it.hasNext()){
						int nn = it.next();
						if(set.contains(j-nn)){
							set.add(j);
							result = j;
							break;
						}
					}
					
				}
			}
			System.out.println(result);
			
		}
	}

}
