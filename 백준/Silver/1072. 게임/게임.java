import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		boolean flag = true;
		long cnt = 0;
		st = new StringTokenizer(br.readLine());
		long X = Long.parseLong(st.nextToken());
		long Y = Long.parseLong(st.nextToken());
		long winRate = Y*100/X;
		if(winRate >= 99) flag = false;
		long start = Y;
		long end = X*2;
		while(start <= end) {
			long mid = (start+end)/2;
			if(mid*100/(X+mid-Y) > winRate) {
				end = mid-1;
				cnt = mid-Y;
			}else {
				start = mid+1;
			}
		}
		if(flag) System.out.println(cnt);
		else System.out.println(-1);
	}
}

/*
100 80

6
*/
