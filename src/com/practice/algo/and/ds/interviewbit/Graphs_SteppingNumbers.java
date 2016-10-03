package com.practice.algo.and.ds.interviewbit;

import java.util.ArrayList;
//Not Complete
public class Graphs_SteppingNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graphs_SteppingNumbers o = new Graphs_SteppingNumbers();
		System.out.println(Math.floor(Math.log10(654) + 1));
		o.getSteppingNumbers(10, 20);
		Math.floor(Math.log10(21) + 1);
	}

	public ArrayList<Integer> getSteppingNumbers(int s,int e){
		ArrayList<Integer> res = new ArrayList<>();
			for(int i=s;i<=e;i++){
				dfs(s,e,i);
			}

		return res;
	}

	//343 and 545
	private void dfs(int s, int e,int i) {
		if(i>=s && i<=e){
			
		}
		
		int last = i%10;
		if(last==0){
			dfs(s,e,(i*10)+(1));
		}else if(last==9){
			dfs(s,e,(i*10)+(8));
		}else{
		int back = (i*10)+(last-1);
		int next = (i*10)+(last+1);
		dfs(s,e,back);
		dfs(s,e,next);
		}
		
	}
}
