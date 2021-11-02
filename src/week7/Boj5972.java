package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj5972 {

	static class P implements Comparable<P>{
		int num;
		int sum;
		public P(int num, int sum) {
			this.num = num;
			this.sum = sum;
		}
		@Override
		public int compareTo(P o) {
			// TODO Auto-generated method stub
			if(this.sum>o.sum) {
				return 1;
			}
			return -1;
		}
	}
	public static int[] chk;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<P>[] arr;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		arr = new ArrayList[n+1];
		chk = new int[n+1];
		for(int i = 1; i<=n;i++) {
			arr[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			arr[a].add(new P(b,c));
			arr[b].add(new P(a,c));
		}
		
		PriorityQueue<P> pq = new PriorityQueue<>();
		pq.add(new P(1,0));
		int ans = -1;
		while(pq.size()>0) {
			int num = pq.peek().num;
			int sum = pq.peek().sum;
			pq.poll();
			if(num==n) {
				ans = sum;
				break;
			}
			if(chk[num]==1)
				continue;
			chk[num] = 1;
			for(int i = 0; i < arr[num].size(); i++) {
				if(chk[arr[num].get(i).num]==0) {
					pq.add(new P(arr[num].get(i).num,sum+arr[num].get(i).sum));
				}
			}
		}
		System.out.println(ans);
	}

}
