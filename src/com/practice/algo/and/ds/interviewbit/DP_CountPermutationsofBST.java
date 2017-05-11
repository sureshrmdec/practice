package com.practice.algo.and.ds.interviewbit;

import java.util.Arrays;

public class DP_CountPermutationsofBST {

	public static void main(String[] args) {
		DP_CountPermutationsofBST o = new DP_CountPermutationsofBST();
		System.out.println(o.cntPermBST(7,6));

	}
	static int[][] combinations = new int[51][51];
	public int cntPermBST(int A, int B) {
		if(B>=A)
			return 0;
		int[][] dp = new int[A+1][B+1];

		dp[1][0] = 1;
		dp[2][1] = 2;
		//i is number of nodes and j is height
		for(int i=3;i<=A;i++){
			for(int j=1;j<=B;j++){

				//height possible
				int maxElementsforThatHeight = (int)Math.pow(2, j+1) -1 ;
				if(i>maxElementsforThatHeight){
					dp[i][j] = -1;
					continue;
				}

				int m = (i%2==0)?i/2:i/2+1;

				for(int k=1;k<=m;k++){
					//Make root k
					int leftSide = k-1; 
					int rightSide = i-k;

					//height possible
					int maxElementsforThatHeightL = (int)Math.pow(2, j+1) -1 ;
					if(leftSide>maxElementsforThatHeight)
						continue;

					int interim = 0;
					int totalPossiblePlacesForLeftToInsert = rightSide + 1;

					int leftprevious = dp[leftSide][j-1];
					int rightprevious = dp[rightSide][j-1];
					if(leftprevious==-1 || rightprevious == -1)
						continue;

					int multiply = 0;

					if(leftSide==0){
						dp[i][j] += rightprevious*2;
					}else if(rightSide==0){
						dp[i][j] += leftprevious*2;
					}else{
						//	if((leftprevious==0 && leftSide>0) || (leftSide==0))leftprevious=1;
						//	if((rightprevious==0 && rightSide>0) || (leftSide==0))rightprevious=1;
						if(leftprevious==0 && rightprevious==0)
							continue;

						if(leftprevious==0){
							int maxPartitions = leftSide -1;
							for(int l=1;l<=leftSide;l++){
								int lefty = combinations[maxPartitions][l]==0?1:combinations[maxPartitions][l-1];
								interim += combinations[totalPossiblePlacesForLeftToInsert][l]*lefty;
							}
														
							dp[i][j] += interim* (leftSide*rightprevious) *2;
						}
						else if(rightprevious==0){
							int maxPartitions = leftSide -1;

							for(int l=1;l<=leftSide;l++){
								int lefty = combinations[maxPartitions][l]==0?1:combinations[maxPartitions][l-1];
								interim += combinations[totalPossiblePlacesForLeftToInsert][l]*lefty;
							}
							dp[i][j] += interim*leftprevious *2;
						}
						else{
							multiply = leftprevious*rightprevious;
							int maxPartitions = leftSide -1;
							for(int l=1;l<=leftSide;l++){
								int lefty = combinations[maxPartitions][l]==0?1:combinations[maxPartitions][l-1];
								interim += combinations[totalPossiblePlacesForLeftToInsert][l]*lefty;
							}

							if(i%2!=0 && k==m)
								dp[i][j] += interim*multiply;
							else
								dp[i][j] += interim*multiply*2;
						}


					}



				} 


			}	
		}
		return dp[A][B]==-1?0:dp[A][B];
	}

	static{ 
		combinations[0][0]=1;
		combinations[1][0]=1;
		combinations[1][1]=1;
		for(int i=2;i<=50;i++){
			combinations[i][0]=1;
			for(int j=1;j<=i;j++){
				combinations[i][j]=combinations[i-1][j-1]+combinations[i-1][j];
			}	
		}
	}

}
