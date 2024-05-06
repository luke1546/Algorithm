import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int arr[] = new int[N];
			int team[][] = new int[201][5];
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
			for(int i=0; i<N; i++) team[arr[i]][0]++;
			for(int i=0; i<201; i++) team[i][4] = i;
			int rank=1;
			for(int i=0; i<N; i++) {
				if(team[arr[i]][0] == 6) {
					if(team[arr[i]][2] < 4) {
						team[arr[i]][1] += rank;
					}else if(team[arr[i]][2] == 4) {
						team[arr[i]][3] = rank;
					}
					team[arr[i]][2]++;
					rank++;
				}
			}
			for(int i=0; i<201; i++) {
				if(team[i][1] == 0) team[i][1] = Integer.MAX_VALUE;
			}
			Arrays.sort(team, (o1,o2) -> 
				o1[1]!=o2[1] ? o1[1]-o2[1] : o1[3]-o2[3]
			);
//			Arrays.sort(team, (o1,o2) -> 
	//		o1[1]-o2[1]
		//);
			System.out.println(team[0][4]);
		}
	}
}
/*
 0 : 인원수
 1 : 4명의 점수
 2 : 현재 인원수
 3 : 5번째 선수의 등수
 */


/*
2
15
1 2 3 3 1 3 2 4 1 1 3 1 3 3 1
18
1 2 3 1 2 3 1 2 3 3 3 3 2 2 2 1 1 1

1
3
*/