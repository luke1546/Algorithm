import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		int max=0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((o1,o2)->
			{
				if(o1[1] != o2[1])	return o1[1]-o2[1];
				else return o1[0]-o2[0];
			});		//예약시간 오름차순
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int N = Integer.parseInt(str[0]);
		HashMap<Integer, int[]> hm = new HashMap<>();
		int[][] 손님 = new int[N][3];
		boolean check[] = new boolean[200001];
		for(int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			int r = Integer.parseInt(str[0]);
			int t = Integer.parseInt(str[1]);
			
//			pq.offer(new int[] {r,t,i});
			hm.put(r, new int[] {r,t,i});
			손님[i][0] = r;
			손님[i][1] = t;
			손님[i][2] = i;
		}
		Arrays.sort(손님, (o1,o2) -> o1[1]-o2[1]);
		int cnt=0;
		
		int time = 1; 
		int index = 0;
		while(cnt!=N) {
//			System.out.println(time + " " + 손님[index][1]);
			while(index < N && 손님[index][1] == time) {
				pq.offer(손님[index]);
				index++;
			}
			boolean isIn = false;
			if(hm.containsKey(time)) {
				if(hm.get(time)[1] <= time && !check[hm.get(time)[2]]) {
//					System.out.println(Arrays.toString(hm.get(time)));
					check[hm.get(time)[2]] = true;
					isIn = true;
					max = Math.max(max, time - hm.get(time)[1]);
				}
			}
			if(!isIn) {
				while(!pq.isEmpty()) {
					int cur[] = pq.poll();
					cnt++;
					if(!check[cur[2]]) {
//						System.out.println(Arrays.toString(cur));
						max = Math.max(max, time - cur[1]);
						check[cur[2]] = true;
						break;
					}
				}
			}
			time++;
		}
		System.out.println(max);
	}
}
