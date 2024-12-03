import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int map[][];
    static boolean visit[][];
    static int dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
    static int max = 0, R,C;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visit = new boolean[R][C];
        map = new int[R][C];
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<R; i++) {
            for(int j=0; j<C; j++) {
                visit[i][j] = true;
                dfs(i, j, 1, map[i][j]);
                visit[i][j] = false;
                checkExtraShapes(i, j);
            }
        }
        System.out.println(max);
    }
    private static void dfs(int i, int j, int cnt, int sum) {
        if (cnt == 4) {
            max = Math.max(max, sum);
            return;
        }
        for (int[] dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[nr][nc]) {
                visit[nr][nc] = true;
                dfs(nr, nc, cnt + 1, sum + map[nr][nc]);
                visit[nr][nc] = false;
            }
        }
    }
    private static void checkExtraShapes(int i, int j) {
        int[][][] shapes = {
            { {0, 0}, {0, -1}, {0, 1}, {-1, 0} }, // ㅗ
            { {0, 0}, {-1, 0}, {1, 0}, {0, 1} }, // ㅏ
            { {0, 0}, {0, -1}, {0, 1}, {1, 0} }, // ㅜ
            { {0, 0}, {-1, 0}, {1, 0}, {0, -1} }  // ㅓ
        };
        for (int[][] shape : shapes) {
            int sum = 0;
            boolean isValid = true;
            for (int[] s : shape) {
                int nr = i + s[0];
                int nc = j + s[1];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    sum += map[nr][nc];
                } else {
                    isValid = false;
                    break;
                }
            }
            if (isValid) {
                max = Math.max(max, sum);
            }
        }
    }
}
