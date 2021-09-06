package week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj14888 {
	public static ArrayList<Integer> list;
	public static ArrayList<Character> opr;
	public static int n;
	public static char[] temp = {'+','-','*','/'};
	public static int[] chk;
	public static int mx = -1000000001;
	public static int mn = 1000000001;
	public static int solve(int cnt ,int sum) {

		if(cnt==n) {
			if(sum>mx)
				mx = sum;
			if(sum<mn)
				mn = sum;
			return 0;
		}
		int num = list.get(cnt);

		for(int i = 0; i < n-1; i++) {
			if(chk[i]==0) {

				chk[i] = 1;
				if(opr.get(i)=='+') {
					solve(cnt+1,sum+num);
				}else if(opr.get(i)=='-') {
					solve(cnt+1,sum-num);
				}else if(opr.get(i)=='*') {
					solve(cnt+1,sum*num);
				}else {
					solve(cnt+1,sum/num);
				}
				chk[i] = 0;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		list = new ArrayList<Integer>();
		opr = new ArrayList<Character>();
		chk = new int[n-1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {

			int m = Integer.parseInt(st.nextToken());
		
			for(int j = 0; j < m; j++) {
				opr.add(temp[i]);
			}
		}

		
		solve(1,list.get(0));
		System.out.println(mx);
		System.out.println(mn);
		
	}
}
