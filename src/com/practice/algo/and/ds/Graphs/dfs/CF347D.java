/*As everyone knows, bears love fish. But Mike is a strange bear; He hates fish! The even more strange thing about him is he has 
an infinite number of blue and red fish.

He has marked n distinct points in the plane. ith point is point (xi,yi). He wants to put exactly one fish in each of these points such that 
the difference between the number of red fish and the blue fish on each horizontal or vertical line is at most 1.

He can't find a way to perform that! Please help him.

 
Input
The first line of input contains integer n (1 <= n <= 2 * 10 pow 5).

The next n lines contain the information about the points, ith line contains two integers xi and yi ,
the ith point coordinates.

It is guaranteed that there is at least one valid answer.
Output

Print the answer as a sequence of  n characters 'r' (for red) or 'b'  (for blue) where ith character denotes the color of the fish in the ith point.

Sample test(s)
Input

4
1 1
1 2
2 1
2 2

Output

brrb

Input

3
1 1
1 2
2 1

Output

brr
*/

package com.practice.algo.and.ds.Graphs.dfs;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class CF347D {

	/**
	 * @param args
	 */
	
	  private static PrintWriter out;
	  
	 public static int N;
	  public static Point[] p;
	  public static HashMap<Integer, LinkedList<Point>> xmp, ymp;
	  
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  Scanner in = new Scanner(System.in);
		    out = new PrintWriter(System.out, true);
		    
		    N = in.nextInt();
		    p = new Point[N];
		    xmp = new HashMap<Integer, LinkedList<Point>>();
		    ymp = new HashMap<Integer, LinkedList<Point>>();
		    for (int i = 0; i < N; i++) {
		      p[i] = new Point(in.nextInt(), in.nextInt(), i);
		      
		      if (!xmp.containsKey(p[i].x)) xmp.put(p[i].x, new LinkedList<Point>());
		      xmp.get(p[i].x).add(p[i]);
		      
		      if (!ymp.containsKey(p[i].y)) ymp.put(p[i].y, new LinkedList<Point>());
		      ymp.get(p[i].y).add(p[i]);
		    }
		    
		    for (int i = 0; i < N; i++) {
		      if (!p[i].used) {
		        dfs(i, true, 'r');
		        dfs(i, false, 'r');
		      }
		    }
		    char[] res = new char[N];
		    for (int i = 0; i < N; i++) res[i] = p[i].color;
		    out.println(new String(res));
		    out.close();
		    System.exit(0);
		  }
		  
		  public static void dfs(int i, boolean x, char c) {
		    p[i].used = true;
		    p[i].color = c;
		    char nc = c == 'r' ? 'b' : 'r';
		    if (x) {
		      while (xmp.get(p[i].x).size() > 0) {
		        Point q = xmp.get(p[i].x).removeFirst();
		        if (q.used) continue;
		        dfs(q.id, false, nc);
		        return;
		      }
		    } else {
		      while (ymp.get(p[i].y).size() > 0) {
		        Point q = ymp.get(p[i].y).removeFirst();
		        if (q.used) continue;
		        dfs(q.id, true, nc);
		        return;
		      }
		    }
		  }
		  
		  static class Point {
			    public int x,y,id;
			    public char color;
			    public boolean used;
			    
			    public Point(int x, int y, int id) {
			      this.x = x;
			      this.y = y;
			      this.id = id;
			      this.used = false;
			      this.color = ' ';
			    }
			  }
	}

