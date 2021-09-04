package datastructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj7785 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String,Integer> map = new HashMap<String, Integer>();
        StringTokenizer st = null;
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n+1];
        int[] chk = new int[n+1];
        ArrayList<String> ans = new ArrayList<String>();
        int cnt = 0;
        for(int i = 0; i < n; i++) {
        	st = new StringTokenizer(br.readLine());
        	String a = st.nextToken();
        	String b = st.nextToken();
        	
        	if(b.equals("enter")) {
        		map.put(a,cnt);
        		chk[cnt] = 1;
        		arr[cnt] = a; 
        		cnt++;
        	}else {
        		int idx = map.get(a);
        		chk[idx] = 0;
        	}
        }
        
        for(int i = 0; i < cnt; i++) {
        	if(chk[i]==1)
        		ans.add(arr[i]);
        }
        Collections.sort(ans);
        
        for(int i = ans.size()-1; i >= 0; i--)
        	System.out.println(ans.get(i));
	}

}
