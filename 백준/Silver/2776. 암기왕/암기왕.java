import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			HashSet<Integer> set = new HashSet<>();
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) set.add(Integer.parseInt(st.nextToken()));
			int M = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				if(set.contains(Integer.parseInt(st.nextToken()))) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}
		}
        System.out.print(sb);
	}
}

/*
1
5
4 1 5 2 3
5
1 3 7 9 5

1
1
0
0
1
*/