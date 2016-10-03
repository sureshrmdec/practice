package com.practice.also.and.ds.implementation;

import java.util.Scanner;

public class VK_BearandReverseRadewoosh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int c = sc.nextInt();
		int[] p = new int[n];
		int[] t = new int[n];
		for(int i=0;i<n;i++){
			p[i]=sc.nextInt();
			
		}
		for(int i=0;i<n;i++){
			t[i]+=sc.nextInt();
		}
		int[] lt=new int[n];
		int[] rt=new int[n];
		for(int i=0;i<n;i++){
			lt[i]+=t[i];
			if(i<n-1)
				lt[i+1]+=lt[i];
		}
		//Limaks
		int l =0;
		int r =0;
		
		
		for(int i=n-1;i>=0;i--){
			rt[i]+=t[i];
			if(i>0)
				rt[i-1]+=rt[i];
		}
		for(int i=0;i<n;i++){
			l += Math.max(0, p[i]-c*lt[i]);
			//l+=(p[i]-ls);
			r += Math.max(0, p[i]-c*rt[i]);
			//r+=(p[i]-rs);
			
		}
		if(l>r){
			System.out.println("Limak");
		}else if(r>l){
			System.out.println("Radewoosh");
		}else{
			System.out.println("Tie");
		}
	}

}
