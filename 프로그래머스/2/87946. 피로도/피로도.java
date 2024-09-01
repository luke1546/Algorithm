import java.util.*;

class Solution {
    static int max = 0, N, selected[];
    static boolean visit[];
    public int solution(int k, int[][] dungeons) {
        N = dungeons.length;
        selected = new int[N];
        visit = new boolean[N];
        순열(0, dungeons, k);
        return max;
    }
    
    public static void 순열(int cnt, int[][] dungeons,int k){
        if(cnt == N){
            int ans = 0;
            for(int i=0; i<N; i++){
                if(k >= dungeons[selected[i]][0]){
                    k -= dungeons[selected[i]][1];
                    ans++;
                }
            }
            max = Math.max(max, ans);
            return;
        }
        for(int i=0; i<N; i++){
            if(visit[i]) continue;
            visit[i] = true;
            selected[cnt] = i;
            순열(cnt+1, dungeons, k);
            visit[i] = false;
        }
    }
}