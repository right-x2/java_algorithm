package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Boj2841 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList< Stack<Integer> > list = new ArrayList<Stack<Integer>>(); 
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int ans = 0;
		for(int i = 0; i <=6; i++) {
			list.add(new Stack<>());
		}
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(list.get(a).size()==0||list.get(a).peek()<b) {
				list.get(a).add(b);
				ans++;
				
			}else {
				int flag = 0;
				while(true) {
					if(list.get(a).size()==0||list.get(a).peek()<b)
						break;
					if(list.get(a).peek()==b) {
						flag = 1;
						break;
					}
					list.get(a).pop();
					ans++;

				}
				if(flag==0) {
					ans++;
					list.get(a).add(b);
				}

			}
		}
		
		System.out.println(ans);
	}
}
