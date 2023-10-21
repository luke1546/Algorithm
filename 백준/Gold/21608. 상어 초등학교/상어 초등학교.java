import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
	static int N,ans=0;
	static int[][] 학생과좋아하는사람, map, dirs = {{-1,0},{0,1},{1,0},{0,-1}};
	static PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)-> {	//{i,j,empty,like}
		if(o1[3]!=o2[3])	return o2[3]-o1[3];
		else if(o1[2]!=o2[2])	return o2[2]-o1[2];
		else if(o1[0]!=o2[0])	return o1[0]-o2[0];
		else	return o1[1]-o2[1];
		});
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		학생과좋아하는사람 = new int[N*N][5];
		map = new int[N][N];
		int seat[];
		for (int i = 0; i < N*N; i++) {
			str = br.readLine().split(" ");
			for (int j = 0; j < 5; j++)
				학생과좋아하는사람[i][j] = Integer.parseInt(str[j]);
		}
		for(int n=0; n<N*N; n++) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j] == 0)
						탐색(i,j,n);
				}
			}
			seat = pq.poll();
			map[seat[0]][seat[1]] = 학생과좋아하는사람[n][0];
			pq.clear();
		}
		만족도구하기();
//		System.out.println(Arrays.deepToString(학생과좋아하는사람));
		//System.out.println(Arrays.deepToString(map));
		System.out.println(ans);
	}

	private static void 만족도구하기() {
		int nr,nc;
		int like=0, index=0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				like=0;
				for(int k=0; k<N*N; k++) {
					if(map[i][j] == 학생과좋아하는사람[k][0]) {
						index = k;
						break;
					}
				}
				for(int dir[] : dirs) {
					nr = i+dir[0];
					nc = j+dir[1];
					if(nr>=0 && nr<N && nc >=0 && nc<N && 좋아하는사람인가요(nr,nc,index)) {
						like++;
					}
				}
				index++;
				switch (like) {
				case 1:	ans+=1;		break;
				case 2:	ans+=10;	break;
				case 3:	ans+=100;	break;
				case 4:	ans+=1000;	break;
			}
			}
		}
	}

	private static boolean 좋아하는사람인가요(int nr, int nc, int index) {
		for(int p=1; p<5; p++) {
			if(학생과좋아하는사람[index][p] == map[nr][nc])
				return true;
		}
		return false;
	}

	private static void 탐색(int i, int j, int index) {
		int nr,nc,like=0,empty=0;
		for(int dir[] : dirs) {
			nr = i+dir[0];
			nc = j+dir[1];
			if(nr>=0 && nr<N && nc >=0 && nc<N) {
				if(map[nr][nc]==0)
					empty++;
				else if(map[nr][nc] != 0) {
					if(좋아하는사람인가요(nr,nc,index))	like++;
				}
			}
		}
//		System.out.println(i + " " + j + " " + empty + " " + like);
		pq.offer(new int[] {i,j,empty,like});
	}
}
