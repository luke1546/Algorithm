import java.util.*;
class Solution {
    static int R, C;
    static Deque<int[]> dq = new ArrayDeque<>();
    static int dirs[][] = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int max = 0;
        R = m;
        C = n;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                if(picture[i][j] != 0){
                    numberOfArea++;
                    System.out.println(i + " " + j + " " + picture[i][j]);
                    max = Math.max(max,bfs(i,j,picture[i][j],picture));
                }
            }
        }
        
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = max;
        return answer;
    }
    int bfs(int i, int j, int v, int[][] map){
        int cnt=0;
        dq.offer(new int[]{i,j,v});
        map[i][j] = 0;
        while(!dq.isEmpty()){
            int[] cur = dq.poll();
            cnt++;
            for(int dir[] : dirs){
                int nr = dir[0] + cur[0];
                int nc = dir[1] + cur[1];
                if(nr >=0 && nr < R && nc >= 0 && nc < C && map[nr][nc] == v){
                    dq.offer(new int[]{nr,nc,v});
                    map[nr][nc] = 0;
                }
            }
        }
        return cnt;
    }
}