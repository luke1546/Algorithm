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
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		HashSet<String> hs = new HashSet<>();
		for(int i=0; i<N; i++) hs.add(br.readLine());
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), ", ");
			while(st.hasMoreTokens()) {
				String s = st.nextToken();
				if(hs.contains(s)) hs.remove(s);
			}
			sb.append(hs.size()).append("\n");
		}
		System.out.println(sb.toString());
	}
}

/*
5 2
map
set
dijkstra
floyd
os
map,dijkstra
map,floyd

3
2
*/