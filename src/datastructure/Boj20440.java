package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj20440 {
	
	static class P implements Comparable<P>{
		int a;
		int b;
		public P(int a, int b) {
			this.a = a;
			this.b = b;
		}
		@Override
		public int compareTo(P p) {
			if(this.a>p.b) {
				return 1;
			}else if(this.a==p.b) {
				if(this.b<p.b) {
					return 1;
				}
			}
			return -1;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<P> pq = new PriorityQueue<>();
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			pq.add(new P(a, b));
		}
		int x = pq.peek().a;
		int y = pq.peek().b;
		pq.poll();
		Stack<Integer> stk = new Stack<>();
		stk.push(y);
		int cnt = 1;
		int ans = 1;
		int ax = x;
		int ay = y;
		while(pq.size()>0) {
			int a = pq.peek().a;
			int b = pq.peek().b;
			
			if(a<y) {
				
				if(b<=y) {
					cnt++;
					stk.add(b);
					y = b;
					x = a;
					if(cnt>ans) {
						ax = x;
						ay = y;
						ans = cnt;
					}
				}else {
					if(cnt+1>ans) {
						ans = cnt+1;
						ax = a;
						ay = y;
					}
					x = a;
					y = b;
					
				}
			}else if(a==y) {
				
			}else {
				while(stk.size()>0&&stk.peek()<b) {
					stk.pop();
					cnt--;
				}
				cnt++;
				stk.add(b);
				x = a;
				y = b;
			}
		}
	}
}
