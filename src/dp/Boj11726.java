package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj11726 {
	public static int[] dp;
	public static int solve(int num) {
		if(dp[num]>0)
			return dp[num];
		if(num<=1)
			return 1;
		dp[num] = (solve(num-1)+solve(num-2))%10007;
		return dp[num];
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		dp = new int[n+1];
		System.out.println(solve(n));
	}

}
