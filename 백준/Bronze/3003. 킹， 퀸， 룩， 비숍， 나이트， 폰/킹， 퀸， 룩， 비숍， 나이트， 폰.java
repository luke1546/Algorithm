import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int arr[] = new int[6];
		arr[0] = 1;
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 2;
		arr[4] = 2;
		arr[5] = 8;
		for(int i=0; i<6; i++) sb.append(arr[i] - Integer.parseInt(st.nextToken())).append(" ");
		System.out.print(sb);
	}
}
