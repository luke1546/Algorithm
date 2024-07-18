import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static class Node {
        public HashMap<Character, Node> childrenMap;
        public boolean end;

        Node() {
            end = false;
            childrenMap = new HashMap<>();
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int N = Integer.parseInt(br.readLine());
            boolean flag = false;
            Node root = new Node();
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                if (flag) continue; // 이미 flag가 true인 경우 계속해서 검사할 필요 없음
                Node cur = root;
                for (int j = 0; j < str.length(); j++) {
                    char c = str.charAt(j);
                    if (cur.childrenMap.containsKey(c) && cur.childrenMap.get(c).end) {
                        flag = true;
                        break;
                    }
                    cur = cur.childrenMap.computeIfAbsent(c, k -> new Node());
                }
                cur.end = true;
                if (cur.childrenMap.size() > 0) {
                    flag = true;
                }
            }
            if (flag) sb.append("NO\n");
            else sb.append("YES\n");
        }
        System.out.println(sb.toString());
    }
}
