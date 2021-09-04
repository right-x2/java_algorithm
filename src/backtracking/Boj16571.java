package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj16571 {
	public static int[][] arr = new int[9][9];
	public static int flag = 0;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = null;
		int a = 0;
		int b = 0;
		
		int op = 0;
		int dp = 0;
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j]==1)
					a++;
				else if(arr[i][j]==2)
					b++;
			}
		}
		
		if(a>=b) {
			op = 1;
			dp = 2;
		}	
		else {
			op = 2;
			dp = 1;
		}
	}

}
