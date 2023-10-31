import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int lcs[] = new int[N];
		Arrays.fill(lcs, Integer.MAX_VALUE);
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++)	arr[i] = Integer.parseInt(st.nextToken());
		
		int max=0;
		for(int i=0; i<N; i++) {
			int index = Arrays.binarySearch(lcs, arr[i]);
			if(index < 0) index = (index*-1)-1;
			lcs[index] = arr[i];
			max = Math.max(max, index);
		}
		System.out.println(max+1);
	}
}
