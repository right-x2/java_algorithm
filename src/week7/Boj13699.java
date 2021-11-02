package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj13699 {
	
	public static long arr[] = new long[36];
	
	public static long solve(int idx) {
		if(arr[idx]>0) {
			return arr[idx];
		}
		
		long ans = 0;
		for(int i = 0; i < idx; i++) {
			ans += (solve(i)*solve(idx-1-i));
		}
		
		arr[idx] = ans;
		return arr[idx];
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		arr[0] = 1;
		long ans = 0;
		for(int i = 0; i < n; i++) {
			ans += (solve(i)*solve(n-1-i));
		}
		System.out.println(ans);
	}

}
