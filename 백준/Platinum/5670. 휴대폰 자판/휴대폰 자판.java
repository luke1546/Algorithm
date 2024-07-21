import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        Node[] child;
        char ch;
        int size;
        boolean isEnd;

        public Node(char ch) {
            this.ch = ch;
            child = new Node[26];
            size = 0;
            isEnd = false;
        }

        public Node() {
            child = new Node[26];
            size = 0;
            isEnd = false;
        }

        public void addWord(char ch) {
            int index = ch - 'a';
            if (child[index] == null) {
                size++;
                child[index] = new Node(ch);
            }
        }

        public Node getChild(char ch) {
            int index = ch - 'a';
            return child[index];
        }

        @Override
        public String toString() {
            return ch + "";
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String> al;
    static int N;

    public static void main(String[] args) throws IOException {
        String str;
        while ((str = br.readLine()) != null) {
            try {
                N = Integer.parseInt(str);
                Node root = new Node(); // 각 테스트 케이스마다 새로운 루트 노드 생성
                Node cur = root;
                al = new ArrayList<>();
                for (int i = 0; i < N; i++) al.add(br.readLine());
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < al.get(i).length(); j++) {
                        char ch = al.get(i).charAt(j);
                        cur.addWord(ch);
                        cur = cur.getChild(ch);
                    }
                    cur.isEnd = true;
                    cur = root;
                }
                double ans = 0;
                for (int i = 0; i < N; i++) {
                    cur = root;
                    for (int j = 0; j < al.get(i).length(); j++) {
                        char ch = al.get(i).charAt(j);
                        if (j == 0) ans++;
                        else if (cur.size > 1 || cur.isEnd) ans++;
                        cur = cur.getChild(ch);
                    }
                }
                System.out.println(String.format("%.2f", ans / N));
            } catch (Exception e) {
                return;
            }
        }
    }
}
