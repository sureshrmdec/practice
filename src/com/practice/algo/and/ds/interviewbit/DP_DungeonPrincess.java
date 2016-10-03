package com.practice.algo.and.ds.interviewbit;

public class DP_DungeonPrincess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
		DP_DungeonPrincess o = new DP_DungeonPrincess();
		o.calculateMinimumHP(dungeon);
	}

	public int calculateMinimumHP(int[][] dungeon) {
		int m = dungeon.length;
		int n = dungeon[0].length;

		//init dp table
		int[][] h = new int[m][n];

		h[m - 1][n - 1] = Math.max(1 - dungeon[m - 1][n - 1], 1);

		//init last column
		for (int i = m - 2; i >= 0; i--) {
			h[i][n - 1] = Math.max(h[i + 1][n - 1] - dungeon[i][n - 1], 1);
		}

		//init last row
		for (int j = n - 2; j >= 0; j--) {
			h[m - 1][j] = Math.max(h[m - 1][j + 1] - dungeon[m - 1][j], 1);
		}

		//calculate dp table
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				int down = Math.max(h[i + 1][j] - dungeon[i][j], 1);
				int right = Math.max(h[i][j + 1] - dungeon[i][j], 1);
				h[i][j] = Math.min(right, down);
			}
		}

		return h[0][0];}
}