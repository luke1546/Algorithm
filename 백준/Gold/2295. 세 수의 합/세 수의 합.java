import java.io.*;
import java.util.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[N];
		int max = 0;
		HashSet<Integer> hs = new HashSet<>();
		for(int i=0; i<N; i++) {
			int n = Integer.parseInt(br.readLine());
			arr[i] = n;
		}
		for(int i=0; i<N; i++) for(int j=i; j<N; j++) hs.add(arr[i] + arr[j]);
		ArrayList<Integer> list = new ArrayList<>(hs);
		Collections.sort(list);
		for(int i=0;i<N; i++) for(int j=i; j<N; j++) if(Collections.binarySearch(list, arr[j] - arr[i]) >= 0) max = Math.max(max, arr[j]);
		System.out.print(max);
	}
}

/*
5
2
3
5
10
18

18
*/