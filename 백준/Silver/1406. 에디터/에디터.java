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
		Node(){}		
		Node(char c) { this.c = c; }
		Node(char c, Node left, Node right) {
			this.c = c;
			this.left = left;
			this.right = right;
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		char[] carr = br.readLine().toCharArray();
		int N = carr.length;
		int M = Integer.parseInt(br.readLine());
		Node curNode = new Node(), head = curNode;
		for(int i=0; i<N; i++) {
			Node newNode = new Node(carr[i]);
			curNode.right = newNode;
			newNode.left = curNode;
			curNode = newNode;
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			char ch = st.nextToken().charAt(0);
			if(ch == 'L' && curNode.left != null) curNode = curNode.left;
			else if(ch == 'D' && curNode.right != null) curNode = curNode.right;
			else if(ch == 'B' && curNode != head) {
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
		Node initNode = head.right;
		while(initNode != null) {
			sb.append(initNode.c);
			initNode = initNode.right;
		}
		System.out.print(sb);
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
