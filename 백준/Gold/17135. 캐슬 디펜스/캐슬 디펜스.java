import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	static int R, C, range, rangeCopy, selected[], map[][], mapCopy[][], ans=0;
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	R = Integer.parseInt(st.nextToken());
    	C = Integer.parseInt(st.nextToken());
    	range = Integer.parseInt(st.nextToken());
    	rangeCopy = range;
    	map = new int[R][C];
    	mapCopy = new int[R][C];
    	selected = new int[3];
    	for(int i=0; i<R; i++) {
    		st = new StringTokenizer(br.readLine(), " ");
    		for(int j=0; j<C; j++) {
    			map[i][j] = Integer.parseInt(st.nextToken());
    		}
    	}
    	mapCopy(mapCopy, map);
    	조합(0,0);
    	System.out.println(ans);
	}
	private static void mapCopy(int[][] map1, int[][] map2) {
		for(int x=0; x<R; x++) for(int y=0; y<C; y++) map1[x][y] = map2[x][y];
	}
	private static void 조합(int start, int cnt) {
		if(cnt == 3) {
			int max = 0;
			for(int x=R-1; x>=0; x--) {
				ArrayDeque<int[]> target = new ArrayDeque<>();
				for(int i=0; i<3; i++) {
					attack(selected[i], range, target);
				}
				while(!target.isEmpty()) {
					int cur[] = target.poll();
					if(map[cur[0]][cur[1]] == 1) max++;
					map[cur[0]][cur[1]] = 0;
				}
				for(int y=0; y<C; y++) {
					map[x][y] = 0;
				}
				range++;
			}
//			System.out.println(Arrays.toString(selected) + " " + max);
			ans = Math.max(ans, max);
			mapCopy(map, mapCopy);
			range = rangeCopy;
			return;
		}
		for(int i=start; i<C; i++) {
			selected[cnt] = i;
			조합(i+1, cnt+1);
		}
	}
	private static void attack(int c, int range, ArrayDeque<int[]> target) {
		int minDis = Integer.MAX_VALUE;
		int set[] = new int[2];
		set[0] = -1;
		set[1] = -1;
		for(int i = R-1; i>=0; i--) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == 1) {
					int dis = getDis(i,j,c);
					if(dis <= range && minDis > dis) {
						minDis = dis;
						set[0] = i;
						set[1] = j;
					}
					else if(minDis == dis) {
						if(set[1] > j) {
							set[0] = i;
							set[1] = j;
						}
					}
				}
			}
		}
		if(set[0] != -1) target.add(new int[] {set[0], set[1]});
	}
	private static int getDis(int i, int j, int c) {
		return Math.abs(R-i) + Math.abs(j-c);
	}
}