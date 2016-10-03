package com.practice.algo.and.ds.Graphs.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class CareercupBloomber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] arr = new int[3][3];
		int k = 0;
		for(int i=0;i<3;i++){
			for(int j=0;j<3;j++){
				arr[i][j] = k;
				k++;
			}
		}
		int i=0;int j=0;
		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(i,j,null));
		int[] dx = {0,-1,1};
		int[] dy = {1,0,1};
		while(!q.isEmpty()){
			Point p = q.poll();
			if(p.x==arr.length && p.y==arr[0].length){
				while(p.parent==null){
					System.out.println(p);
				}
			}
			for(int d=0;d<3;d++){
				i+=dx[d];
				j+=dy[d];
				if(i<0 || j<0 || i >arr.length-1 || j>arr.length-1 ){
					continue;
				}else{
					Point np = new Point(i,j,p);
					q.add(np);
				}
			}
		}
		
		
	}

}

class Point{
	int x;
	int y;
	Point parent;
	public Point(int x, int y,Point parent) {
		super();
		this.x = x;
		this.y = y;
		this.parent = parent;
	}
	@Override
	public String toString() {
		
		System.out.println(x+y+">>");
		
		return super.toString();
	}
}