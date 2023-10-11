import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int N, map[][], numbers[], max=0, copy[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		map = new int[N][N];
		copy = new int[N][N];
		numbers = new int[5];
		for(int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(str[j]);
				copy[i][j] = map[i][j];
			}
		}
		
		중복순열(0);
		System.out.println(max);
//		for(int i[] : map)	System.out.println(Arrays.toString(i));
	}
	
	private static void 중복순열(int cnt) {
		if(cnt==5) {
			for(int i=0; i<5; i++)	move(numbers[i]);
			max = Math.max(max, findBig());
			reset();
			return;
		}for(int i=0; i<4; i++) {
			numbers[cnt] = i;
			중복순열(cnt+1);
		}
	}

	private static void reset() {
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				map[i][j] = copy[i][j];
	}

	private static int findBig() {
		int max = 0;
		for(int i=0; i<N; i++)
			for(int j=0; j<N; j++)
				max = Math.max(max, map[i][j]);
		return max;
	}

	private static void move(int d) {		//0 : 위, 1 : 오른쪽, 2 : 아래, 3 : 왼쪽
		if(d==0) {
			for(int j=0; j<N; j++) {
				for(int i=0; i<N-1; i++) {
					for(int k=i+1; k<N; k++) {
						if(map[k][j] == 0)	continue;
						if(map[k][j] == map[i][j]) {	
							map[i][j]*=2;
							map[k][j] = 0;
						}
						break;
					}
				}
				for(int i=0; i<N-1; i++) {
					if(map[i][j]==0) {
						for(int k=i+1; k<N; k++) {
							if(map[k][j] != 0) {
								map[i][j] = map[k][j];
								map[k][j] = 0;
								break;
							}
						}
					}
				}
			}
		}else if(d==1) {
			for(int i=0; i<N; i++) {
				for(int j=N-1; j>0; j--) {
					for(int k=j-1; k>=0; k--) {
						if(map[i][k] == 0)	continue;
						if(map[i][k] == map[i][j]) {	
							map[i][j]*=2;
							map[i][k] = 0;
						}
						break;
					}
				}
				for(int j=N-1; j>0; j--) {
					if(map[i][j]==0) {
						for(int k=j-1; k>=0; k--) {
							if(map[i][k] != 0) {
								map[i][j] = map[i][k];
								map[i][k] = 0;
								break;
							}
						}
					}
				}
			}
		}else if(d==2) {
			for(int j=0; j<N; j++) {
				for(int i=N-1; i>0; i--) {
					for(int k=i-1; k>=0; k--) {
						if(map[k][j] == 0)	continue;
						if(map[k][j] == map[i][j]) {	
							map[i][j]*=2;
							map[k][j] = 0;
						}
						break;
					}
				}
				for(int i=N-1; i>0; i--) {
					if(map[i][j]==0) {
						for(int k=i-1; k>=0; k--) {
							if(map[k][j] != 0) {
								map[i][j] = map[k][j];
								map[k][j] = 0;
								break;
							}
						}
					}
				}
			}
		}else {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N-1; j++) {
					for(int k=j+1; k<N; k++) {
						if(map[i][k] == 0)	continue;
						if(map[i][k] == map[i][j]) {	
							map[i][j]*=2;
							map[i][k] = 0;
						}
						break;
					}
				}
				for(int j=0; j<N-1; j++) {
					if(map[i][j]==0) {
						for(int k=j+1; k<N; k++) {
							if(map[i][k] != 0) {
								map[i][j] = map[i][k];
								map[i][k] = 0;
								break;
							}
						}
					}
				}
			}
		}
	}
}
