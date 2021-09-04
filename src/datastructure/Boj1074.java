package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj1074 {
	public static int cnt,y,x,ans;
	public static int flag;
	public static int solve(int a, int b, int c, int d,int s,int e,int m) {
		System.out.println(a+" "+b+" "+c+" "+d+" "+s+" "+e+" "+m);
		if(a==c&&b==d) {
			if(a==y&&b==x) {
				ans = e;
				flag = 1;
			}
			return 0;
		}
		int m2 = (int)Math.pow(2,m);
		int temp = m2/2;
		if(flag==0) {
			if(y>=a&&y<=a+temp-1&&x>=b&&x<=b+temp-1)
				solve(a,b,a+temp-1,b+temp-1,0,s+temp*temp-1,s+m-1);
			if(y>=a&&y<=a+temp-1&&x>=b+temp&&x<=b+m2-1)
				solve(a,b+temp,a+temp-1,b+m2-1,s+temp*temp,s+(temp*temp)*2-1,m-1);
			if(y>=a+temp&&y<=a+m2-1&&x>=b&&x<=b+temp-1)
				solve(a+temp,b,a+m2-1,b+temp-1,s+(temp*temp)*2,s+(temp*temp)*3-1,m-1);
			if(y>=a+temp&&y<=a+m2-1&&x>=b+temp&&x<=b+m2-1)
				solve(a+temp,b+temp,a+m2-1,b+m2-1,s+(temp*temp)*3,s+(temp*temp)*4-1,m-1);
		}
		return 0;
		
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine()) ;
		
		int n = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());

		int m = (int) Math.pow(2,n);
		int temp = m/2;
		cnt = 0;
		ans = 0;
		solve(0,0,temp-1,temp-1,0,temp*temp-1,n-1);
		solve(0,temp,temp-1,m-1,temp*temp,(temp*temp)*2-1,n-1);
		solve(temp,0,m-1,temp-1,(temp*temp)*2,(temp*temp)*3-1,n-1);
		solve(temp,temp,m-1,m-1,(temp*temp)*3,(temp*temp)*4-1,n-1);
		System.out.println(ans);
 	}

}
