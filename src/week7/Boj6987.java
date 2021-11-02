package week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj6987 {
	

	public static int flag = 0;
	public static int[][] arr = new int[6][3];
	public static int[]ans = new int[4];
	public static int solve(int a, int b) {
		//System.out.println(a+" "+b);
		if(a==5) {
			flag = 1;
			return 0;
		}
		
		if(arr[a][0]>0&&arr[b][2]>0) {
			arr[a][0]--;
			arr[b][2]--;
			if(b==5) {
				solve(a+1,a+2);
			}else {
				solve(a,b+1);
			}
			arr[a][0]++;
			arr[b][2]++;
		}
		
		if(arr[a][1]>0&&arr[b][1]>0) {
			arr[a][1]--;
			arr[b][1]--;
			if(b==5) {
				solve(a+1,a+2);
			}else {
				solve(a,b+1);
			}
			arr[a][1]++;
			arr[b][1]++;
		}
		
		if(arr[a][2]>0&&arr[b][0]>0) {
			arr[a][2]--;
			arr[b][0]--;
			if(b==5) {
				solve(a+1,a+2);
			}else {
				solve(a,b+1);
			}
			arr[a][2]++;
			arr[b][0]++;
		}
		return 0;
	}
	
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int i = 0; i < 4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int aflag = 0;
			for(int j = 0; j < 6; j++) {
				for(int k = 0; k < 3; k++) {
					arr[j][k] = Integer.parseInt(st.nextToken());
					if(arr[j][k]>5)
						aflag = 1;
				}
			}
			solve(0,1);
			if(aflag==1)
				flag = 0;
			if(i<3)
				System.out.print(flag+" ");
			else
				System.out.print(flag);
			flag = 0;
		}
	}

}
