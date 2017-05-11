package com.practice.algo.and.ds.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
//Not Complete
public class Graphs_SteppingNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graphs_SteppingNumbers o = new Graphs_SteppingNumbers();
		System.out.println(o.getSteppingNumbers(10,20));
	}

	public ArrayList<Integer> getSteppingNumbers(int s,int e){
		ArrayList<Integer> result = new ArrayList<>();
		for(int i =0;i<10;i++){
			bfs(i,s,e,result);
		}
		Collections.sort(result);
		return result;
	}


	private void bfs(int i,int s, int e,ArrayList<Integer> result) {

		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);		
		while(!queue.isEmpty()){
			int c = queue.poll();
			
			if(c<=e && c>=s){
				result.add(c);
			}
			if(c>e || c==0){
				continue;
			}
			int rem = c%10;
			if(rem==0){
				queue.add(c*10+(rem+1));
			}else if(rem==9){
				queue.add(c*10+(rem-1));
			}else{
				queue.add(c*10+(rem+1));
				queue.add(c*10+(rem-1));
			}
		}
	}

}
