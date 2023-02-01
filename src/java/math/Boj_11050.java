package java.math;

import java.util.Scanner;

public class Boj_11050 {

	private static int[][] dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int k = sc.nextInt();
		dp = new int[N+1][k+1];

		System.out.println(dp(N, k));

	}

	private static int dp(int N, int k) {
		if(dp[N][k] > 0) {
			return dp[N][k];
		}

		if(N == k || k == 0) {
			return dp[N][k] = 1;
		}

		return dp[N][k] = dp(N - 1, k - 1) + dp(N - 1, k);
	}

	private static int factorial(int n) {
		if(n == 0 || n == 1)
			return 1;
		else
			return factorial(n-1) * n;
	}

}
