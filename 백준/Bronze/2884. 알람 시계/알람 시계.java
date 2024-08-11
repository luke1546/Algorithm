import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int hour = Integer.parseInt(st.nextToken());
		int minute = Integer.parseInt(st.nextToken());
		minute += 15;
		int x = minute/60;
		minute%=60;
		hour = hour + 23 + x;
		hour%=24;
		System.out.println(hour + " " + minute);
	}
}
/*
10 10

9 25
*/