import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		double ans = 0;
		ArrayList<Double> al = new ArrayList<>();
		double max = 0;
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			al.add(Double.parseDouble(st.nextToken()));
		}
		max = Collections.max(al);
		for(int i=0; i<N; i++) {
			ans += al.get(i) / max;
		}
		System.out.println(ans/N*100);
	}
}
