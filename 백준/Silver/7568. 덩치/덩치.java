import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int people[][] = new int[N][2];
		int rank[] = new int[N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int weight = Integer.parseInt(st.nextToken());
			int height = Integer.parseInt(st.nextToken());
			people[i][0] = weight;
			people[i][1] = height;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(people[i][0] < people[j][0] && people[i][1] < people[j][1]) rank[i]++;
			}
		}
		for(int i : rank) sb.append(i+1 + " ");
		System.out.print(sb.toString());
	}
}

/*
5
55 185
58 183
88 186
60 175
46 155

2 2 1 2 5
*/
