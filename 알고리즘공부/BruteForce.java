import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BruteForce {
	static int N, R, numbers[], selected[];
	static boolean visited[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		numbers = new int[N];
		selected = new int[R];
		visited = new boolean[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++)	numbers[i] = Integer.parseInt(st.nextToken());
		
		System.out.println("--------순열--------");
		permutaion(0);
		System.out.println("--------조합--------");
		combination(0,0);
		System.out.println("--------부분조합--------");
		subcombination();
	}
	
	private static void subcombination() {
		for(int i=0; i<(1<<N); i++) {
			for(int j=0; j<N; j++) {
				if((i & 1<<j) != 0)	System.out.print(numbers[j] + " ");
			}
			System.out.println();
		}
	}
	
	private static void combination(int start, int cnt) {
		if(cnt==R) {
			System.out.println(Arrays.toString(selected));
			return;
		}
		for(int i=start; i<N; i++) {
			selected[cnt] = numbers[i];
			combination(i+1, cnt+1);
		}
	}
	
	private static void permutaion(int cnt) {
		if(cnt==R) {
			System.out.println(Arrays.toString(selected));
			return;
		}
		for(int i=0; i<N; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			selected[cnt] = numbers[i];
			permutaion(cnt+1);
			visited[i] = false;
		}
	}
}
