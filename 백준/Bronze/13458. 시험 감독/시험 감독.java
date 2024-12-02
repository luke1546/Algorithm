import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		long cnt = N;
		st = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) arr[i] -= B;
		for(int i=0; i<N; i++) {
			if(arr[i] > 0) cnt+=Math.ceil(arr[i]/(double)C);
		}
		System.out.println(cnt);
	}
}

/*
5
10 9 10 9 10
7 20

10
*/