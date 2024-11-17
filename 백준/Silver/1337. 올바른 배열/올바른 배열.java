import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		HashSet<Integer> set = new HashSet<>();
		int N = Integer.parseInt(br.readLine());
		int max = 0;
		for(int i=0; i<N; i++) {
			set.add(Integer.parseInt(br.readLine()));
		}
		
		for(int n : set) {
			int c = 1;
			for(int i=1; i<5; i++) {
				if(set.contains(n+i)) c++;
			}
			max = Math.max(max, c);
		}
		System.out.println(5-max);
	}
}
