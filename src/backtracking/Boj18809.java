package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Spot{
	int y;
	int x;
	
	public Spot(int y, int x) {
		this.y = y;
		this.x = x;
	}
}

public class Boj18809 {
	public static int[][] arr = new int[51][51];
	public static int[][] chk = new int[51][51];
	public static int[][] temp = new int[51][51];
	public static int[] dy = {-1,0,1,0};
	public static int[] dx = {0,1,0,-1};
	public static List<Character> clist = new ArrayList<Character>();
	public static int flag = 0;
	public static int n,m,g,r,total,len,ans;
	public static List<Spot> list = new ArrayList<Spot>();
	public static Queue<Spot> q =  new LinkedList<Spot>();
	public static int qsize;

	
	
	public static int bfs() {
		int cnt = 0;
		int tot = 0;
		while(q.size()>0) {
			if(qsize==0) {
				qsize = q.size();
				cnt = cnt + 2;
			}
			int y = q.peek().y;
			int x = q.peek().x;
			q.poll();
			qsize--;
			for(int i = 0; i < 4 ; i++) {
				if(dy[i]+y<n&&dy[i]+y>=0&&dx[i]+x<m&&dx[i]+x>=0&&arr[dy[i]+y][dx[i]+x]>0) {
					if(temp[y][x]==cnt+1) {
						if(temp[dy[i]+y][dx[i]+x]==0) {
							temp[dy[i]+y][dx[i]+x] = cnt+3;
							q.add(new Spot(dy[i]+y, dx[i]+x));
						}else if(temp[dy[i]+y][dx[i]+x]==cnt+4) {
							temp[dy[i]+y][dx[i]+x] = -1;
							tot++;
						}
					}else if(temp[y][x]==cnt+2) {
						if(temp[dy[i]+y][dx[i]+x]==0) {
							temp[dy[i]+y][dx[i]+x] = cnt+4;
							q.add(new Spot(dy[i]+y, dx[i]+x));
						}else if(temp[dy[i]+y][dx[i]+x]==cnt+3) {
							temp[dy[i]+y][dx[i]+x] = -1;
							tot++;
						}
					}
				}
			}
		}
		if(tot>ans)
			ans = tot;
		return 0;
	}
	
	
	public static int solve(int idx, int cnt) {
		qsize = 0;
		if(cnt==total) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < m; j++) {
					temp[i][j] = chk[i][j];
					if(temp[i][j]!=0) {
						q.add(new Spot(i, j));
						qsize++;
					}
				}
			}
			bfs();
			return 0;
		}
		
		if(idx==len) {
			return 0;
		}
		
		for(int i = idx; i < len ; i++) {
			int a = list.get(i).y;
			int b = list.get(i).x;
			if(clist.get(cnt)=='R') {
				chk[a][b] = 1;
			}else if(clist.get(cnt)=='G') {
				chk[a][b] = 2;
			}
			solve(i+1,cnt+1);
			chk[a][b] = 0;
		}
		
		return 0;
	}
	
	public static int rec(int cnt) {
		if(cnt==total) {
			solve(0,0);
			return 0;
		}
		
		if(r>0) {
			r--;
			clist.add('R');
			rec(cnt+1);
			clist.remove(cnt);
			r++;
		}
		if(g>0) {
			g--;
			clist.add('G');
			rec(cnt+1);
			clist.remove(cnt);
			g++;
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
		g = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m;j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==2) {
					list.add(new Spot(i, j));
				}
			}
		}
		total = r+g;
		len = list.size();
		if(r>0) {
			r--;
			clist.add('R');
			rec(1);
			clist.remove(0);
			r++;
		}
		if(g>0) {
			g--;
			clist.add('G');
			rec(1);
			clist.remove(0);
			g++;
		}
		
		
		System.out.println(ans);
	}

}
