import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] data = new int[N + 1];
		int[] D = new int[N + 1];
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for (int i = 1; i <= N; i++) data[i] = Integer.parseInt(st.nextToken());

		D[1] = 0; 
		for (int i = 2; i <= N; i++) {
			int j = i - 1;   // 초기 비교위치
			while (j > 0) {  // 비교 대상이 0이라면 현재 i의 앞에는 더 높은 탑이 없으므로 처리할 것이 없다.
				if (data[i] < data[j]) {	
					D[i] = j;
					break;
				}
				j = D[j];
			}
		}
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= N; i++) {
			sb.append(D[i] + " ");
		}
		System.out.print(sb);
	}
}