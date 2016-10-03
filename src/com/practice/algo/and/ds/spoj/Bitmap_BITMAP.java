package com.practice.algo.and.ds.spoj;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Bitmap_BITMAP {

	int[][] bitmap;
	int[][] res;
	boolean[][] vis;
	BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

	PrintWriter out = new PrintWriter(new BufferedOutputStream(System.out));
	
	public static void main(String[] args) throws IOException {
		new Bitmap_BITMAP().run();
	}

	void run() throws IOException {
		int testcases = Integer.parseInt(in.readLine());
		while (testcases-- > 0)
			solve();
		out.flush();
	}
	int n,m;
	void solve() throws IOException {
		StringTokenizer tokenizer = new StringTokenizer(in.readLine());
		n = Integer.parseInt(tokenizer.nextToken());
		m = Integer.parseInt(tokenizer.nextToken());
		bitmap = new int[n][m];
		res = new int[n][m];
		
		List<Point> list = new ArrayList<Point>();
		for (int i = 0; i < n; i++){
			String[] sa = new String[m];
			if (!tokenizer.hasMoreTokens()){
                String str = new String(in.readLine());
                sa =  str.split("");
                
			}
			Arrays.fill(res[i], Integer.MAX_VALUE);
			for (int j = 1; j <= m; j++){
				bitmap[i][j-1] = Integer.parseInt(sa[j]);
				if(bitmap[i][j-1] == 1){
					list.add(new Point(i,j-1,0));
					res[i][j-1] = 0;
				}
			}
			
		}
		for (int i = 0; i < list.size(); i++){
			vis = new boolean[n][m];
				bfs(list.get(i));
		}
		

		//out.println(binarySearch(cows, stallPositions));
	}
	private void bfs(Point p){
		
		Queue<Point> q = new LinkedList<Point>();
		q.add(p);
		vis[p.x][p.y] = true;
		int[] dx = {-1,1,0,0};
		int[] dy = {0,0,-1,1};
		while(!q.isEmpty()){
			Point pp = q.poll();
			for(int i=0;i<4;i++){
				int newx = pp.x+dx[i];
				int newy = pp.y+dy[i];
				if(newx<0 || newx>=n || newy<0 || newy>=m || bitmap[newx][newy]==1 ){
					continue;
				}
				if(!vis[newx][newy]){
					q.add(new Point(newx,newy,pp.d+1));
					if(pp.d+1<res[newx][newy]){
						res[newx][newy] = pp.d+1;
					}
					vis[newx][newy] = true;
				}
			}
		}
	}
}
class Point{
	int x;
	int y;
	int d;
	public Point(int x, int y,int d) {
		super();
		this.x = x;
		this.y = y;
		this.d = d;
	}
	
}