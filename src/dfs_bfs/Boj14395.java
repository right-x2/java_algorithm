package dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Idx{
	long num;
	String str;
	
	public Idx(long num, String str) {
		this.num = num;
		this.str = str;
	}
}


public class Boj14395 {
	public static Map<Long, Long> mp = new HashMap<Long, Long>();
	public static void main(String[] args) throws IOException {
		int a,b;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		int flag = 0;
		if(a==b) {
			System.out.println("0");
		}else if(b==0) {
			System.out.println("-");
		}else {
			String ans = "none";
			
			Queue<Idx> q = new LinkedList<Idx>();
			q.add(new Idx(a,""));
			while(q.size()>0) {
				long num = q.peek().num;
				String str = q.peek().str;
				q.poll();
				if(num==b) {
					ans = str;
					break;
				}
				
				if(num<b) {
					if(num*num<=b) {
						if(!mp.containsKey(num*num)) {
							q.add(new Idx(num*num,str+"*"));
							mp.put(num*num, num*num);
						}		
					}
					if(num+num<=b) {
						if(!mp.containsKey(num+num)) {
							q.add(new Idx(num+num,str+"+"));
							mp.put(num+num,num+num);
						}					
						
					}
				}
				if(flag==0) {
					q.add(new Idx(1,str+"/"));
					flag = 1;
				}
			}
			if(ans=="none") {
				System.out.println(-1);
			}else {
				System.out.println(ans);
			}	
		}
	}
}
