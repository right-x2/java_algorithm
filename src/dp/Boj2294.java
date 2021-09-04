package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2294 {

	public static int[][] dp;
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dp = new int[n+1][m+1];
		arr = new int[n+1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			if(a>m)
				continue;
			arr[i] = a;
			dp[i][arr[i]] = 1;
		}
		
		for(int i = 1; i <= n; i ++) {
			int num = arr[i];
			for(int j = 0; j <= m;j++) {
				if(j==num)
					continue;
				dp[i][j] = dp[i-1][j];
			}
			for(int j = 1; j <=m;j++) {
				if(num+j<=m&&dp[i][j]>0&&(dp[i][num+j]==0||dp[i][num+j]>dp[i][j]+1))
					dp[i][num+j] = dp[i][j]+1;
			}
		}
		if(dp[n][m]==0)
			System.out.println(-1);
		else
			System.out.println(dp[n][m]);
		

	}
	
	

}
