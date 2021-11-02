package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj10773 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		Stack<Integer> stk = new Stack<Integer>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			int a = Integer.parseInt(br.readLine());
			if(a==0) {
				if(stk.size()>0) {
					stk.pop();
				}
			}else {
				stk.push(a);
			}
		}
		int ans = 0;
		while(stk.size()>0) {
			ans += stk.pop();
		}
		System.out.println(ans);
	}
}
