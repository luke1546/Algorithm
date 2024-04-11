import java.util.*;
class Solution {
    static int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    static String map[][];
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for(int i=0; i<5; i++){
            int max=1;
            map = new String[5][5];
            for(int j=0; j<5; j++){
                map[j] = places[i][j].split("");
                
            }
            // System.out.println(Arrays.deepToString(map));
            
            for(int x=0; x<5; x++){
                for(int y=0; y<5; y++){
                    if(map[x][y].equals("P")){
                        max = Math.min(max,bfs(x,y));
                    }
                    
                }
            }
            answer[i] = max;
        }
        
        return answer;
    }
    
    int bfs(int x, int y){
        Deque<int[]> dq = new ArrayDeque<>();
        boolean[][] visit = new boolean[5][5];
        dq.offer(new int[]{x,y,0});
        visit[x][y] = true;
        while(!dq.isEmpty()){
            int cur[] = dq.poll();
            // System.out.println(map[cur[0]][cur[1]]);
            if(cur[2] != 0 && cur[2] <= 2 && map[cur[0]][cur[1]].equals("P")) {
                // System.out.println(cur[0] + "  " + cur[1]);
                return 0;
            }
            else if(cur[2] == 2) continue;
            for(int dir[] : dirs){
                int nr = cur[0] + dir[0];
                int nc = cur[1] + dir[1];
                if(nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && !map[nr][nc].equals("X") && !visit[nr][nc]){
                    dq.offer(new int[]{nr,nc,cur[2]+1});
                    visit[nr][nc] = true;
                }
            }
        }
        return 1;
    }
}