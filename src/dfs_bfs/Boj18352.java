package dfs_bfs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import dfs_bfs.P;

public class Boj18352 {
	
	public static int[] chk;
	public static P[] arr;
	public static int n,m,k,x;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		int x = sc.nextInt();
		
		arr = new P[n+1];
		chk = new int[n+1];
		Queue<Integer> q = new LinkedList();
		
		for(int i = 1; i <= n; i++) {
			arr[i] = new P(i);
		}
		for(int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a].lst.add(b);
		}
		
		chk[x] = 1;
		q.add(x);
		ArrayList<Integer> ans = new ArrayList();
		while(q.size()>0) {
			int num = q.poll();
			int cnt = chk[num];
			if(cnt-1==k) {
				ans.add(num);
				continue;
			}
			if(cnt>k)
				break;
			ArrayList<Integer> lst = arr[num].lst;
			
			for(int i = 0; i < lst.size(); i++) {
				if(chk[lst.get(i)]==0) {
					q.add(lst.get(i));
					chk[lst.get(i)] = cnt+1;
				}
			}
		}
		if(ans.size()>0) {
			Collections.sort(ans);
			for(int i = 0; i < ans.size(); i++) {
				System.out.println(ans.get(i));
			}
		}else {
			System.out.println(-1);
		}
	}

}
