import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			int ans = 0;
			st = new StringTokenizer(br.readLine(), " ");
			st.nextToken();
			ArrayList<Integer> al = new ArrayList<>();
			for(int j=0; j<20; j++) {
				int n = Integer.parseInt(st.nextToken());
				int index = Collections.binarySearch(al, n) * -1 -1;
				al.add(index, n);
				ans += al.size()-index-1;
			}
			sb.append(i+1).append(" ").append(ans).append("\n");
		}	
		System.out.println(sb.toString());
	}
}