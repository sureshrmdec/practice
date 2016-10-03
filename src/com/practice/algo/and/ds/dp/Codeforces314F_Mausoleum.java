package com.practice.algo.and.ds.dp;

import java.util.Arrays;
import java.util.Scanner;

public class Codeforces314F_Mausoleum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TaskE().solve();
	}

}
class Req {
	int x, y;
	String sign;
	Req(int x, int y, String sign) {
		this.x = x;
		this.y = y;
		this.sign = sign;
	}
}
class TaskE {
	int n, K;
	Req[] req;
	long[][] dp;

	void solve() {
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		K = in.nextInt();
		req = new Req[K];

		for (int i = 0; i < K; i++) {
			int x = in.nextInt();
			String sign = in.next();
			int y = in.nextInt();
			req[i] = new Req(x, y, sign);
		}
		
		dp = new long[2*n+2][];
		for (int i = 0; i < 2*n+2; i++) {
			dp[i] = new long[2*n+2];
			Arrays.fill(dp[i], -1);
		}

		long ans = 0;
		for (int i = 1; i <= n * 2 - 1; i++) {
			ans += DP(i, i+1);
		}


		System.out.println(ans);
	}

	long DP(int i, int j) {
		if (i == 0 && j == 2 * n + 1)
			return 1;

		if (i < 0 || j < 0 || i > 2 * n + 1 || j > 2 * n + 1)
			return 0;

		if (dp[i][j] != -1)
			return dp[i][j];

		boolean ll = true,
				lr = true,
				rr = true;

		if (i + 1 == j)
			ll = rr = false;
		if (i <= 1)
			ll = false;
		if (j >= n * 2)
			rr = false;

		for (int k = 0; k < K; k++) {
			ll = ll && ok(i, j, i-1, i, k);
			lr = lr && ok(i, j, i, j, k);
			rr = rr && ok(i, j, j, j+1, k);
		}
		long ret = 0;
		if (ll)
			ret += DP(i-2, j);
		if (lr)
			ret += DP(i-1, j+1);
		if (rr)
			ret += DP(i, j+2);

		return dp[i][j] = ret;
	}

	boolean ok(int i, int j, int ii, int jj, int k) {
		int x = req[k].x, y = req[k].y;
		String sign = req[k].sign;

		if (ii <= 0 || jj <= 0)
			return false;
		if (ii > n * 2 || jj > n * 2)
			return false;

		int vx = (x == ii || x == jj) ? 0 : (x > i && x < j ? 1 : -1);
		int vy = (y == ii || y == jj) ? 0 : (y > i && y < j ? 1 : -1);
		
		if (vx == 1 && vy == 1 || vx == -1 && vy == -1)
			return true;

		if (sign.equals("<"))
			return vx < vy;
		if (sign.equals(">"))
			return vx > vy;
		if (sign.equals("="))
			return vx == vy;
		if (sign.equals("<="))
			return vx <= vy;
		if (sign.equals(">="))
			return vx >= vy;

		return true;
	}
}