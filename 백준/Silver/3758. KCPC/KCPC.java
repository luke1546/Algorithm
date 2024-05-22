import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine(), " ");
			int teams = Integer.parseInt(st.nextToken());
			int problems = Integer.parseInt(st.nextToken());
			int id = Integer.parseInt(st.nextToken());
			int logs = Integer.parseInt(st.nextToken());
			int teamScores[][] = new int[teams][problems+4]; //제출횟수, 마지막 제출 번호, totalscore, 팀번호
			for(int k=0; k<logs; k++) {
				st = new StringTokenizer(br.readLine(), " ");
				int i = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				int score = Integer.parseInt(st.nextToken());
				teamScores[i-1][p-1] = Math.max(score, teamScores[i-1][p-1]);
				teamScores[i-1][problems]++;
				teamScores[i-1][problems+1] = k;
			}
			for(int a=0; a<teams; a++) {
				teamScores[a][problems+3] = a+1;
				for(int b=0; b<problems; b++) {
					teamScores[a][problems+2] += teamScores[a][b];
				}
//				System.out.println(teamScores[a][problems+2]);
			}
			Arrays.sort(teamScores, (o1,o2) -> {
				if(o1[problems+2] == o2[problems+2]) {
					if(o1[problems] == o2[problems]) {
						return o1[problems+1] - o2[problems+1];
					}else {
						return o1[problems] - o2[problems];
					}
				} else return o2[problems+2]-o1[problems+2];
			});
			for(int i=0; i<teams; i++) {
				if(teamScores[i][problems+3] == id) sb.append(i+1).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}


/*
2
3 4 3 5
1 1 30
2 3 30
1 2 40
1 2 20
3 1 70
4 4 1 10
1 1 50
2 1 20
1 1 80
3 1 0
1 2 20
2 2 10
4 3 0
2 1 0
2 2 100
1 4 20

1
2
*/