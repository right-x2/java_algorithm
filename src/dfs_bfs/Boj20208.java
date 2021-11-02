package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj20208 {
	

	static class P{
		int y;
		int x;
		public P(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
	public static int[][] arr;
	public static int[]chk;
	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,1,0,-1};
	public static int y,x,ans,h,n;
	public static List<P> list = new ArrayList<>();
	
	public static int solve(int a, int b, int sum, int tot) {
		int dis  = Math.abs(y-a)+Math.abs(x-b);
		if(dis<=sum) {
			if(tot>ans) {
				ans = tot;
			}
		}
		
		
		for(int i = 0; i < list.size(); i++) {
			if(chk[i]==0) {
				dis  = Math.abs(a-list.get(i).y)+Math.abs(b-list.get(i).x);
				if(dis<=sum) {
					chk[i] = 1;
					solve(list.get(i).y,list.get(i).x,sum-dis+h,tot+1);
					chk[i] = 0;
				}				
			}
		}
		return 0;
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		h = Integer.parseInt(st.nextToken());
		arr = new int[n][n];
		
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1) {
					y = i;
					x = j;
				}
				if(arr[i][j]==2) {
					list.add(new P(i,j));
				}
			}
		}
		chk = new int[list.size()];
		for(int i = 0; i < list.size(); i++) {
			int dis  = Math.abs(y-list.get(i).y)+Math.abs(x-list.get(i).x);
			if(dis<=m) {
				chk[i] = 1;
				solve(list.get(i).y,list.get(i).x,m-dis+h,1);
				chk[i] = 0;
			}
		}
		System.out.println(ans);
	}
}
