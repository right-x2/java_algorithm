package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj14940 {
	public static int[][] arr;
	public static int[][] ans;
	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,1,0,-1};
	static class P{
		int y;
		int x;
		public P(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		ans = new int[n][m];
		int a = 0,b = 0;
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) {
					a = i;
					b = j;
				}
			}
		}
		Queue<P> q = new LinkedList<>();
		q.add(new P(a,b));
		while(q.size()>0) {
			int y = q.peek().y;
			int x = q.peek().x;
			int cnt = ans[y][x];
			q.poll();
			
			for(int i = 0; i < 4; i++) {
				if(dy[i]+y>=0&&dy[i]+y<n&&dx[i]+x>=0&&dx[i]+x<m&&ans[dy[i]+y][dx[i]+x]==0&&arr[dy[i]+y][dx[i]+x]==1) {
					ans[dy[i]+y][dx[i]+x] = cnt + 1;
					q.add(new P(dy[i]+y,dx[i]+x));
				}
			}
		}
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(ans[i][j]==0&&arr[i][j]==1)
					ans[i][j] = -1;
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}
}
