package com.practice.algo.and.ds.graph;

import java.util.LinkedList;
import java.util.Queue;

/*22.2-7
There are two types of professional wrestlers: “babyfaces” (“good guys”) and “heels” (“bad guys”). 
Between any pair of professional wrestlers, there may or may not be a rivalry. Suppose we have n professional wrestlers 
and we have a list of r pairs of wrestlers for which there are rivalries. Give an O.n C r/-time algo
- rithm that determines whether it is possible to designate some of the wrestlers as babyfaces and
the remainder as heels such that each rivalry is between a babyface and a heel. If it is possible to
perform such a designation, your algorithm should produce it.
 */

//Bipartite graphs can’t contain odd cycles:
public class Cormen_Wrestlers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] riv = {"2,3","1,4","1,4","2,3","6,7","5,8","5,9","6,9","7,8"};
		partition(riv,9);


	}
	static int[] colorA ;
	static int[][] graph;
	private static void partition(String[] riv,int totalWrestlers) {
		graph = new int[totalWrestlers+1][totalWrestlers+1];
		colorA = new int[totalWrestlers+1];
		for(int i=1;i<=riv.length;i++){
			String[] split = riv[i-1].split(",");
			for(int l=0;l<split.length;l++){
				int k = Integer.parseInt(split[l]);
				graph[i][k] = 1;	
			}

		}



		for(int i=1;i<colorA.length;i++){
			if(colorA[i]==0){
				if(!bfs(i,1)){
					System.out.println("Can not partition");
				}
			}
		}

	}

	static boolean bfs(int node,int color){

		Queue<Integer> queue = new LinkedList<>();
		queue.add(node);
		colorA[node] = color;
		while(!queue.isEmpty()){
			int top = queue.poll();
			int topColor = colorA[top];
			for(int j=1;j<graph.length;j++){
				//if there is an edge i.e. rivalry
				if(top==j)
					continue;
				if(graph[top][j]==1){
					if(colorA[j]==topColor){
						System.out.println("Not Possible");
						return false;
					}
					if(colorA[j]==0){
						colorA[j] = 3-topColor;
						queue.add(j);
					}
				}
			}
		}

		return true;

	}



}
