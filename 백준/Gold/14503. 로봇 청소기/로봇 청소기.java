import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int R, C, map[][], dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		R = Integer.parseInt(str[0]);
		C = Integer.parseInt(str[1]);
		map = new int[R][C];
		str = br.readLine().split(" ");
		int r = Integer.parseInt(str[0]);
		int c = Integer.parseInt(str[1]);
		int d = Integer.parseInt(str[2]);
		for (int i = 0; i < R; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < C; j++)
				map[i][j] = Integer.parseInt(str[j]);
		}
		
		int ans=0;
		while(true) {
			if(map[r][c] == 0)	{
				map[r][c] = 2;
				ans++;
			}
			if(청소영역사방탐색(r,c,d)) {
				for(int i=0; i<4; i++) {
					d=(d+3)%4;	//반시계 90도 회전
					if(전방탐색(r,c,d)) {
						r+=dirs[d][0];
						c+=dirs[d][1];
						break;
					}
				}
			}else {
				if(후방탐색(r,c,d)) {
					int rd = (d+2)%4;
					r+=dirs[rd][0];
					c+=dirs[rd][1];
				}
				else	break;
			}
		}
		System.out.println(ans);
//		System.out.println(Arrays.deepToString(map));
	}
	private static boolean 후방탐색(int r, int c, int d) {
		int rd = (d+2)%4;
		int nr = r+dirs[rd][0];
		int nc = c+dirs[rd][1];
		if(nr >= 0 && nr < R && nc>=0 && nc < C)
			if(map[nr][nc] == 0 || map[nr][nc] == 2) return true;
		return false;
	}
	private static boolean 전방탐색(int r, int c, int d) {
		int nr = r+dirs[d][0];
		int nc = c+dirs[d][1];
		if(nr >= 0 && nr < R && nc>=0 && nc < C)
			if(map[nr][nc] == 0) return true;
		return false;
	}
	private static boolean 청소영역사방탐색(int r, int c, int d) {
		for(int dir[] : dirs) {
			int nr = r+dir[0];
			int nc = c+dir[1];
			if(nr >= 0 && nr < R && nc>=0 && nc < C)
				if(map[nr][nc] == 0)	return true;
		}
		return false;
	}
}
