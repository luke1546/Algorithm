import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
 
import java.util.Arrays;
 
public class Main {
	public static int[] house;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		house = new int[N];
		for(int i = 0; i < N; i++)	house[i] = Integer.parseInt(br.readLine());
		Arrays.sort(house);		//이분탐색을 위해 정렬
		int low = 1;
		int high = house[N-1]-house[0]+1;
		
		while(low < high) {
			int mid = (high + low) / 2;		//mid를 최소거리로 설정해서 탐색
			if(Install(mid) < M)	high = mid;
			else	low = mid + 1;
		}
		System.out.println(low - 1);
	}
	public static int Install(int distance) {
		int cnt = 1;		//공유기 개수
		int last = house[0];
		for(int i = 1; i < house.length; i++) {
			int locate = house[i];
			if(locate - last >= distance) {
				cnt++;
				last = locate;
			}
		}
		return cnt;
		
	}
	
	
}