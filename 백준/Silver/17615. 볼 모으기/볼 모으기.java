import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N,min;
	static char[] arr;
	public static void main(String[] args) throws IOException {
		N = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		arr = br.readLine().toCharArray();
		collect(true);
		collect(false);
		System.out.println(min);
	}
	private static void collect(boolean b) {
		int x, rc = 0, bc = 0;
		boolean rFlag = false, bFlag = false;
		for(int i=0; i<N; i++) {
			if(b) x = i;
			else x = N-i-1;
			if(arr[x] == 'R') {
				bFlag = true;
				if(rFlag) rc++;
			}else {
				rFlag = true;
				if(bFlag) bc++;
			}
		}
		min = Math.min(min, rc);
		min = Math.min(min, bc);
	}
}

/*
9
RBBBRBRRR

2
*/