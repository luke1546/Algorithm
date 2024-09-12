import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		ArrayList<Integer> list = new ArrayList<>();
		long ans = 0;
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<N; i++) {
			int x = Integer.parseInt(st.nextToken());
			list.add(x);
		}
		Collections.sort(list);
		for(int i=0; i<list.size(); i++) {
			for(int j=i+1; j<list.size(); j++) {
				int v = (list.get(i) + list.get(j))*-1;
				if(v > list.get(list.size()-1)) continue;
				int left = binarySearch(list, j, v, true);
				if(left != -1) {
					int right = binarySearch(list, j, v, false);
					ans+=(right-left)+1;
				}
			}
		}
		bw.write(String.valueOf(ans));
		bw.flush();
	}
	public static int binarySearch(ArrayList<Integer> list, int j, int v, boolean flag) {
		int result = -1;
		int left = j + 1;
		int right = list.size()-1;
		while(left <= right) {
			int mid = (left+right)/2;
			if(list.get(mid) == v) {
				result = mid;
				if(flag) right = mid-1;
				else left = mid+1;
			}else if(list.get(mid) < v) {
				left = mid+1;
			}else {
				right = mid-1;
			}
		}
		return result;
	}
}

/*
10
2 -5 2 3 -4 7 -4 0 1 -6

6
*/