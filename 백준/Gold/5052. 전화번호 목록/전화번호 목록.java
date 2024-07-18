import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			HashSet<String> hs = new HashSet<>();
			boolean flag = false;
			String strs[] = new String[N];
			for(int i=0; i<N; i++) strs[i] = br.readLine();
			Arrays.sort(strs, (o1,o2) -> o1.length() - o2.length());
			for(int i=0; i<N; i++) {
				StringBuilder sb2 = new StringBuilder();
				String str = strs[i];
				for(int j=0; j<str.length(); j++) {
					sb2.append(str.charAt(j));
					if(hs.contains(sb2.toString())) flag = true;
				}
				hs.add(str);
			}
			if(flag) sb.append("NO\n");
			else sb.append("YES\n");
		}
		System.out.println(sb.toString());
	}
}

/*
2
3
911
97625999
91125426
5
113
12340
123440
12345
98346

NO
YES
*/