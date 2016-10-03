package com.practice.algo.and.ds.Tree.SegementTree;

import java.io.PrintWriter;
import java.io.Reader;
import java.util.Scanner;

//http://codeforces.com/blog/entry/18051. This is very nice tutorial on Segement trees and it does not include any recursion and finding middle etc.

/*General idea is the following. If l, the left interval border, is odd (which is equivalent to l&1) then l is the right child of its parent.
Then our interval includes node l but doesn't include it's parent. So we add t[l] and move to the right of l's parent by setting l = (l + 1) / 2. 
If l is even, it is the left child, and the interval includes its parent as well (unless the right border interferes),
so we just move to it by setting l = l / 2. Similar argumentation is applied to the right border. We stop once borders meet.

No recursion and no additional computations like finding the middle of the interval are involved, we just go through all the nodes we need, so this is very efficient.

*							1,14
*				2,7						3,7
*		4,5				5,2		6,3				7,4
* 8,2           9,3
* 
* where (index,data)
*
*/

//Input data should be at leaves only
public class SegementTreeNonRecursive {

	//array size
	static int n;
	static int[] t;
	private static Reader in;
    private static PrintWriter out;
    static int[] d ;
	public static void main(String[] args) {
		  Scanner sc = new Scanner(System.in);	
		  n = sc.nextInt();
		  d = new int[n];
		  //Height of segment tree 
	      int x = (int) (Math.ceil(Math.log(n) / Math.log(2)));
	      //Maximum size of segment tree
	      int max_size = 2 * (int) Math.pow(2, x) - 1;
	      t = new int[max_size];
	      
		  for (int i = 0; i < n; ++i) 
			   t[n + i] = sc.nextInt();
		  
		  build();
		  modifySingleValue(4, 4);
		  System.out.println(queryIndexOneBased(1,6));
		  //modify Range without Lazy Propogation. Push the changes before query.
		  //modifyRange(1,6, 4);
		  //push();
		  incLP(1, 6, 5);
		  System.out.println(queryLP(1,6));
	}
	public static void build() {  // build the tree
		//for (int i = n - 2; i >= 0; --i)
		for (int i = n - 1; i > 0; --i)
			//t[i] = t[2*i+1] + t[2*i+2];
			t[i] = t[i<<1] + t[i<<1|1];
	}

	public static void modifySingleValue(int p, int value) {  // set value at position p
		for (t[p += n - 1] = value; p > 1; p >>= 1) {
			System.out.println("p " +(p));
			System.out.println("p>>1 " +(p>>1));
			System.out.println("p^1 " +(p^1));
			//p^1 is too good to find the sibling. if suppose p is 12 it will give you 13. 
			//And if it is 13 it will give you 12.
			t[p>>1] = t[p] + t[p^1];	
		}
	}

	//query method index 0 based
	public static int queryIndexZeroBased(int l, int r) {  // sum on interval (l, r)
		int res = 0;
		for (l += n-1, r += n-1; l <= r; l = l/2, r = r/2-1) {
			//if l is the right child
			if ((l&1)==0) res += t[l++];
			//if r is the left child
			if ((r&1)>0) res += t[r--];
		}
		return res;
	}
	
	//query method index 1 based
	public static int queryIndexOneBased(int l, int r) {  // sum on interval (l, r)
		int res = 0;
		for (l += n-1 , r += n-1; l <= r; l >>= 1, r >>= 1) {
			//if l is the right child i.e. l is odd
			if ((l&1)>0) res += t[l++];
			//if r is the left child i.e. r is even
			if ((r&1)==0) res += t[r--];
		}
		return res;
	}	
	
	//modify on interval,single element access
	public static void modifyRange(int l, int r, int value) {
		  for (l += n-1 , r += n-1; l <= r; l >>= 1, r >>= 1) {
			//if l is the right child i.e. l is odd 
		    if ((l&1) > 0) t[l++] += value;
			//if r is the left child i.e. r is even
		    if ((r&1)==0) t[r--] += value;
		  }
		}
	
	public static void push() {
		  for (int i = 1; i < n; ++i) {
		    t[i<<1] += t[i];
		    t[i<<1|1] += t[i];
		    t[i] = 0;
		  }
		}
	
	
	//Lazy Propogation
	
	
	public static void applyLP(int p, int value) {
		  t[p] += value;
		  if (p < n) d[p] += value;
		}

	public static void buildLP(int p) {
		  while (p > 1) {
			  p >>= 1; 
		      t[p] = (t[p<<1]+ t[p<<1|1]) + d[p];
		  }
		}

	public static void pushLP(int p) {
		  for (int s = 4; s > 0; --s) {
		    int i = p >> s;
		    if (d[i] != 0) {
		      applyLP(i<<1, d[i]);
		      applyLP(i<<1|1, d[i]);
		      d[i] = 0;
		    }
		  }
		}

	public static void incLP(int l, int r, int value) {
		  l += n - 1 ; r += n - 1;
		  int l0 = l, r0 = r;
		  for (; l <= r; l >>= 1, r >>= 1) {
		    if ((l&1) > 0) applyLP(l++, value);
		    if ((r&1) == 0) applyLP(--r, value);
		  }
		  buildLP(l0);
		  buildLP(r0 - 1);
		}

	public static int queryLP(int l, int r) {
		  l += n-1; 
		  r += n-1;
		  pushLP(l);
		  pushLP(r - 1);
		  int res = Integer.MIN_VALUE;
		  for (; l < r; l >>= 1, r >>= 1) {
		    if ((l&1) > 0 ) res = Math.max(res, t[l++]);
		    if ((r&1) == 0) res = Math.max(t[--r], res);
		  }
		  return res;
		}
}
