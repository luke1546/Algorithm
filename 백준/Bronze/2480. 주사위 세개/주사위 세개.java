import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		int arr[] = new int[7];
		arr[Integer.parseInt(st.nextToken())]++;
		arr[Integer.parseInt(st.nextToken())]++;
		arr[Integer.parseInt(st.nextToken())]++;
		int max = 0;
		for(int i=1; i<7; i++) {
			if(arr[i] == 1) max = i;
			else if(arr[i] > 1) {
				max = i;
				break;
			}
		}
		if(arr[max] == 1) bw.write(String.valueOf(max*100));
		else if(arr[max] == 2) bw.write(String.valueOf(max*100 + 1000));
		else bw.write(String.valueOf(max*1000 + 10000));
		bw.flush();
	}
}
