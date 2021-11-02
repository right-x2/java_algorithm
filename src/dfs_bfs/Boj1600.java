package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



public class Boj1600 {
	
	static class Point{
		int y;
		int x;
		int cnt;
		int tot;
		public Point(int y, int x, int cnt, int tot) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.tot = tot;
		}
	}
	
	
	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,1,0,-1};
	public static int[] sy = {-2,-1,1,2,2,1,-1,-2};
	public static int[] sx = {1,2,2,1,-1,-2,-2,-1};
	public static int[][] arr;
	public static int[][][]chk;
	public static int k,m,n,ans = -1;
	
	
	
	public static int bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(0,0,0,0));
		chk[0][0][0] = 1;
		while(q.size()>0) {
			int y = q.peek().y;
			int x = q.peek().x;
			int cnt = q.peek().cnt;
			int tot = q.peek().tot;
			q.poll();
			if(y==n-1&&x==m-1) {
				ans = tot;
				break;
			}
			for(int i = 0; i <4; i++) {
				if(dy[i]+y>=0&&dy[i]+y<n&&dx[i]+x>=0&&dx[i]+x<m&&arr[dy[i]+y][dx[i]+x]==0&&chk[cnt][dy[i]+y][dx[i]+x]==0) {
					chk[cnt][dy[i]+y][dx[i]+x] = 1;
					q.add(new Point(dy[i]+y,dx[i]+x,cnt,tot+1));
				}
			}
			
			for(int i = 0; i <8; i++) {
				if(cnt+1<=k) {
					if(sy[i]+y>=0&&sy[i]+y<n&&sx[i]+x>=0&&sx[i]+x<m&&arr[sy[i]+y][sx[i]+x]==0&&chk[cnt+1][sy[i]+y][sx[i]+x]==0) {
						chk[cnt+1][sy[i]+y][sx[i]+x] = 1;
						q.add(new Point(sy[i]+y,sx[i]+x,cnt+1,tot+1));
					}				
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		k = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		arr = new int[n][m];
		chk = new int[k+1][n][m];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		bfs();
		System.out.println(ans);
	}
}
