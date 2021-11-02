package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;


public class Boj4803 {

	public static int n,m,ans;
	public static int flag;
	public static List<Integer>[] arr;
	public static int[] chk;
	
	public static int dfs(int pre, int idx) {
		List<Integer> list = arr[idx];
		
		if(list==null)
			return 0;
		
		for(int i = 0;i < list.size(); i++) {
			if(chk[list.get(i)]==0) {
				chk[list.get(i)] = 1;
				dfs(idx,list.get(i));
			}else {
				if(list.get(i)!=pre) {
					flag = 1;
				}
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			cnt++;
			if(n==0&&m==0)
				break;
			arr = new ArrayList[n+1];
			chk = new int[n+1];
			ans = 0;
			
			for(int i = 1; i <= n; i++) {
				arr[i] = new ArrayList<Integer>();
			}
			
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				arr[a].add(b);
				arr[b].add(a);
			}
			for(int i = 1; i <= n; i++) {
				
				if(chk[i]==0) {
					flag = 0;
					chk[i] = 1;
					dfs(-1,i);
					if(flag==0)
						ans++;
				}
			}
			if(ans>1) {
				System.out.println("Case "+cnt+": A forest of "+ans+" trees.");
			}else if(ans==1) {
				System.out.println("Case "+cnt+": There is one tree.");
			}else {
				System.out.println("Case "+cnt+": No trees.");
			}
			
		}
		
	}

}
