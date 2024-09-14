import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int arr[];
	static int min = Integer.MAX_VALUE, ans, N;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			int index = Arrays.binarySearch(arr, -arr[i]);
			if(index < 0) index = (index*-1)-1;
			min(i,index);
			min(i,index+1);
			min(i, index-1);
		}
		bw.write(String.valueOf(ans));
		bw.flush();
	}
	private static void min(int i, int j) {
		if(j >= 0 && j < N && i != j) {
			int v = Math.abs(arr[i] + arr[j]);
			if(min > v) {
				min = v;
				ans = arr[i] + arr[j];
			}
		}
	}
}
