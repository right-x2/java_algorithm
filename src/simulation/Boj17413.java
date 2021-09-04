package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;




public class Boj17413 {

	public static void main(String[] args) throws IOException {  
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int flag = 0;
		String ans = "";
		
		String temp = "";
		
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i)==' ') {
				if(flag==0) {
					StringBuffer sb = new StringBuffer(temp);
					String reversed = sb.reverse().toString();
					ans += reversed;
					ans += ' ';
					temp = "";
				}else{
					temp += str.charAt(i);
				}
			}else if(str.charAt(i)=='>') {
				temp += str.charAt(i);
				ans += temp;
				temp = "";
				flag = 0;
			}else if(str.charAt(i)=='<') {
				if(temp.length()>0) {
					StringBuffer sb = new StringBuffer(temp);
					String reversed = sb.reverse().toString();
					ans += reversed;
					temp = "";
				}
				flag = 1;
				temp += str.charAt(i);
			}else {
				temp += str.charAt(i);
			}
		}
		
		if(flag==0) {
			StringBuffer sb = new StringBuffer(temp);
			String reversed = sb.reverse().toString();
			ans += reversed;
		}
		System.out.println(ans);
	}

}
