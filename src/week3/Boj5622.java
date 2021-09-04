package week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj5622 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int ans = str.length();
		
		for(int i = 0; i < str.length();i++) {
			char temp = str.charAt(i);
			
			if(temp<'D')
				ans += 2;
			else if(temp<'G')
				ans += 3;
			else if(temp<'J')
				ans += 4;
			else if(temp<'M')
				ans += 5;
			else if(temp<'P')
				ans += 6;
			else if(temp<'T')
				ans += 7;
			else if(temp<'W')
				ans += 8;
			else
				ans +=9;
		}
		
		System.out.println(ans);
	}

}
