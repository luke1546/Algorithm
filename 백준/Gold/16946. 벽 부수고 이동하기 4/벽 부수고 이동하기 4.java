import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.StringTokenizer;
public class Main{
	static int N, M, map[][], ans[][], dirs[][] = {{-1,0},{0,1},{1,0},{0,-1}};
	static ArrayList<Integer> al = new ArrayList<>();
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		ans = new int[N][M];
		al.add(0);
		al.add(0);
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			for(int j=0; j<M; j++)	map[i][j] = str.charAt(j)-'0';
		}
		
		int index = 2;
		
		//실험할 코드 추가
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				if(map[i][j] == 0) BFS(i,j,index++);
		
		
		
//		long beforeTime, afterTime, secDiffTime;
//		beforeTime = System.currentTimeMillis(); //코드 실행 전에 시간 받아오기
		for(int i=0; i<N; i++)
			for(int j=0; j<M; j++)
				if(map[i][j] == 1)	ans[i][j] = getCanGo(i,j);
//		afterTime = System.currentTimeMillis(); // 코드 실행 후에 시간 받아오기
//		secDiffTime = (afterTime - beforeTime); //두 시간에 차 계산
//		System.out.println("시간차이GETCANGO : "+secDiffTime);
		
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++)
				sb.append(ans[i][j]);
			sb.append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
//		for(int i[] : map)	System.out.println(Arrays.toString(i));
//		System.out.println(al);
	}
	private static int getCanGo(int i, int j) {
		int cnt = 0;
		HashMap<Integer, Boolean> hm = new HashMap<>();
		for(int dir[] : dirs) {
			int nr = i+dir[0];
			int nc = j+dir[1];
			if(nr < N && nr >= 0 && nc < M && nc >= 0 && map[nr][nc] != 1 && !hm.containsKey(map[nr][nc])) {
				hm.put(map[nr][nc], true);
				cnt += al.get(map[nr][nc]);
			}
		}
		return (cnt+1)%10;
	}
	private static void BFS(int i, int j, int index) {
		Deque<int[]> dq = new ArrayDeque<int[]>();
		dq.offer(new int[] {i,j});
		map[i][j] = index;
		int cnt = 1;
		while(!dq.isEmpty()) {
			int cur[] = dq.poll();
			for(int dir[] : dirs) {
				int nr = cur[0]+dir[0];
				int nc = cur[1]+dir[1];
				if(nr < N && nr >= 0 && nc < M && nc >= 0 && map[nr][nc] == 0) {
					cnt++;
					map[nr][nc]=index;
					dq.offer(new int[] {nr,nc});
				}
			}
		}
		al.add(cnt);
	}
}