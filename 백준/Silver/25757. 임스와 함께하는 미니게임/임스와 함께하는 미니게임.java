import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int N, ans=0;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		char game = st.nextToken().charAt(0);
		if(game == 'Y') playGame(2);
		if(game == 'F') playGame(3);
		if(game == 'O') playGame(4);
		System.out.println(ans);
	}
	private static void playGame(int n) throws IOException {
		HashMap<String, Boolean> hm = new HashMap<>();
		int count = 0;
		for(int i=0; i<N; i++) {
			String person = br.readLine();
			if(hm.containsKey(person)) continue;
			else {
				hm.put(person, true);
				count++;
			}
			if(count == n-1) {
				count = 0;
				ans++;
			}
		}
	}
}

/*
7 Y
lms0806
lms0806
exponentiale
lms0806
jthis
lms0806
leo020630

4

Y F O : 2 3 4
*/