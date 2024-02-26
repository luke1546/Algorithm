import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] time = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken());
			start = (start/100 - 10) *60 + (start%100 - 10);
			int end = Integer.parseInt(st.nextToken());
			end = (end/100 - 10) * 60 + (end%100 + 10);
			time[i][0] = start;
			time[i][1] = end;
		}
		Arrays.sort(time, (o1,o2) -> o1[0]-o2[0]);
		int max = time[0][0];
		int endTime = time[0][1];
		for(int i=0; i<N-1; i++) {
			max = Math.max(max, time[i+1][0] - endTime);
			endTime = Math.max(endTime, time[i+1][1]);
		}
		max = Math.max(max, 720-endTime);
		System.out.println(max);
	}
}
