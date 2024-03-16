import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N, M, r, c, Manacher[][], arr[];
	static StringTokenizer st;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		arr = new int[N*2+1];
		dummy();
		M = Integer.parseInt(br.readLine());
		Manacher = new int[arr.length][3];
		for(int i=1; i<arr.length; i++) {
			r = Manacher[i-1][1];
			c = Manacher[i-1][2];
			int index = FindIndexByManacher(i) + 1;
			while(i-index >= 0 && i+index < arr.length && arr[i-index] == arr[i+index]) {
				index++;
			}
			int p = i+index-1;
			Manacher[i][0] = index-1;
			if(p > r) {
				Manacher[i][1] = p;
				Manacher[i][2] = i;
			}else {
				Manacher[i][1] = r;
				Manacher[i][2] = c;
			}
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()) *2 -1;
			int b = Integer.parseInt(st.nextToken()) *2 -1;
			int c = (a+b)/2;
			if(Manacher[c][0] >= b-c) sb.append(1).append("\n");
			else sb.append(0).append("\n");
		}
		System.out.println(sb.toString());
	}
	private static int FindIndexByManacher(int i) {
		if(i > r) return 0; 
		return Math.min(Manacher[c*2-i][0], r-i);
	}
	private static void dummy() throws IOException {
		StringBuilder sb = new StringBuilder();
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr[i*2] = -1;
			arr[i*2+1] = Integer.parseInt(st.nextToken());
		}
		arr[2*N] = -1;
	}
}
