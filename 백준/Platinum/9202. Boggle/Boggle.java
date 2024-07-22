import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static class Node{
		Node child[] = new Node[26];
		boolean isEnd = false;
		char ch;
		String str;
		public Node(char ch) {
			this.ch = ch;
		}
		public Node() {}
		public Node getChild(char ch) {
			return this.child[ch-'A'];
		}
		public void addChild(char ch) {
			if(this.child[ch-'A'] == null) this.child[ch-'A'] = new Node(ch);
		}
	}
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Node root = new Node();
	static int dirs[][] = {{-1,0},{-1,1},{0,1},{1,1}, {1,0},{1,-1},{0,-1},{-1,-1}};
	static List<String> list;
	static HashSet<String> answerList;
	static HashMap<Integer, Integer> scoreBoard = new HashMap<>();
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			Node cur = root;
			for(int j=0; j<str.length(); j++) {
				cur.addChild(str.charAt(j));
				cur = cur.getChild(str.charAt(j));
			}
			cur.isEnd = true;
			cur.str = str;
		}
		scoreBoard.put(1, 0);
		scoreBoard.put(2, 0);
		scoreBoard.put(3, 1);
		scoreBoard.put(4, 1);
		scoreBoard.put(5, 2);
		scoreBoard.put(6, 3);
		scoreBoard.put(7, 5);
		scoreBoard.put(8, 11);
		br.readLine();
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			answerList = new HashSet<>();
			char[][] board = new char[4][4];
			for(int i=0; i<4; i++) {
				board[i] = br.readLine().toCharArray();
			}
			
			for(int i=0; i<4; i++) {
				for(int j=0; j<4; j++) {
					Node cur = root;
					if(cur.getChild(board[i][j]) == null) continue;
					cur = cur.getChild(board[i][j]);
					boolean visit[][] = new boolean[4][4];
					visit[i][j] = true;
					dfs(cur, board, i, j, visit);
				}
			}
			ArrayList<String> al = new ArrayList<>(answerList);
			Collections.sort(al, (o1,o2) -> {
				if(o1.length() != o2.length())
				return o2.length() - o1.length();
				else return o1.compareTo(o2);
			});
			int ans = 0;
			for(int i=0; i<al.size(); i++) {
				ans += scoreBoard.get(al.get(i).length());
			}
			sb.append(ans + " " + al.get(0) + " " + al.size() + "\n");
			if(tc != T-1)br.readLine();
		}
		System.out.print(sb.toString());
	}
	private static void dfs(Node cur, char[][] board, int i, int j, boolean visit[][]) {
		if(cur.isEnd) {
			answerList.add(cur.str);
		}
		for(int dir[] : dirs) {
			int nr = i + dir[0];
			int nc = j + dir[1];
			if(nr >= 0 && nr < 4 && nc >= 0 && nc < 4 && !visit[nr][nc] && cur.getChild(board[nr][nc]) != null) {
				visit[nr][nc] = true;
				dfs(cur.getChild(board[nr][nc]), board, nr, nc, visit);
				visit[nr][nc] = false;
			}
		}
	}
}



/*
1글자, 2글자로 이루어진 단어는 0점, 3글자, 4글자는 1점, 5글자는 2점, 6글자는 3점, 7글자는 5점, 8글자는 11점

5
ICPC
ACM
CONTEST
GCPC
PROGRAMM

3
ACMA
APCA
TOGI
NEST

PCMM
RXAI
ORCN
GPCG

ICPC
GCPC
ICPC
GCPC

8 CONTEST 4
14 PROGRAMM 4
2 GCPC 2

*/