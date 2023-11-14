import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		ArrayDeque<int[]> dq = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		int arr[] = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++)	arr[i] = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			if(!dq.isEmpty() && dq.peekFirst()[1] < (i-L+1)) dq.pollFirst();
			while(!dq.isEmpty() && dq.peekLast()[0] >= arr[i])	dq.pollLast();
			dq.offer(new int[] {arr[i],i});
			bw.write(dq.peekFirst()[0] + " ");
		}
		bw.flush();
	}
}