package week5;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;


public class Boj4358 {
		public static void main(String[] args) throws IOException {
			
			HashMap<String, Integer> mp = new HashMap<String, Integer>();
			int[] count = new int[10001];
			ArrayList<String> arr = new ArrayList<String>();
			int total = 0;
			int type = 0;
			//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			Scanner sc = new Scanner(System.in);
			while(sc.hasNextLine()) {
				String name = sc.nextLine();
				if(name.equals(""))
					break;
				if(mp.containsKey(name)) {
					int idx = mp.get(name);
					count[idx]++;
				}else {
					arr.add(name);
					count[type] = 1;
					mp.put(name,type);
					type++;
				}
				total++;
			}
			
			Collections.sort(arr);
			
			for(int i = 0; i < arr.size(); i++) {
				String num = String.format("%.4f",100*(float)count[mp.get(arr.get(i))]/total);
				System.out.println(arr.get(i)+" "+num);
			}
			
			
			sc.close();
		}
}
