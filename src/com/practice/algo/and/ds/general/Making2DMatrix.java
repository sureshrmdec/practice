package com.practice.algo.and.ds.general;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Making2DMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int totalRows = n + (n-1);
		int[][] op = new int[totalRows][totalRows];
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int x=0;
		int y = 0;
		

	
		int b1 = 0;
		int b2 = totalRows -1;
		for(int i=n;i>=1;i--){
			int change = 0;
			int dir = 0;
			int ddx = dx[dir];
			int ddy = dy[dir];
			int oldx=x;
			int oldy=y;
			while(true){
			op[x][y] = i;
			if(i==1){
				break;
			}
			if((x+ddx==oldx && y+ddy==oldy && change==3) || ((x+ddx)<b1) || ((x+ddx)> b2) || ((y+ddy)<b1) || ((y+ddy)> b2) && change<=3){
				dir = (dir+1) % 4;
				ddx = dx[dir];
				ddy = dy[dir];
				change = change + 1;
			}
			x+=ddx;
			y+=ddy;
			if(change>3){
				b1 +=1;
				b2 -=1;
				break;
			}
			}
		}
		ArrayList<ArrayList<Integer>> aa = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<op.length;i++){
			ArrayList<Integer> a = new ArrayList<Integer>();
			for(int j=0;j<op.length;j++){
			a.add(op[i][j]);
			}
			aa.add(a);
			}
	}
	public ArrayList<ArrayList<Integer>> prettyPrint(int A) {

		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int totalRows = n + (n-1);
		int[][] op = new int[totalRows][totalRows];
		int[] dx = {0,1,0,-1};
		int[] dy = {1,0,-1,0};
		
		int x=0;
		int y = 0;
		

	
		int b1 = 0;
		int b2 = totalRows -1;
		for(int i=n;i>=1;i--){
			int change = 0;
			int dir = 0;
			int ddx = dx[dir];
			int ddy = dy[dir];
			int oldx=x;
			int oldy=y;
			while(true){
			op[x][y] = i;
			if(i==1){
				break;
			}
			if((x+ddx==oldx && y+ddy==oldy && change==3) || ((x+ddx)<b1) || ((x+ddx)> b2) || ((y+ddy)<b1) || ((y+ddy)> b2) && change<=3){
				dir = (dir+1) % 4;
				ddx = dx[dir];
				ddy = dy[dir];
				change = change + 1;
			}
			x+=ddx;
			y+=ddy;
			if(change>3){
				b1 +=1;
				b2 -=1;
				break;
			}
			}
		}
		ArrayList<ArrayList<Integer>> aa = new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<op.length;i++){
			ArrayList<Integer> a = new ArrayList<Integer>();
			for(int j=0;j<op.length;j++){
			a.add(op[i][j]);
			}
			aa.add(a);
			}
	return aa;    
	}
}
