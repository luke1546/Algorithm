import java.util.*;
import java.io.*;
public class Main{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int T = Integer.parseInt(st.nextToken());
        for(int tc=0; tc<T; tc++){
        	PriorityQueue<Long> pq = new PriorityQueue<>();
            long ans = 0;
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            for(int i=0; i<N; i++)	pq.offer(Long.parseLong(st.nextToken()));
            while(pq.size() > 1){
                long a = pq.poll();
                long b = pq.poll();
                ans += (a+b);
                pq.offer(a+b);
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }
}