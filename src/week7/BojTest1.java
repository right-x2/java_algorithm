package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import week7.BojTest.P;

public class BojTest1 {
	public static int[][][] chk;
	public static int[][] arr;
	public static int []dy = {-1,0,1,0};
	public static int []dx = {0,1,0,-1};
	public static int n,m;
	public static int ans = -1;
	
	static class P{
		int y;
		int x;
		int flag;
		int cnt;
		public P(int y, int x, int flag, int cnt) {
			this.y = y;
			this.x = x;
			this.flag = flag;
			this.cnt = cnt;
		}
	}
	
	public static int bfs(int a, int b) {
		Queue<P> q = new LinkedList<>();
		q.add(new P(a,b,0,0));
		
		while(q.size()>0) {
			P p = q.poll();
			int y = p.y;
			int x = p.x;
			int flag = p.flag;
			int cnt = p.cnt;
			
			if(y==n-1&&x==m-1) {
				ans = cnt;
				break;
			}
			for(int i = 0; i < 4; i++) {
				if(flag==0) {
					if(y+dy[i]>=0&&y+dy[i]<n&&x+dx[i]>=0&&x+dx[i]<m) {
						if(arr[y+dy[i]][x+dx[i]]==1) {
							if(chk[1][y+dy[i]][x+dx[i]]==0) {
								chk[1][y+dy[i]][x+dx[i]] = 1;
								q.add(new P(y+dy[i],x+dx[i],1,cnt+1));
							}
						}else {
							if(chk[0][y+dy[i]][x+dx[i]]==0&&arr[y+dy[i]][x+dx[i]]==0) {
								chk[0][y+dy[i]][x+dx[i]] = 1;
								q.add(new P(y+dy[i],x+dx[i],0,cnt+1));
							}
						}
					}
				}else {
					if(y+dy[i]>=0&&y+dy[i]<n&&x+dx[i]>=0&&x+dx[i]<m&&arr[y+dy[i]][x+dx[i]]==0&&chk[0][y+dy[i]][x+dx[i]]==0) {
						chk[0][y+dy[i]][x+dx[i]] = 1;
						q.add(new P(y+dy[i],x+dx[i],0,cnt+1));
					}					
				}
			}			
		}

		return 0;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		chk = new int[2][n][m];
		arr = new int[n][m];
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			for(int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		bfs(0,0);
		System.out.println(ans);
	}
}
