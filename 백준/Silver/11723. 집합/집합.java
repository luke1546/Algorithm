import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static HashSet<Integer> hs = new HashSet<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			String str = st.nextToken();
			if(str.equals("add")) add(Integer.parseInt(st.nextToken()));
			else if(str.equals("remove")) remove(Integer.parseInt(st.nextToken()));
			else if(str.equals("check")) check(Integer.parseInt(st.nextToken()));
			else if(str.equals("toggle")) toggle(Integer.parseInt(st.nextToken()));
			else if(str.equals("all")) all();
			else empty();
		}
		System.out.println(sb.toString());
	}

	private static void empty() {
		hs = new HashSet<Integer>();
	}

	private static void all() {
		for(int i=1; i<=20; i++) hs.add(i);
	}

	private static void toggle(int v) {
		if(hs.contains(v)) hs.remove(v);
		else hs.add(v);
	}

	private static void remove(int v) {
		hs.remove(v);
	}

	private static void check(int v) {
		if(hs.contains(v)) sb.append(1).append("\n");
		else sb.append(0).append("\n");
	}
	private static void add(int v) {
		hs.add(v);
	}
}
