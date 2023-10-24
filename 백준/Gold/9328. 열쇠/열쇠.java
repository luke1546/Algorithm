import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	static int T, R, C, ans = 0, dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static char[][] map;
	static boolean[][] visit;
	static HashMap<Character, Character> keyMap = new HashMap<>();
	static HashMap<Character, ArrayList<Integer>> doorMap = new HashMap<>();
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			map = new char[R+2][C+2];
			visit = new boolean[R+2][C+2];
			int x[];
			for(int i=0; i<R+2; i++)	Arrays.fill(map[i], '.');
			for(int i=1; i<R+1; i++) {
				String str = br.readLine();
				for(int j=1; j<C+1; j++) {
					if(str.charAt(j-1) != '.')	map[i][j] = str.charAt(j-1);
					if(str.charAt(j-1) >= 65 && str.charAt(j-1) <= 90)	{
						if(doorMap.containsKey(str.charAt(j-1))) {
							doorMap.get(str.charAt(j-1)).add(i);
							doorMap.get(str.charAt(j-1)).add(j);
						}
						else	{
							doorMap.put(str.charAt(j-1), new ArrayList<Integer>());
							doorMap.get(str.charAt(j-1)).add(i);
							doorMap.get(str.charAt(j-1)).add(j);
						}
					}
				}
			}
			
			String key = br.readLine();
			if(!key.equals("0")) {
				for(int i=0; i<key.length(); i++)	keyMap.put((char)(key.charAt(i)-32), '.');
			}
			bfs(0,0);
//			for(char[] i : map) System.out.println(Arrays.toString(i));
			System.out.println(ans);
			ans=0;
			keyMap.clear();
			doorMap.clear();
		}
	}
	private static void bfs(int i, int j) {
		ArrayList<Integer> temp;
		Deque<int[]> dq = new ArrayDeque<int[]>();
		dq.offer(new int[] {i,j});
		visit[i][j] = true;
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
			for(int dir[] : dirs) {
				int nr = dir[0] + cur[0];
				int nc = dir[1] + cur[1];
				if(nr >= 0 && nr < R+2 && nc >= 0 && nc < C+2 && !visit[nr][nc]) {
					if(map[nr][nc] == '.') {
						visit[nr][nc] = true;
						dq.offer(new int[] {nr,nc});
					}else if(map[nr][nc] == '$') {
						map[nr][nc] = '.';
						visit[nr][nc] = true;
						dq.offer(new int[] {nr,nc});
						ans++;
					}else if(map[nr][nc] == '*') continue;
					else if(map[nr][nc] != '*') {
						if(keyMap.containsKey(map[nr][nc])) {	
							map[nr][nc] = '.';
							visit[nr][nc] = true;
							dq.offer(new int[] {nr,nc});
						}
						else if(map[nr][nc] > 96) {
							visit[nr][nc] = true;
							dq.offer(new int[] {nr,nc});
							keyMap.put((char)(map[nr][nc]-32), '.');
							map[nr][nc] = '.';
							for(char key : doorMap.keySet()) {
								if(keyMap.containsKey(key)) { 
									for(int c=0; c<R+2; c++)	Arrays.fill(visit[c], false);
									
									temp = doorMap.get(key);
									for(int z=0; z<temp.size(); z+=2) {
										map[temp.get(z)][temp.get(z+1)] = '.';
									}
									dq.offer(new int[] {nr,nc});
									visit[nr][nc] = true;
								}
							}
						}
					}
				}
			}
		}
	}
}
