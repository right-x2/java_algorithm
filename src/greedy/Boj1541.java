package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1541 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String sb = "";
		int temp = 0;
		int ans = 0;
		int flag = 0;
		for(int i = 0; i <str.length(); i++) {
			if(str.charAt(i)!='-'&&str.charAt(i)!='+') {
				sb += str.charAt(i);
			}else {
				temp = Integer.parseInt(sb);
				if(flag==1) {
					ans -= temp;
				}else {
					ans += temp;
				}
				sb="";
				if(str.charAt(i)=='-')
					flag = 1;
			}
		}
		temp = Integer.parseInt(sb);
		if(flag ==0) {
			ans += temp;
		}else {
			ans -= temp;
		}
		System.out.println(ans);
	}

}
