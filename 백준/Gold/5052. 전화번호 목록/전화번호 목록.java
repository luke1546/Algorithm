import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static class Node{
		public HashMap<Character, Node> childrenMap;
		public char c;
		public boolean end;
		Node(char c){
			this.c = c;
			end = false;
			childrenMap = new HashMap<>();
		}
		Node(){
			end = false;
			childrenMap = new HashMap<>();
		}
//		public boolean find(char c) {
//			Node node = new Node(c);
//		}
		
		@Override
		public boolean equals(Object obj) {
			Node node = (Node)obj;
			return this.c == node.c;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			boolean flag = false;
			String strs[] = new String[N];
			Node root = new Node();
			for(int i=0; i<N; i++) strs[i] = br.readLine();
			Arrays.sort(strs, (o1,o2) -> o1.length() - o2.length());
			for(int i=0; i<N; i++) {
				Node cur = root;
				String str = strs[i];
				for(int j=0; j<str.length(); j++) {
					char c = str.charAt(j);
					if(cur.end) flag = true;
					if(!cur.childrenMap.containsKey(c)) cur.childrenMap.put(c, new Node(c));
					cur = cur.childrenMap.get(c);
				}
				cur.end = true;
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
