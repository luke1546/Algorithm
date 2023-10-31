import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int score[] = new int[1000001];
		int[] arr = new int[N];
		boolean value[] = new boolean[1000001];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			value[arr[i]] = true;
		}
		for(int i=0; i<N; i++) {
			for(int j = arr[i]*2; j<1000001; j+=arr[i]) {
				if(value[j]) {
					score[j]--;
					score[arr[i]]++;
				}
			}
		}
		for(int i=0; i<N; i++)	sb.append(score[arr[i]]+" ");	
		System.out.println(sb.toString());
	}
}
