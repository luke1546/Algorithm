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
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		int box[] = new int[N];
		Arrays.fill(box, Integer.MAX_VALUE);
		for(int i=0; i<N; i++) {
			int count = 0;
			for(int j=0; j<N; j++) {
				if(count == arr[i] && box[j] == Integer.MAX_VALUE) {
					box[j] = i+1;
					break;
				}
				if(box[j] > i+1) count++;
			}
		}
		for(int i : box) sb.append(i+" ");
		System.out.println(sb);
	}
}

/*
7
6 1 1 1 2 0 0

6 2 3 4 7 5 1
*/