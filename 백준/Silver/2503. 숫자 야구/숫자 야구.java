import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static boolean check[] = new boolean[988];
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int p = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			for(int j=123; j<988; j++) {
				if(!check[j]) check(p,j,s,b);
			}
		}
		int cnt = 0;
		for(int j=123; j<988; j++) {
			if(!check[j]) cnt++;
		}
		System.out.println(cnt);
	}
	private static void check(int p, int j, int s, int b) {
		int prediction[] = new int[3];
		int index[] = new int[3];
		int strike = 0;
		int ball = 0;
		int pTemp = p;
		int jTemp = j;
		for(int i=2; i>=0; i--) {
			prediction[i] = pTemp%10;
			index[i] = jTemp%10;
			pTemp/=10;
			jTemp/=10;
		}
		if(preCheck(index)) {
			check[j] = true;
			return;
		}
		for(int x=0; x<3; x++) {
			if(prediction[x] == index[x]) strike++;
			for(int y=0; y<3; y++) {
				if(x==y) continue;
				if(prediction[x] == index[y]) ball++;
			}
		}
		if(strike == s && ball == b) return;
		check[j] = true;
	}
	private static boolean preCheck(int[] index) {
		if(index[0] == 0|| index[1] == 0 || index[2] == 0) return true;
		if(index[0] == index[1] || index[1] == index[2] || index[2] == index[0]) return true;
		return false;
	}
}
