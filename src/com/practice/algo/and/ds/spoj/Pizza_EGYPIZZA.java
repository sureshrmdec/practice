package com.practice.algo.and.ds.spoj;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Pizza_EGYPIZZA {

	
	// TODO Auto-generated method stub
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));

	public static void main(String[] args) throws IOException {
		String x = new String("saurabh");
		String y =x ;
		x="kakar";
		System.out.println(x + " "+y);
		
		
		new Pizza_EGYPIZZA().run();
	}
	void run() throws IOException {
		solve();
		
		out.flush();
	}

	void solve() throws IOException {
		int n = Integer.parseInt(in.readLine());
		double[] a = new double[n];
		double res = 0;
		for(int i=0;i<n;i++){
			String aa = (in.readLine());
			if(aa.equals("1/2")){
				a[i]=0.5;
			}
			if(aa.equals("1/4")){
				a[i]=0.25;
			}
			if(aa.equals("3/4")){
				a[i]=0.75;
			}

		}
		Arrays.sort(a);
		int i=0;
		int j=n-1;
		double temp = 0;
		while(i<j){
			if(temp + a[i]+a[j]==1.0){
				res++;
				i++;
				j--;
				temp=0;
			}else if(temp+a[i]+a[j]>=1.0){
				res+=2;
				i++;
				j--;
				temp=0;
			}else{
				temp += a[i]+a[j];
				i++;
				j--;
			}
		}
		if(i==j){
			if(temp+a[i]<=1.0)
				res++;
			if(temp+a[i]>1.0)
				res+=2;
			
		}
		out.println(res+1);
	}
}
