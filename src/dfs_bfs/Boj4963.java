package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Land{
	int y;
	int x;
	
	public Land(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Boj4963 {
	
	public static int[][] arr;
	public static int[][] chk;
	public static int[] dy = {-1,-1,0,1,1,1,0,-1};
	public static int[] dx = {0,1,1,1,0,-1,-1,-1};
	public static int n,m;
	
	public static void bfs(int a, int b) {
		Queue<Land> q = new LinkedList<Land>();
		q.add(new Land(a,b));
		chk[a][b] = 1;
		
		while(q.size()>0) {
			int y = q.peek().y;
			int x = q.peek().x;
			q.poll();
			
			for(int i = 0; i < 8; i++) {
				if(y+dy[i]>=0&&y+dy[i]<n&&x+dx[i]>=0&&x+dx[i]<m&&arr[y+dy[i]][x+dx[i]]==1&&chk[y+dy[i]][x+dx[i]]==0) {
					chk[y+dy[i]][x+dx[i]] = 1;
					q.add(new Land(y+dy[i],x+dx[i]));
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			m = Integer.parseInt(st.nextToken());
			n = Integer.parseInt(st.nextToken());
			int ans = 0;
			
			if(n==0&&m==0) {
				break;
			}
			arr = new int[n][m];
			chk = new int[n][m];
			for(int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < m; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					if(arr[i][j]==1&&chk[i][j]==0) {
						ans++;
						bfs(i,j);
					}
				}
			}
			
			System.out.println(ans);
		}
		 
	}
}
