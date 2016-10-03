package com.practice.algo.and.ds.Graphs.dfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class GrafixMaskTCSRM211 {

	/**
	 * @param args
	 */


	/*	Note: This problem statement includes images that may not appear if you are using a plugin. For best results, 
	 * use the Arena editor.

	In one mode of the grafix software package, the user blocks off portions of a masking layer using opaque 
	rectangles. The bitmap used as the masking layer is 400 pixels tall and 600 pixels wide. Once the rectangles
	 have been blocked off, the user can perform painting actions through the remaining areas of the masking layer,
	  known as holes. To be precise, each hole is a maximal collection of contiguous pixels that are not covered by
	   any of the opaque rectangles. Two pixels are contiguous if they share an edge, and contiguity is transitive
	   .

	You are given a String[] named rectangles, the elements of which specify the rectangles that have been blocked 
	off in the masking layer. Each String in rectangles consists of four integers separated by single spaces, with
	 no additional spaces in the string. The first two integers are the window coordinates of the top left 
 in the given rectangle, and the last two integers are the window coordinates of its bottom right pixel. 
 The window coordinates of a pixel are a pair of integers specifying the row number and column number of the pixel,

  in that order. Rows are numbered from top to bottom, starting with 0 and ending with 399. Columns are numbered
   from left to right, starting with 0 and ending with 599. Every pixel within and along the border of the
    rectangle defined by these opposing corners is blocked off.

	Return a int[] containing the area, in pixels, of every hole in the resulting masking area, sorted 
	from smallest area to greatest. 	
	 */	public static void main(String[] args) {
		 // TODO Auto-generated method stub
		 String[] rectangles = {"48 192 351 207", "48 392 351 407", "120 52 135 547", "260 52 275 547"};
		 GrafixMaskTCSRM211 g = new GrafixMaskTCSRM211();
		 g.sortedAreas(rectangles);
	 }
	 public List<Integer> sortedAreas(String[] rectangles){
		 List<Integer> res = new ArrayList<Integer>();
		 boolean[][] mask = new boolean[400][600];
		 for(int i =0;i<rectangles.length;i++){
			 String rectangle = rectangles[i];
			 String[] dimensions = rectangle.split(" ");
			 Integer r1 = new Integer(dimensions[0]);
			 Integer c1 = new Integer(dimensions[1]);
			 Integer r2 = new Integer(dimensions[2]);
			 Integer c2 = new Integer(dimensions[3]);
			 for(int r=r1;r<=r2;r++){
				 for(int c=c1;c<=c2;c++){
					 mask[r][c] = true;;
				 }	 
			 }
		 }
		 for(int i=0;i<400;i++){
			 for(int j=0;j<600;j++){
				 int result=0;
				 if(mask[i][j]==false){
					 Stack<Node> stack = new Stack<Node>();
					 stack.push(new Node(i,j));
					 
					 while(!stack.isEmpty()){
						 Node top = stack.pop();
						 // Check to ensure that we are within the bounds of the grid, if not, continue
						 if (top.x < 0 || top.x >= 400) continue;
						 // Similar check for y
						 if (top.y < 0 || top.y >= 600) continue;
						 // Check that we haven't already visited this position, as we don't want to count it twice
						 if (mask[top.x][top.y]) {
							 continue;
						 }
						 mask[top.x][top.y] = true; // Record that we have visited this node

						 // We have found this node to be empty, and part
						 // of this connected area, so add 1 to the result
						 result++;
						 // Now we know that we have at least one empty square, then we will attempt to
						 // visit every node adjacent to this node.
						 stack.push(new Node(top.x + 1, top.y));
						 stack.push(new Node(top.x - 1, top.y));
						 stack.push(new Node(top.x, top.y + 1));
						 stack.push(new Node(top.x, top.y - 1));
					 }
					 res.add(result);
				 }
				 
			 }
		 }
		 Collections.sort(res);
		 return res;
	 }
}
class Node{
	int x;int y;
	Node(int x,int y){
		this.x=x;
		this.y=y;
	}
}