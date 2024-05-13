import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		int[] distance = new int[N-1];
		int[] price = new int[N];
		for(int i=0; i<N-1; i++)
			distance[i] = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++)
			price[i] = Integer.parseInt(st.nextToken());
		int index = 0;
		long ans = 0;
		long minPrice = Integer.MAX_VALUE;
		while(index < N-1) {
			minPrice = Math.min(minPrice, price[index]);
			ans+=minPrice * distance[index];
			index++;
		}
		System.out.println(ans);
	}
}

/*
4
2 3 1
5 2 4 1

18
*/
