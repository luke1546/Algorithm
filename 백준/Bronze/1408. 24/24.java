import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), ":");
		int now = 0;
		now+=(Integer.parseInt(st.nextToken())*3600);
		now+=(Integer.parseInt(st.nextToken())*60);
		now+=(Integer.parseInt(st.nextToken()));
		st = new StringTokenizer(br.readLine(), ":");
		int mission = 0;
		mission+=(Integer.parseInt(st.nextToken())*3600);
		mission+=(Integer.parseInt(st.nextToken())*60);
		mission+=(Integer.parseInt(st.nextToken()));
		int ans = mission-now;
		if(ans < 0) ans+=86400;
		int h = ans/3600;
		ans%=3600;
		int m = ans/60;
		ans%=60;
		int s = ans;
		if(h < 10) sb.append(0);
		sb.append(h).append(":");
		if(m<10) sb.append(0);
		sb.append(m).append(":");
		if(s<10) sb.append(0);
		sb.append(s);
		System.out.print(sb);
	}
}
