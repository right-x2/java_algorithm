package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj11048 {
	public static int[][] arr;
	public static int[][] chk;
	public static int n,m;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[1001][1001];
		chk = new int[1001][1001];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
	    		if(i==0&&j==0) chk[i][j] = arr[i][j];
	    		else if(i==0)
	    		{
	    			chk[i][j] = chk[i][j-1];
	    			chk[i][j] = chk[i][j] + arr[i][j];
	    		}
	    		else if(j==0)
	    		{
					chk[i][j] = chk[i-1][j];
					chk[i][j] = chk[i][j] + arr[i][j];
	    		} 
	    		else
	    		{
	    			chk[i][j] = Math.max(chk[i][j-1],chk[i-1][j]);
	    			chk[i][j] = chk[i][j] + arr[i][j];
	    		}
			}
			
		}
		
		System.out.println(chk[n-1][m-1]);
		
	}
}
