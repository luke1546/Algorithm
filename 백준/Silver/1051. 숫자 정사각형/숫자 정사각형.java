import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int R, C, ans = 0;
	static String arr[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new String[R][C];
		for(int i=0; i<R; i++) arr[i] = br.readLine().split("");
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				for(int k=j+1; k<C; k++) {
					if(arr[i][j].equals(arr[i][k])) {
						isSquare(i, j , k-j);
					}
				}
			}
		}
		System.out.println((ans+1)*(ans+1));
	}
	private static void isSquare(int i, int j, int k) {
		if(i+k < R && j+k < C && arr[i][j].equals(arr[i+k][j]) && arr[i][j].equals(arr[i][j+k]) && arr[i][j].equals(arr[i+k][j+k])) ans = Math.max(ans, k);
	}
}
