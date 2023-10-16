import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[];
		int N = Integer.parseInt(br.readLine());	//전깃줄의 갯수
		int[][] 전깃줄 = new int[N][2];
        StringTokenizer st;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			전깃줄[i][0] = Integer.parseInt(st.nextToken());
			전깃줄[i][1] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(전깃줄,(o1,o2) -> o1[0]-o2[0]);
		
		int[] 최장증가수열 = new int[N];
		Arrays.fill(최장증가수열, Integer.MAX_VALUE);
		int max = 0;
		for(int i=0; i<N; i++) {
			int index = (Arrays.binarySearch(최장증가수열, 전깃줄[i][1])*-1)-1;
			최장증가수열[index] = 전깃줄[i][1];
			max = Math.max(max, index);
		}
		System.out.println(전깃줄.length - (max+1));
	}
}
