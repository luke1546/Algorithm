import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int cnt = 1;
			int floor = 0;
			int room = 0;
			boolean flag = false;
			for(int j=1; j<=C; j++) {
				for(int i=1; i<=R; i++) {
					if(cnt == N) {
						floor = i;
						room = j;
						flag = true;
						break;
					}
					cnt++;
				}
				if(flag) break;
			}
			if(room < 10)sb.append(floor).append("0").append(room).append("\n");
			else sb.append(floor).append(room).append("\n");
		}
		System.out.println(sb);
	}
}	


/*
2
6 12 10
30 50 72

402
1203
*/