import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str[];
		HashMap<Integer, Integer> hm = new HashMap<>();
		Deque<Integer> dq = new ArrayDeque<Integer>();
		ArrayList<Integer> 원래줄 = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());	//전깃줄의 갯수
		int max=0;
		int[][] 전깃줄 = new int[N][2];
		for(int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			전깃줄[i][0] = Integer.parseInt(str[0]);
			전깃줄[i][1] = Integer.parseInt(str[1]);
			hm.put(전깃줄[i][1], 전깃줄[i][0]);
		}
		Arrays.sort(전깃줄,(o1,o2) -> o1[0]-o2[0]);
		
		int[] 최장증가수열 = new int[N];
		int[][] trace = new int[N][2];
		Arrays.fill(최장증가수열, Integer.MAX_VALUE);
		
		
		for(int i=0; i<N; i++) {
			int index = (Arrays.binarySearch(최장증가수열, 전깃줄[i][1])*-1)-1;
			max = Math.max(max, index);
			최장증가수열[index] = 전깃줄[i][1];
			trace[i][0] = index;
			trace[i][1] = 전깃줄[i][1];
		}
		int temp = max;
		for(int i=N-1; i>=0; i--) {
			if(trace[i][0] == temp) {
				dq.offer(trace[i][1]);
				temp--;
			}
		}
		Arrays.sort(전깃줄, (o1,o2) -> o1[1] - o2[1]);
		System.out.println(전깃줄.length - dq.size());
//		while(!dq.isEmpty())	System.out.println(dq.pollLast());
		int x = dq.pollLast();
		for(int i=0; i<N; i++) {
			if(전깃줄[i][1] == x) {
				if(!dq.isEmpty())
					x = dq.pollLast();
				continue;
			}else	원래줄.add(전깃줄[i][0]);
		}
		Collections.sort(원래줄);
		for(int i : 원래줄)
			sb.append(i+"\n");
		sb.setLength(sb.length()-1);
		System.out.println(sb.toString());
	}
}
