import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int N;
    static Deque<Integer> dq = new ArrayDeque<>();
    
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if(command.equals("push")) {
                int v = Integer.parseInt(st.nextToken());
                push(v);
            }
            else if(command.equals("front")) {
                if(dq.isEmpty()) sb.append("-1\n");
                else sb.append(dq.peekFirst() + "\n");
            }
            else if(command.equals("back")) {
                if(dq.isEmpty()) sb.append("-1\n");
                else sb.append(dq.peekLast() + "\n");
            }
            else if(command.equals("size")) sb.append(dq.size() + "\n");
            else if(command.equals("empty")) {
                if(dq.isEmpty()) sb.append(1 + "\n");
                else sb.append(0 + "\n");
            }
            else if(command.equals("pop")) {
                if(dq.isEmpty()) sb.append("-1\n");
                else sb.append(dq.pollFirst() + "\n");
            }
        }
        System.out.print(sb);
    }
    
    private static void push(int v) {
        dq.add(v);
    }
}
