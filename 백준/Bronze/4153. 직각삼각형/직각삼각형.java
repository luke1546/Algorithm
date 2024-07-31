import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		while(true) {
			ArrayList<Integer> list = new ArrayList<>();
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if(a == 0) break;
			list.add(a);
			list.add(b);
			list.add(c);
			Collections.sort(list);
			int x = list.get(0) * list.get(0) + list.get(1) * list.get(1);
			int y = list.get(2) * list.get(2);
			if(x == y) sb.append("right\n");
			else sb.append("wrong\n");
		}
		System.out.println(sb);
	}
}

/*
6 8 10
25 52 60
5 12 13
0 0 0

right
wrong
right
*/