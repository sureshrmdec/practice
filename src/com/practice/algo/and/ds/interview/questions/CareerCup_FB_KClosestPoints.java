package com.practice.algo.and.ds.interview.questions;

public class CareerCup_FB_KClosestPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	class Point implements Comparable<Point> {
	    int x, y;
	    double dist;

	    public Point(int x, int y, Point originPoint) {
	        this.x = x;
	        this.y = y;
	        this.dist = Math.hypot(x - originPoint.x, y - originPoint.y);
	    }

	    public Point(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }

	    @Override
	    public int compareTo(Point that) {
	        return Double.valueOf(that.dist).compareTo(dist);
	    }

	    @Override
	    public String toString() {
	        return "x: " + x + " y: " + y;
	    }
	}
}
