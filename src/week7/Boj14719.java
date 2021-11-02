package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14719 {
	public static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		arr = new int[m];
		for(int i = 0; i < m;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int pre = arr[0];
		int tp = arr[0];
		int tidx = 0;
		int ans = 0;
		for(int i = 1; i < m; i++) {
			if(pre<arr[i]) {
				int num = Math.min(tp,arr[i]);
				int idx = i-1;
				while(tidx<idx) {
					if(num<=arr[idx])
						break;
					ans += (num - arr[idx]);
					arr[idx] = num;
					idx--;
				}
				if(tp<=arr[i]) {
					tidx = i;
					tp = arr[i];
				}
			}
			pre = arr[i];
		}
		System.out.println(ans);
	}
}
