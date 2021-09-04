package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Study{
	int a;
	int b;
	public Study(int a, int b) {
		this.a = a;
		this.b = b;
	}
}
public class Boj14728 {
	public static int[][] dp;
	public static Study[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		dp = new int[n+1][m+1];
		arr = new Study[n+1];
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			arr[i] = new Study(a,b);
		}
		
		for(int i = 1; i <= n; i ++) {
			int t = arr[i].a;
			int v = arr[i].b;
			for(int j = 0; j <= m;j++)
				dp[i][j] = dp[i-1][j];
			for(int j = 0; j <=m;j++) {
				if(t+j>m)
					break;
				
				if(dp[i][t+j]<dp[i-1][j]+v)
					dp[i][t+j] = dp[i-1][j]+v;
			}
		}
		System.out.println(dp[n][m]);
	}
}
