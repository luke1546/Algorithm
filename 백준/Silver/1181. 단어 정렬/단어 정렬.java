import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		HashSet<String> hs = new HashSet<>();
		for(int i=0; i<n; i++) {
			hs.add(br.readLine());
		}
		ArrayList<String> list = new ArrayList<>(hs);
		Collections.sort(list, (o1,o2) -> {
			if(o1.length() == o2.length())
			return o1.compareTo(o2);
			else return o1.length()-o2.length();
		});
		for(String str : list) sb.append(str).append("\n");
		System.out.print(sb);
	}
}
