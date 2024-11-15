import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int M = 0;
		int[] A = new int[N];
		int x = 0;
		int index = 0;
		
		for (int i = 0; i < N; i++) A[i] = Integer.parseInt(st.nextToken());
		Arrays.sort(A);
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			x = Integer.parseInt(st.nextToken());
			index = Arrays.binarySearch(A, x);
			if(index>=0) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		System.out.println(sb.toString());
	}
}