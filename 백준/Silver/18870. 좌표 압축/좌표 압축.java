import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int[] arr1 = new int[N];
		HashSet<Integer> hs = new HashSet<>();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			arr1[i] = Integer.parseInt(st.nextToken());
			hs.add(arr1[i]);
		}
		ArrayList<Integer> al = new ArrayList<>(hs);
		Collections.sort(al);
		for(int i=0; i<N; i++)	sb.append(Collections.binarySearch(al, arr1[i])).append(" ");
		System.out.println(sb.toString());
	}
}
