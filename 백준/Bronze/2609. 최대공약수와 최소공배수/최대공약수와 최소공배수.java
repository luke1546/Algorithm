import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int 최대 = 최대공약수(a,b);
		int 최소 = a*b/최대;
		System.out.println(최대);
		System.out.println(최소);
	}

	private static int 최대공약수(int a, int b) {
		if(b == 0) return a;
		else return 최대공약수(b,a%b);
	}
}

/*
24 18

6
72
*/