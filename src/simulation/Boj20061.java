package simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj20061 {
	public static int[][] green;
	public static int[][] blue;
	public static int ans;

	public static void check() {
		for(int i = 2; i < 6; i++) {
			int flag = 0;
			for(int j = 0; j < 4; j++) {
				if(green[i][j]==0)
					flag = 1;
			}
			if(flag==0) {
				ans++;
				for(int j = i; j>=1; j--) {
					for(int k = 0; k < 4; k++) {
						green[j][k] = green[j-1][k];
					}				
				}
				for(int j = 0; j <4; j++) {
					green[0][j] = 0;
				}
			}
		}
		
		for(int i = 2; i < 6; i++) {
			int flag = 0;
			for(int j = 0; j < 4; j++) {
				if(blue[j][i]==0)
					flag = 1;
			}
			if(flag==0) {
				ans++;
				for(int j = i; j>=1; j--) {
					for(int k = 0; k < 4; k++) {
						blue[k][j] = blue[k][j-1];
					}				
				}
				for(int j = 0; j <4; j++) {
					blue[j][0] = 0;
				}
			}
		}
		
		int flag = 0;
		for(int i = 0; i < 4; i++) {
			if(green[0][i]==1)
				flag = 1;
		}
		if(flag==1) {
			for(int i = 5; i >=2 ; i--) {
				for(int j = 0; j < 4; j++) {
					green[i][j] = green[i-2][j];
				}
			}
			for(int i = 0; i < 4; i++) {
				green[0][i] = 0;
				green[1][i] = 0;
			}
		}
		
		flag = 0;
		for(int i = 0; i < 4; i++) {
			if(green[1][i]==1)
				flag = 1;
		}
		if(flag==1) {
			for(int i = 5; i >=1 ; i--) {
				for(int j = 0; j < 4; j++) {
					green[i][j] = green[i-1][j];
				}
			}
			for(int i = 0; i < 4; i++) {
					green[1][i] = 0;
			}				

		}
		
		flag = 0;
		for(int i = 0; i < 4; i++) {
			if(blue[i][0]==1)
				flag = 1;
		}
		if(flag==1) {
			for(int i = 5; i >=2 ; i--) {
				for(int j = 0; j < 4; j++) {
					blue[j][i] = blue[j][i-2];
				}
			}
			for(int i = 0; i < 4; i++) {
				blue[i][0] = 0;
				blue[i][1] = 0;
			}
		}
		
		flag = 0;
		for(int i = 0; i < 4; i++) {
			if(blue[i][1]==1)
				flag = 1;
		}
		if(flag==1) {
			for(int i = 5; i >=2 ; i--) {
				for(int j = 0; j < 4; j++) {
					blue[j][i] = blue[j][i-1];
				}
			}
			for(int i = 0; i < 4; i++) {
				blue[i][1] = 0;
			}
		}
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int ans2 = 0;
		green = new int[6][4];
		blue = new int[4][6];
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int t = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			
			if(t==1) {
				int a = 0;
				int b = x;
				while(true) {
					if(a==5) {
						green[a][b] = 1;
						break;						
					}
					if(green[a+1][b]==1) {
						green[a][b] = 1;
						break;
					}
					a++;
				}
				a = y;
				b = 0;
				while(true) {
					if(b==5) {
						blue[a][b] = 1;
						break;
					}
					if(blue[a][b+1]==1) {
						blue[a][b] = 1;
						break;
					}
					b++;
				}
			}else if(t==2) {
				int a = 0;
				int b = x+1;
				while(true) {
					if(a==5) {
						green[a][b] = 1;
						green[a][b-1] = 1;
						break;
					}
					if(green[a+1][b]==1||green[a+1][b-1]==1) {
						green[a][b] = 1;
						green[a][b-1] = 1;
						break;
					}
					a++;
				}
				a = y;
				b = 0;
				while(true) {
					if(b==5) {
						blue[a][b] = 1;
						blue[a][b-1] = 1;
						break;
					}
					if(blue[a][b+1]==1) {
						blue[a][b] = 1;
						blue[a][b-1] = 1;
						break;
					}
					b++;
				}
			}else {
				int a = 0;
				int b = x;
				while(true) {
					if(a==5) {
						green[a-1][b] = 1;
						green[a][b] = 1;
						break;	
					}
					if(green[a+1][b]==1) {
						green[a-1][b] = 1;
						green[a][b] = 1;
						break;
					}
					a++;
				}
				a = y+1;
				b = 0;
				while(true) {
					if(b==5) {
						blue[a-1][b] = 1;
						blue[a][b] = 1;
						break;	
					}
					if(blue[a][b+1]==1||blue[a-1][b+1]==1) {
						blue[a][b] = 1;
						blue[a-1][b] = 1;
						break;
					}
					b++;
				}
			}
			check();
		}
		
		for(int i = 0; i < 6; i++) {
			for(int j = 0; j < 4; j++) {
				if(green[i][j]==1)
					ans2++;
				if(blue[j][i]==1)
					ans2++;
			}
		}
		System.out.println(ans);
		System.out.println(ans2);
	}
}
