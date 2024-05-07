import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		int arr[] = new int[M];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<M; i++)	arr[i] = Integer.parseInt(st.nextToken());
		int max = arr[0];
		max = Math.max(max, N-arr[arr.length-1]);
		for(int i=1; i<M; i++)	max = Math.max((arr[i]-arr[i-1]+1)/2, max);
		System.out.println(max);
	}
}


/*
5
2
2 4

2
*/