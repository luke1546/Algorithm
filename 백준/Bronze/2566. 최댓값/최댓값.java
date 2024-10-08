import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int max = -1;
		int ans[] = new int[2];
		for(int i=0; i<9; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<9; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(max < n) {
					max = n;
					ans[0] = i+1;
					ans[1] = j+1;
				}
			}
		}
		System.out.println(max);
		System.out.println(ans[0] + " "  + ans[1]);
	}
}
