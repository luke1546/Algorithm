import java.util.*;
import java.io.*;

public class Main{
	public static class Node{
		HashMap<String, Node> childrenMap;
		public Node(){
			childrenMap = new HashMap<>();
		}
		
		public void addChild(String str){
			childrenMap.putIfAbsent(str, new Node());
		}

		public Node getChild(String str){
			return	childrenMap.get(str);
		}
	}
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static Node root = new Node();
	public static void main(String args[]) throws Exception {
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());			
			int K = Integer.parseInt(st.nextToken());
			Node cur = root;
			for(int j=0; j<K; j++){
				String str = st.nextToken();
				cur.addChild(str);
				cur = cur.getChild(str);
			}
		}
		dfs(root, 0);
		System.out.println(sb);
	}
	private static void dfs(Node cur, int depth){
		List<String> list = new ArrayList<>();
		for(String str : cur.childrenMap.keySet()){
			list.add(str);
		}
		Collections.sort(list);
		for(String str : list){
			Node temp = cur.getChild(str);
			for(int i=0; i<depth; i++) sb.append("--");
			sb.append(str+"\n");
			dfs(temp, depth+1);
		}
	}
}
