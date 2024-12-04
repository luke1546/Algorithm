import java.util.*;
import java.io.*;

public class Main {
	static int R, C, map[][], dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static int max = 0;
	static int shapes[][][] = {
	{{0,0},{-1,0},{0,-1},{0,1}}, //ㅗ
	{{0,0},{1,0},{0,-1},{0,1}}, //ㅜ
	{{0,0},{-1,0},{1,0},{0,-1}}, //ㅓ
	{{0,0},{-1,0},{1,0},{0,1}}  //ㅏ
	};
	static boolean visit[][];
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		visit = new boolean[R][C];
		for(int i=0; i<R; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++){
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<R; i++){
			for(int j=0; j<C; j++){
				visit[i][j] = true;
				dfs(i,j,map[i][j],1);
				visit[i][j] = false;
                shapeCheck(i,j);
			}
		}
        System.out.println(max);
	}
	
	public static void dfs(int r, int c, int sum, int cnt){
		if(cnt==4){
			max = Math.max(max, sum);
			return;
		}
		for(int dir[] : dirs){
			int nr = dir[0] + r;
			int nc = dir[1] + c;
			if(nr >= 0 && nr < R && nc >= 0 && nc < C && !visit[nr][nc]){
				visit[nr][nc] = true;
				dfs(nr,nc,sum+map[nr][nc],cnt+1);
				visit[nr][nc] = false;
			}
		}
	}
	
	public static void shapeCheck(int r, int c){
		int sum = 0;
		for(int[][] shape : shapes){
			for(int s[] : shape){
				int nr = s[0] + r;
				int nc = s[1] + c;
				if(nr >= 0 && nr < R && nc >= 0 && nc < C){
					sum+=map[nr][nc];
				}
			}
			max = Math.max(max, sum);
			sum = 0;
		}
	}
}

/*
5 5
1 2 3 4 5
5 4 3 2 1
2 3 4 5 6
6 5 4 3 2
1 2 1 2 1

19
*/