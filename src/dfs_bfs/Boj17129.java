package dfs_bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point{
	int y;
	int x;
	public Point(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Boj17129 {
	public static int n,m,a,b;
	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,1,0,-1};
	public static int[][] arr;
	public static int[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new int[n][m];
		chk = new int[n][m];
		
		Queue<Point> q = new LinkedList();
		for(int i = 0; i < n;i++) {
			String str = sc.next();
			for(int j = 0; j < m; j++) {
				arr[i][j] = str.charAt(j)-'0';
				if(arr[i][j]==2) {
					a = i;
					b = j;
				}
			}
		}
		
		q.add(new Point(a,b));
		chk[a][b] = 1;
		int ans = -1;
		while(q.size()>0) {
			Point p = q.poll();
			int y = p.y;
			int x = p.x;
			int cnt = chk[y][x];
			if(arr[y][x]>2) {
				ans = cnt;
				break;
			}
			for(int i = 0; i < 4; i++) {
				if(y+dy[i]>=0&&y+dy[i]<n&&x+dx[i]>=0&&x+dx[i]<m&&chk[y+dy[i]][x+dx[i]]==0&&arr[y+dy[i]][x+dx[i]]!=1) {
					chk[y+dy[i]][x+dx[i]] = cnt+1;
					q.add(new Point(y+dy[i],x+dx[i]));
				}
			}
		}
		
		if(ans>-1) {
			System.out.println("TAK");
			System.out.println(ans-1);
		}else {
			System.out.println("NIE");
		}
	}
}
