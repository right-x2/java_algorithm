package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj3109 {
	public static int[][] arr;
	public static int[][] chk;
	public static int[] dy = {-1,0,1};
	public static int[] dx = {1,1,1};
	public static int n,m,ans;
	public static int solve(int a, int b, int cnt) {
		if(a==n)
			return 0;
		if(b==m-1) {
			cnt++;
			if(cnt>ans) {
				ans = cnt;
			}
			if(a<n&&cnt+(n-(a+1))>ans) {
				solve(a+1,0,cnt);
			}
			return 0;
		}
		
		for(int i = 0; i < 3; i++) {
			if(dy[i]+a>=0&&dy[i]+a<n&&dx[i]+b>=0&&dx[i]+b<m&&arr[dy[i]+a][dx[i]+b]==0&&chk[dy[i]+a][dx[i]+b]==0) {
				chk[dy[i]+a][dx[i]+b] = 1;
				solve(dy[i]+a, dx[i]+b, cnt);
				
			}
		}
		
		return 0;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		chk = new int[n][m];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				if(str.charAt(j)=='.') {
					arr[i][j] = 0;
				}else {
					arr[i][j] = 1;
				}
				
			}
		}
		
		for(int i = 0; i < n; i++) {
			if(ans>=n-i)
				break;
			if(chk[i][0]==0) {
				chk[i][0] = 1;
				solve(i,0,0);				
			}
		}
		System.out.println(ans);
	}
}
