package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj14425 {
	public static void main(String[] args) throws IOException {
		HashMap<String,Integer> mp = new HashMap<String, Integer>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		for(int i = 0; i < n; i++) {
			mp.put(br.readLine(), i);
		}
	
		for(int i = 0; i < m; i++) {
			String str = br.readLine();
			if(mp.containsKey(str)) {
				ans++;
			}
		}
		System.out.println(ans);
	}
}
