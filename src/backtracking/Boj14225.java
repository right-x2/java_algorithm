package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj14225 {

	public static int[] chk = new int[2000001];
	public static int[] arr;
	public static int n;
	public static int mx;
	public static int solve(int sum, int idx) {
		
		
		if(chk[sum]>0&&chk[sum]<=idx)
			return 0;
		
		chk[sum] = idx;
		
		if(sum>mx)
			mx = sum;
		
		if(idx>=n)
			return 0;
		
		for(int i = idx; i <n; i++) {

			solve(sum+arr[i],i+1);
		}
		return 0;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		arr = new int[n];	
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			solve(arr[i],i+1);
		}
		
		for(int i = 1; i<=mx+1;i++) {
			if(chk[i]==0) {
				System.out.println(i);
				break;
			}
		}
	}

}
