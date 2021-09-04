package dfs_bfs;

import java.util.ArrayList;
import java.util.Scanner;


class P{
	int idx;
	ArrayList<Integer> lst;
	public P(int idx) {
		this.idx = idx;
		this.lst = new ArrayList();
	}
}
public class Boj21937 {

	public static int ans;
	public static P[] arr;
	public static int[] chk;
	public static int dfs(int idx) {
		if(arr[idx].lst.size()==0) {
			return 0;
		}
		
		ArrayList<Integer> lst = arr[idx].lst;
		for(int i = 0; i < lst.size(); i++) {
			if(chk[lst.get(i)]==1)
				continue;
			chk[lst.get(i)] = 1;
			ans++;
			dfs(lst.get(i));
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,m;
		
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		m = sc.nextInt();
		arr = new P[n+1];
		chk = new int[n+1];
		ans = 0;
		for(int i = 1; i <=n; i++) {
			arr[i] = new P(i);
		}
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[b].lst.add(a);
		}
		int num = sc.nextInt();
		chk[num] = 1;
		dfs(num);
		System.out.println(ans);
	}

}
