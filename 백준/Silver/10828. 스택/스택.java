import java.io.*;
import java.util.*;

public class Main {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(st.nextToken());
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for(int i=0; i<tc; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();
			if(s.equals("push")) {
				dq.push(Integer.parseInt(st.nextToken()));
			}else if(s.equals("pop")) {
				if(dq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(dq.pop()).append("\n");
			}else if(s.equals("size")) {
				sb.append(dq.size()).append("\n");
			}else if(s.equals("empty")){
				if(dq.isEmpty()) sb.append(1).append("\n");
				else sb.append(0).append("\n");
			}else if(s.equals("top")) {
				if(dq.isEmpty()) sb.append(-1).append("\n");
				else sb.append(dq.peek()).append("\n");
			}
		}
		System.out.println(sb.toString());
	}
}

/*
14
push 1
push 2
top
size
empty
pop
pop
pop
size
empty
pop
push 3
empty
top

2
2
0
2
1
-1
0
1
-1
0
3
*/