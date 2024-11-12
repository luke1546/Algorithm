import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		String str = br.readLine();
		if(str.length() == 1) sb.append(0).append(Integer.parseInt(str)%3==0?"\nYES" : "\nNO");
		else {
			int cnt = 1;
			int n = 0;
			for(int i=0; i<str.length(); i++) {
				n += (str.charAt(i)-'0');
			}
			
			while(n > 9) {
				cnt++;
				int temp = 0;
				while(n > 0) {
					temp += n%10;
					n/=10;
				}
				n = temp;
			}
			sb.append(cnt);
			sb.append(n%3==0 ? "\nYES" : "\nNO");
		}
		System.out.println(sb);
	}
}

/*
1234567

3
NO
*/