import java.util.*;

class Solution {
    static int ans = Integer.MAX_VALUE;
    static int dirs[][] = {{-1,0}, {0,1},{1,0},{0,-1}};
    static int R,C;
    public int solution(int[][] maps) {
        R = maps.length;
        C = maps[0].length;
        bfs(maps);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    
    public static void bfs(int[][] map)
    {
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0,0,1});
        while(!dq.isEmpty()){
            int cur[] = dq.poll();
            if(cur[0] == R-1 && cur[1] == C-1){
                ans = Math.min(ans, cur[2]);
                continue;
            }
            for(int dir[] : dirs){
                int nr = dir[0] + cur[0];
                int nc = dir[1] + cur[1];
                if(nr >=0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 1){
                    map[nr][nc] = 0;
                    dq.offer(new int[]{nr, nc, cur[2]+1});
                }
            }
        }
    }
}