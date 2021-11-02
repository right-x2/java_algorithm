package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj7785 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<String> lst = new ArrayList<String>();
		Map<String, Integer> mp = new HashMap<String, Integer>();
		int[] arr = new int[1000001];
		String[] name = new String[1000001];
		
		int n = Integer.parseInt(st.nextToken());
		int cnt = 0;
		for(int i = 0 ; i< n ; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			String b = st.nextToken();
			
			if(b.equals("enter")) {
				name[cnt] = a;
				arr[cnt] = 1;
				mp.put(a,cnt);
				cnt++;
			}else {
				int idx = mp.get(a);
				arr[idx] = 0;
			}
		}
		
		for(int i = 0; i < cnt; i++) {
			if(arr[i]==1) {
				lst.add(name[i]);
			}
		}
		Collections.sort(lst);
		for(int i = lst.size()-1; i >= 0; i--) {
			System.out.println(lst.get(i));
		}
	}

}
