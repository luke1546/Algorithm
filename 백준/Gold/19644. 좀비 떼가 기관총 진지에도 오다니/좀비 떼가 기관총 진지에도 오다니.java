import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int range, damage, bomb, N, prefix[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		range = Integer.parseInt(st.nextToken());
		damage = Integer.parseInt(st.nextToken());
		bomb = Integer.parseInt(br.readLine());
		prefix = new int[N+range+1];
		for(int i=0; i<N; i++) {
			if(i!=0) prefix[i]+=prefix[i-1];
			int zombie = Integer.parseInt(br.readLine());
			if(zombie > damage + prefix[i]) {
				if(bomb > 0) bomb--;
				else {
					System.out.println("NO");
					return;
				}
			}else shoot(i);
		}
		System.out.println("YES");
	}
	private static void shoot(int i) {
		prefix[i]+=damage;
		prefix[i+range]-=damage;
	}
}
