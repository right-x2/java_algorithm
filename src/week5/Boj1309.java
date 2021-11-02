package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1309 {
	public static int n;
	public static int[][] arr;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n+1][3];
	    arr[0][0] = 1;
	    arr[0][1] = 1;
	    arr[0][2] = 1;

	    for (int i = 1; i <n ; ++i)
	    {
	        arr[i][1] = (arr[i-1][2]+arr[i-1][0])%9901;
	        arr[i][2] = (arr[i-1][1]+arr[i-1][0])%9901;
	        arr[i][0] = (arr[i-1][1]+arr[i-1][0]+arr[i-1][2])%9901;
	    }

	    int sum = 0;
	    for (int i = 0; i < 3; ++i)
	    {
	        sum = (sum + arr[n-1][i])%9901;
	    }
	    System.out.println(sum);
	}
}
