import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,R, selected[], map[][], min = Integer.MAX_VALUE;
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		R = N/2;
		selected = new int[R];
		visit = new boolean[N];
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		조합(0,0);
		System.out.println(min);
	}
	private static void 조합(int start, int cnt) {
		if(cnt == R) {
			min = Math.min(min, getDifference(selected));
			return;
		}
		for(int i=start; i<N; i++) {
			if(visit[i]) continue;
			visit[i] = true;
			selected[cnt] = i;
			if(cnt == 0 && i > 0) return;
			조합(i+1, cnt+1);
			visit[i] = false;
		}
	}
	private static int getDifference(int[] arr1) {
		boolean[] check = new boolean[N];
		ArrayList<Integer> list1 = new ArrayList<>();
		ArrayList<Integer> list2 = new ArrayList<>();
		for(int i=0; i<R; i++) check[arr1[i]] = true;
		
		for(int i=0; i<N; i++) {
			if(check[i]) list1.add(i);
			else list2.add(i);
		}
		int sum1 = 시너지(list1);
		int sum2 = 시너지(list2);
		return Math.abs(sum1-sum2);
	}
	private static int 시너지(ArrayList<Integer> list) {
		int sum = 0;
		for(int i=0; i<list.size(); i++) {
			for(int j=0; j<list.size(); j++) {
				if(i!=j) sum+=map[list.get(i)][list.get(j)];
			}
		}
		return sum;
	}
}
