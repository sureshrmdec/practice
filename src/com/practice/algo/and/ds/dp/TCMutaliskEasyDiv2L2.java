package com.practice.algo.and.ds.dp;

public class TCMutaliskEasyDiv2L2 {

	/*	Fox Ciel is writing an AI for the game Starcraft and she needs your help.
	In Starcraft, one of the available units is a mutalisk. Mutalisks are very useful for harassing Terran bases. Fox Ciel has one mutalisk. 
	The enemy base contains one or more Space Construction Vehicles (SCVs). Each SCV has some amount of hit points.

	When the mutalisk attacks, it can target up to three different SCVs.

	    The first targeted SCV will lose 9 hit points.
	    The second targeted SCV (if any) will lose 3 hit points.
	    The third targeted SCV (if any) will lose 1 hit point.

	If the hit points of a SCV drop to 0 or lower, the SCV is destroyed. Note that you may not target the same SCV twice in the same attack.

	You are given a int[] HP containing the current hit points of your enemy's SCVs. Return the smallest number of attacks in which 
	you can destroy all these SCVs.

	Definition

	Class:	MutaliskEasy
	Method:	minimalAttacks
	Parameters:	int[]
	Returns:	int
	Method signature:	int minimalAttacks(int[] x)
	(be sure your method is public)


	Constraints
	-	x will contain between 1 and 3 elements, inclusive.
	-	Each element in x will be between 1 and 60, inclusive.

	Examples
	0)	
	{12,10,4}

	Returns: 2

	You can destroy all SCVs in two attacks as follows:

	    Target the SCVs in the order 0, 2, 1. Their hit points after the attack will be {12-9, 10-1, 4-3} = {3, 9, 1}.
	    Target the SCVs in the order 1, 0, 2. Their hit points will drop exactly to {0, 0, 0}.

	1)	


	{54,18,6}

	Returns: 6

	You should attack 6 times, always in the order 0, 1, 2.
	2)	


	{55,60,53}

	Returns: 13

	3)	


	{1,1,1}

	Returns: 1

	4)	


	{60, 40}

	Returns: 9

	5)	


	{60}

	Returns: 7*/

	public static void main(String[] args) {
		int[] x = {12,10,4};
		TCMutaliskEasyDiv2L2 t = new TCMutaliskEasyDiv2L2();
		System.out.println(t.minimalAttacks(x));

	}
	int[][][] dp = new int[61][61][61];
	private static final int MAX_HP = 60;
	private int minimalAttacks(int[] xx){

		for (int i = 0; i <= MAX_HP; i++)  {
			for (int j = 0; j <= MAX_HP; j++)  {
				for (int k = 0; k <= MAX_HP; k++)  {
					dp[i][j][k] = Integer.MAX_VALUE;
				}
			}
		}
		//dp[xx[0]][xx[1]][xx[2]] = 0;
		minimalAttacks(xx[0], xx[1], xx[2]);
		return 0;
	}
	int ans = 0;
	int[] ATTACKS = {9,3,1};
	int minAttacks = 0;
	private int minimalAttacks(int xx,int yy,int zz){

		//		 Don't allow values to go below 0.
		if (xx < 0) xx = 0;
		if (yy < 0) yy = 0;
		if (zz < 0) zz = 0;

		if (dp[xx][yy][zz] != Integer.MAX_VALUE ) {
			return dp[xx][yy][zz];
		}


		
		int newx = 0;
		int newy = 0;
		int newz = 0;
		for(int i=0;i<ATTACKS.length;i++){
			for(int j=0;j<ATTACKS.length;j++){
				if (j == i) continue;
				for(int k=0;k<ATTACKS.length;k++){
					if ((k == i) || (k == j))  continue;
					newx = xx-ATTACKS[i];
					newy = yy-ATTACKS[j];
					newz = zz-ATTACKS[k];
					if (newx < 0) newx = 0;
					if (newy < 0) newy = 0;
					if (newz < 0) newz = 0;
					dp[newx][newy][newz] = Math.min(1 + dp[xx][yy][zz],dp[newx][newy][newz]); 
					minAttacks = minimalAttacks(newx,newy,newz);

				}	
			}	
		}
//		dp[xx][yy][zz] = dp[newx][newy][newz] + 1;
		return minAttacks + 1;

	}
}
