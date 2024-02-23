import java.util.*;
class Solution {
    static ArrayDeque<Integer> dq = new ArrayDeque<>();
    static boolean[] visit;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];
        for(int i=0; i<n; i++){
            if(!visit[i]){
                dq.offer(i);
                answer++;
                bfs(n, computers);
            }
        }
        return answer;
    }
    public static void bfs(int n, int[][] computers){
        while(!dq.isEmpty()){
            int v = dq.poll();
            for(int i=0; i<n; i++){
                if(computers[v][i] == 1 && !visit[i]){
                    visit[i] = true;
                    dq.offer(i);
                }
            }
        }
    }
}