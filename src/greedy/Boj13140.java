package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj13140 {
	public static int[] arr = new int[7];
	public static int[] chk = new int[11];
	public static int flag,n,ans1,ans2;
	public static int sol(int idx) {
		if(idx==7) {
			int a = arr[0]*10000+arr[2]*1000+arr[3]*100+arr[3]*10+arr[4];
			int b = arr[1]*10000+arr[4]*1000+arr[5]*100+arr[3]*10+arr[6];
			if(a+b==n) {
				flag = 1;
				ans1 = a;
				ans2 = b;
			}
			return 0;
		}
		int start;
		if(idx<2) {
			start = 1;
		}else {
			start = 0;
		}
		
		for(int i = start; i < 10; i++) {
			if(chk[i]==0&flag==0) {
				arr[idx] = i;
				chk[i] = 1;
				sol(idx+1);
				chk[i] = 0;
				arr[idx] = 0;
			}
				
		}
		return 0;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		
		for(int i = 1; i <10; i++) {
			arr[0] = i;
			chk[i] = 1;
			sol(1);
			chk[i] = 0;
		}
		
		if(flag==1) {
			System.out.println("  "+ans1);
			System.out.println("+ "+ans2);
			System.out.println("-------");
			System.out.println("  "+n);
		}else {
			System.out.println("No Answer");
		}
	}
}
