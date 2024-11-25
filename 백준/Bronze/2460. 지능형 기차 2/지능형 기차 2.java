import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws Exception {
		int p = 0;
		int max = 0;
		for(int i=0; i<10; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			p = p-a+b;
			max = Math.max(max, p);
		}
		System.out.println(max);
	}
}

/*
0 32
3 13
28 25
39 0

42
*/