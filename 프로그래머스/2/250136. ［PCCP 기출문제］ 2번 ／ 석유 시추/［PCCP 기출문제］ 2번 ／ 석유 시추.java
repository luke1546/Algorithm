import java.util.*;

class Solution {
    static int R, C, dirs[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static int num = 2;
    static int map[][];
    static HashMap<Integer, Integer> hashMap = new HashMap<>();
    public int solution(int[][] land) {
        int answer = 0;
        map = land;
        R = land.length;
        C = land[0].length;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
               if(map[i][j] == 1){
                   int n = bfs(i,j);
                   hashMap.put(num, n);
                   num++;
               }
            }
        }
        for(int j=0; j<C; j++)
            answer = Math.max(answer, situ(j));
        return answer;
    }
    public static int situ(int j){
        int sum = 0;
        boolean check[] = new boolean[num];
        for(int i=0; i<R; i++){
            check[map[i][j]] = true;
        }
        for(int i=2; i<num; i++){
            if(check[i]) sum+=hashMap.getOrDefault(i,0);
        }
        return sum;
    }
    
    public static int bfs(int i, int j){
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{i,j});
        int cnt = 1;
        map[i][j] = num;
        while(!dq.isEmpty()){
            int cur[] = dq.poll();
            for(int dir[] : dirs){
                int nr = cur[0] + dir[0];
                int nc = cur[1] + dir[1];
                if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == 1){
                    dq.offer(new int[]{nr,nc});
                    map[nr][nc] = num;
                    cnt++;
                }
            }
        }
        return cnt;
    }
}