package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BojTest {

	public static int[][] chk;
	public static int[][] arr;
	public static int []dy = {-1,0,1,0};
	public static int []dx = {0,1,0,-1};
	public static int n,m;
	static class P{
		int y;
		int x;
		public P(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	
	public static int bfs(int a, int b) {
		chk[a][b] = 1;
		
		Queue<P> q = new LinkedList<>();
		q.add(new P(a,b));
		
		while(q.size()>0) {
			P p = q.poll();
			int y = p.y;
			int x = p.x;
			
			for(int i = 0; i < 4; i++) {
				if(y+dy[i]>=0&&y+dy[i]<n&&x+dx[i]>=0&&x+dx[i]<m&&arr[y+dy[i]][x+dx[i]]==1&&chk[y+dy[i]][x+dx[i]]==0) {
					chk[y+dy[i]][x+dx[i]]=1;
					q.add(new P(y+dy[i],x+dx[i]));
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int ans = 0;
		chk = new int[n][m];
		arr = new int[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i = 0; i < n; i++) {
			for(int j=0;j<m;j++) {
				if(chk[i][j]==0&&arr[i][j]==1) {
					ans++;
					bfs(i,j);
				}
			}
		}
	}

}
