package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Boj1253 {
	public static List<Long> list = new ArrayList<Long>();
	public static int ans = 0;
	public static long num = 0;
	public static HashMap<Long, Integer> mp =  new HashMap<Long, Integer>();
	
	public static int search(int s, int idx, int cur) {
		Long temp = list.get(idx);
		int e = idx-1;
		int flag = 0;
		while(s<=e) {
			int mid = (s+e)/2;
			Long sum = list.get(mid)+temp;
			if(sum==num) {
				if(cur==mid)
					flag = 0;
				else
					flag = 1;
				break;
			}else if(sum>num) {
				e = mid-1;
			}else {
				s = mid+1;
			}
		}
		if(flag==1) {
			return 1;
		}else {
			return 0;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {
			list.add(Long.parseLong(st.nextToken()));
		}
		
		Collections.sort(list);
		
		for(int i = 0; i < list.size(); i++) {
			num = list.get(i);
			int flag = 0;
			int result = 0;

			if(mp.containsKey(num)) {
				if(mp.get(num)==1) {
					ans++;
					System.out.println(num);
				}
				continue;
			}
			for(int j = 1; j < list.size(); j++) {
				if(j==i)
					continue;
				/*
				if(list.get(0)+list.get(j)>num) {
					break;
				}
				*/
				int k = j;
				while(k+1<list.size()&&list.get(k)==list.get(k+1)) {
					k++;
				}
				if(i==0)
					result = search(1,k,i);
				else
					result = search(0,k,i);
				
				if(result==1) {
					flag = 1;
					break;
				}
			}

			if(flag==1) {
				ans++;
				mp.put(num,1);
				System.out.println(num);
			
			}else {
				mp.put(num,0);
			}
		}
		
		System.out.println(ans);
	}
}
