import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		HashSet<Integer> set = new HashSet<>();
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			set.add(Integer.parseInt(st.nextToken()));
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++) {
			set.remove(Integer.parseInt(st.nextToken()));
		}
		bw.write(String.valueOf(set.size()));
		bw.write("\n");
		ArrayList<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		for(int v : list) bw.write(String.valueOf(v) + " ");
		bw.flush();
	}
}

/*
10 3
10 73 92 85 4 8 2 5 11 7
9 7 4

3
2 5 11
*/