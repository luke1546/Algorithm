import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		String s = br.readLine();
		int[] count = new int[2];
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='0') count[0]++;
			else count[1]++;
		}
		count[0]/=2;
		count[1]/=2;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i)=='0') {
				if(count[0] > 0) {
					count[0]--;
					sb.append('0');
				}
			}
			else {
				if(count[1] > 0) count[1]--;
				else sb.append('1');
			}
		}
		System.out.println(sb.toString());
	}
}
