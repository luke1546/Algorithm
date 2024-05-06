import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(st.nextToken());
		int score = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		if(N != 0) {
		st = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int count = 0;
		for(int i=0; i<N; i++) if(arr[i] >= score) count++;
		if(count >= P) sb.append(-1);
		else {
			count = 0;
			for(int i=0; i<N; i++) if(arr[i] > score) count++;
			sb.append(1+count);
		}
		}
		else sb.append(1);
		System.out.println(sb.toString());
	}
}


/*
10 1 10
10 9 8 7 6 5 4 3 2 1

-1

0 0 50

1
*/