package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Boj1890 {
	public static long [][] chk;
	public static int [][] arr;
	public static int n;
	
	public static long solve(int y, int x) {
		
		
		
		if(y==n-1&&x==n-1) {
			chk[y][x] = 1;
			return 1;
		}
		
		
		long a = 0;
		long b = 0;
		long jump = arr[y][x];
		
		if(jump==0)
			return 0;
		if(y+jump<n) {
			if(chk[(int) (y+jump)][x]>0) {
				a = chk[(int) (y+jump)][x];
			}else {
				a = solve((int) (y+jump),x);
			}
		}
		
		
		if(x+jump<n) {
			if(chk[y][(int) (x+jump)]>0) {
				b = chk[y][(int) (x+jump)];
			}else {
				b = solve(y,(int) (x+jump));
			}
		}
		
		chk[y][x] = a+b;
		
		return chk[y][x];
			
	}
	
 	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		n = Integer.parseInt(br.readLine());
		arr = new int[n][n];
		chk = new long[n][n];
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(solve(0,0));
	}

}
