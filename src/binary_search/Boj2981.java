package binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Boj2981 {

	public static long []arr;
	public static int n;
	public static int check(long num) {
		long mod = arr[0]%num;
		
		for(int i = 1; i <n; i++) {
			if(mod!=arr[i]%num)
				return 0;
		}
		return 1;
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		ArrayList<Long> list = new ArrayList<>();
		n = Integer.parseInt(br.readLine());
		arr = new long[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		long s = 2;
		long e = arr[0];
		long mn = e;
		while(s<=e) {
			long mid = (s+e)/2;
			
			int flag = check(mid);
			
			if(flag==1) {
				mn = mid;
				s = mid+1;
			}else {
				e = mid-1;
			}
		}
		list.add(mn);
		long sqrt = (long)Math.sqrt(mn);
		for(long i = 2; i <= sqrt; i++){
			   if(mn % i == 0){ 
			    
			        if(i==sqrt&&mn / i == sqrt){ 
			        	list.add(i);
			        }else {
			        	list.add(i);
			        	if(mn/i>1)
			        		list.add(mn / i);
			        }
			    }
			}
		Collections.sort(list);
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i)+" ");
		}
	}

}
