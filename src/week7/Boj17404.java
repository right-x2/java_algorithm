package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj17404 {
	
	public static int[][] arr;
	public static int[][] dp;
	public static int n;
	public static int solve(int num,int idx, int start) {
		for(int i = 0; i < 3; i++) {
			if(idx!=i) {
				
			}
		}
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n][3];
		dp = new int[n][3];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve(n-1,0,0);
		solve(n-1,1,1);
		solve(n-1,2,2);
	}
}
