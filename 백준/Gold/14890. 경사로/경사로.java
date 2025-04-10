import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, L, map[][];
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = 0;
		for(int i=0; i<N; i++) {
			if(lineCheck(i, false)) ans++;
		}
		for(int i=0; i<N; i++) {
			if(lineCheck(i, true)) ans++;
		}
		System.out.println(ans);
	}
	private static boolean lineCheck(int i, boolean flag) {
		ArrayDeque<Integer> stack = new ArrayDeque<>();
		ArrayDeque<int[]> need = new ArrayDeque<>();
		int before = -1;
		int temp = 0;
		int n = 0;
		for(int j=0; j<N; j++) {
			if(flag) n = map[j][i];
			else n = map[i][j];
			//필요한게 있을 경우
			if(!need.isEmpty()) {
				int cur[] = need.poll();
				if(cur[0] != n) return false;
				else if(cur[1] > 1) {
					need.push(new int[] {cur[0], cur[1]-1});
				}
			}
			//쌓아온게 없는경우
			else if(before == -1){
				stack.push(n);
			}else {
				if(n == before) stack.push(n);
				else if(n == before+1) {
					for(int x=0; x<L; x++) {
						if(stack.isEmpty()) return false;
						if(stack.pop() != before) return false;
					}
					stack.clear();
					stack.push(n);
				}else if(n+1 == before) {
					if(L > 1)
						need.push(new int[] {n, L-1});
				}else {
					return false;
				}
			}
			before = n;
			
		}
		if(!need.isEmpty()) return false;
		return true;
	}
}

/*
6 2
3 3 3 3 3 3
2 3 3 3 3 3
2 2 2 3 2 3
1 1 1 2 2 2
1 1 1 3 3 1
1 1 2 3 3 2

3
*/