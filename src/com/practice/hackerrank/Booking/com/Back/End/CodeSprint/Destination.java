package com.practice.hackerrank.Booking.com.Back.End.CodeSprint;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

public class Destination {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader r = new java.io.BufferedReader (new java.io.InputStreamReader (System.in));
		String[] sa = r.readLine().split(" ");
		
		Scanner sc = new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int n= Integer.parseInt(sa[0]);
		int m= Integer.parseInt(sa[1]);
		int c= Integer.parseInt(sa[2]);
		
		int j = (n+m-2*c+c-1);
		BigInteger res = BigInteger.ONE;
		for(int i=j;i>1;i--){
			res = res.multiply(BigInteger.valueOf(i));
		}
		out.println(res);
		out.close();
	}

}
