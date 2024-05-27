import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static class Node{
		Node right;
		Node left;
		char c;
		public Node(char c) {
			this.c = c;
		}
		public Node(char c, Node left, Node right) {
			this.c = c;
			this.left = left;
			this.right = right;
		}
		@Override
		public String toString() {
			return this.c+"";
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		int N = str.length();
		int M = Integer.parseInt(br.readLine());
		ArrayList<Node> nodes = new ArrayList<>();
		nodes.add(new Node(' '));
		for(int i=0; i<N; i++) nodes.add(new Node(str.charAt(i)));
		nodes.get(0).right = nodes.get(1);
		nodes.get(N).left = nodes.get(N-1);
		nodes.get(0).left = null;
		nodes.get(N).right = null;
		for(int i=1; i<N; i++) {
			nodes.get(i).left = nodes.get(i-1);
			nodes.get(i).right = nodes.get(i+1);
		}
		Node curNode = nodes.get(N);
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char ch = st.nextToken().charAt(0);
			if(ch == 'L' && curNode.left != null) curNode = curNode.left;
			else if(ch == 'D' && curNode.right != null) curNode = curNode.right;
			else if(ch == 'B' && curNode.c != ' ') {
				Node rightNode = curNode.right;
				curNode = curNode.left;
				curNode.right = rightNode;
				if(rightNode != null) rightNode.left = curNode;
			}else if(ch == 'P') {
				Node rightNode = curNode.right;
				Node newNode = new Node(st.nextToken().charAt(0), curNode, rightNode);
				curNode.right = newNode;
				curNode = newNode;
				if(rightNode != null) rightNode.left = newNode;
			}
		}
		Node initNode = nodes.get(0);
		while(initNode != null) {
			sb.append(initNode.c);
			initNode = initNode.right;
		}
		sb.delete(0,1);
		System.out.println(sb);
	}
}

/*
abcd
3
P x
L
P y

abcdyx
*/
