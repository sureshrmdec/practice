/*
 * 
Alice and Bob love playing one-dimensional battle ships. 
They play on the field in the form of a line consisting of n square cells (that
is, on a 1*n table).

At the beginning of the game Alice puts k ships on the field without telling their positions to Bob. Each ship looks as a 1*a rectangle (that is,
it occupies a sequence of a consecutive squares of the field). The ships cannot intersect and even touch each other.

After that Bob makes a sequence of "shots". He names cells of the field and Alice either says that the cell is empty ("miss"), or that the cell 
belongs to some ship ("hit").

But here's the problem! Alice like to cheat. May be that is why she responds to each Bob's move with a "miss".

Help Bob catch Alice cheating � find Bob's first move, such that after it you can be sure that Alice cheated.
Input

The first line of the input contains three integers: n,k and a (1<=n,k,a<=2*10pow5) � the size of the field, the number of the ships
 and the size of each ship. It is guaranteed that the n,k and a are such that you can put k ships of size a on the field, so that no two 
 ships intersect or touch each other.

The second line contains integer m(1<=m<=n) � the number of Bob's moves.

The third line contains  m distinct integers x1,x2....xm where  xi is the number of the cell where Bob made the ith shot.
 The cells are numbered from left to right from 1 to n.
Output

Print a single integer � the number of such Bob's first move, after which you can be sure that Alice lied. 
Bob's moves are numbered from 1 to m in the order the were made. If the sought move doesn't exist, then print "-1".
Sample test(s)
Input

11 3 3
5
4 8 6 1 11

Output

3

Input

5 1 3
2
1 5

Output

-1

Input

5 1 3
1
3

Output

1*/
package com.practice.algo.and.ds.binarysearch;
import java.util.Scanner;
import java.util.TreeSet;


public class ClassPiD {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		int a = in.nextInt();
		int m = in.nextInt();
		int cap = (n+1)/(a+1);
		TreeSet<Integer> set = new TreeSet<Integer>();
		set.add(-1);
		set.add(n);
		for(int i=0; i<m; i++){
			int x = in.nextInt()-1;
			int l = set.lower(x);
			int r = set.higher(x);
			set.add(x);
			int scap = (r-l)/(a+1);
			int tcap = (r-x)/(a+1) + (x-l)/(a+1);
			cap = cap - (scap - tcap);
			if(cap < k){
				System.out.println(i+1);
				return;
			}
		}
		System.out.println(-1);
	}

}
