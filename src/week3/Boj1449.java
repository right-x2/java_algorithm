package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj1449 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Integer> lst = new ArrayList<Integer>();
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		int n = Integer.parseInt(st.nextToken());
		int l = Integer.parseInt(st.nextToken());
		
		str = br.readLine();
		st = new StringTokenizer(str);
		
		for(int i = 0; i < n; i++) {
			lst.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(lst);
		
		int s = lst.get(0);
		int ans = 0;
		for(int i = 1; i < n; i++) {
			if(lst.get(i)-s>=l) {
				ans++;
				s = lst.get(i);
			}
		}
		
		ans++;
		
		System.out.println(ans);
		
	}

}
