import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
  static int R, C, time=0, map[][], dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
  static Deque<int[]> dq = new ArrayDeque<>();
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R  = Integer.parseInt(st.nextToken());
    C  = Integer.parseInt(st.nextToken());
    map = new int[R][C];
    for(int i=0; i<R; i++){
      st = new StringTokenizer(br.readLine());
      for(int j=0; j<C; j++){
        map[i][j] = Integer.parseInt(st.nextToken());
        if(map[i][j] != 0)
          dq.offer(new int[]{i,j});
      }
    }
    while(!dq.isEmpty() && isLinked(dq.peek())){
      time++;
      melt();
    }
    if (dq.isEmpty()) {
      System.out.println(0);
    }
    else System.out.println(time);
  }

  private static void melt() {
    Deque<int[]> tempDq = new ArrayDeque<>();
    while(!dq.isEmpty()) {
      int[] cur = dq.poll();
        int seaCnt = 0;
      for (int dir[] : dirs) {
        int nr = cur[0] + dir[0];
        int nc = cur[1] + dir[1];
        if(nr >= 0 && nr < R && nc >= 0 && nc < C && map[nr][nc] <= 0){
          seaCnt++;
        }
      }
      tempDq.offer(new int[]{cur[0],cur[1],seaCnt});
    }
//    System.out.println("전");
//    for(int i[] : map)
//      System.out.println(Arrays.toString(i));
    while(!tempDq.isEmpty()){
      int[] tcur = tempDq.poll();
      map[tcur[0]][tcur[1]] -= tcur[2];
      if(map[tcur[0]][tcur[1]] > 0)
        dq.offer(new int[]{tcur[0],tcur[1]});
    }
//    for(int i[] : map)
//      System.out.println(Arrays.toString(i));
  }

  private static boolean isLinked(int[] peek) {
    int cnt = 1;
    boolean[][] visit = new boolean[R][C];
    Deque<int[]> dq2 = new ArrayDeque<>();
    dq2.offer(peek);
    visit[peek[0]][peek[1]] = true;
    while(!dq2.isEmpty()) {
      int[] cur = dq2.poll();
      for (int[] dir : dirs) {
        int nr = cur[0] + dir[0];
        int nc = cur[1] + dir[1];
        if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[nr][nc] && map[nr][nc] > 0) {
          visit[nr][nc] = true;
          dq2.offer(new int[]{nr, nc});
          cnt++;
        }
      }
    }
//    System.out.println(cnt + " " + dq.size());
    if(dq.size() == cnt) return true;
    else return false;
  }
}

/*
5 7
0 0 0 0 0 0 0
0 2 4 5 3 0 0
0 3 0 2 5 2 0
0 7 6 2 4 0 0
0 0 0 0 0 0 0
 */