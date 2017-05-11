package com.practice.algo.and.ds.maths;

import java.util.Scanner;

/*If we examine the Euclidean Algorithm we can see that it makes use of the following properties:
GCD(A,0) = A
GCD(0,B) = B
If A = B⋅Q + R and B≠0 then GCD(A,B) = GCD(B,R) where Q is an integer, R is an integer between 0 and B-1*/

//https://www.khanacademy.org/computing/computer-science/cryptography/modarithmetic/a/the-euclidean-algorithm

public class Euclidean_GCD {

	public static void main(String[] args) {

	    Scanner scanner = new Scanner(System.in);
	    String[] input = scanner.nextLine().split(" ");

	    int a = Integer.parseInt(input[0]), b = Integer.parseInt(input[1]);
	    int gcd = gcd(a, b);

	    System.out.println(a / gcd + " " + b / gcd);

	}

	// Euclidean Algorithm for finding greatest common divisor
	public static int gcd(int a, int b) {
	    return (a == 0 || b == 0) ? Math.max(a, b) : gcd(b, a % b);
	}
}
