package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Virus implements Comparable<Virus>{
	int y;
	int x;
	int idx;
	
	public Virus(int y, int x, int idx){
		this.y = y;
		this.x = x;
		this.idx = idx;
	}

	@Override
	public int compareTo(Virus o) {
		if(this.idx>o.idx)
			return 1;
		return -1;
	}
	
	
}

public class Boj18405 {

	public static void main(String[] args) throws IOException {
		List<Virus> list = new ArrayList();
		Queue<Virus> q = new LinkedList();
		int []dy = {-1,0,1,0};
		int []dx = {0,1,0,-1};
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][]arr = new int[n+1][m+1];
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <=n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]>0)
					list.add(new Virus(i,j,arr[i][j]));
			}
		}
		st = new StringTokenizer(br.readLine());
		
		int s = Integer.parseInt(st.nextToken());
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		Collections.sort(list);
		int cnt = list.size();
		for(int i = 0; i < list.size(); i++) {
			q.add(list.get(i));

		}
		
		for(int i = 0; i < s; i++) {
			while(cnt>0&&q.size()>0) {
				Virus v = q.poll();
				int y = v.y;
				int x = v.x;
				int idx = v.idx;

				for(int j = 0; j < 4; j++) {
					if(y+dy[j]>0&&y+dy[j]<=n&&x+dx[j]>0&&x+dx[j]<=n&&arr[y+dy[j]][x+dx[j]]==0) {
						arr[y+dy[j]][x+dx[j]] = idx;
						q.add(new Virus(y+dy[j],x+dx[j],idx));
					}
				}
				cnt--;
			}
			cnt = q.size();
		}
		System.out.println(arr[a][b]);

		
	}

}
