package week6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj2961 {

	
	public static int n;
	public static int ans = -1;
	public static int[] a;
	public static int[] b;
	public static int solve(int idx, int mul, int plus) {
		if(ans==-1||Math.abs(plus-mul)<ans) 
			ans = Math.abs(plus-mul);
		
		if(idx==n)
			return 0;
		
		for(int i = idx; i <n;i++) {
			solve(i+1, mul*a[i], plus+b[i]);
		}
		
		return 0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =null ;
		
		n = Integer.parseInt(br.readLine());
		
		a = new int[n];
		b = new int[n];

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			a[i] = Integer.parseInt(st.nextToken());
			b[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			solve(i+1, a[i], b[i]);
		}
		
		System.out.println(ans);

	}

}
