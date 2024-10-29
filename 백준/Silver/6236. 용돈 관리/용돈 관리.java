import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static int N, M, maxValue, min;
	static ArrayList<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++)
			list.add(Integer.parseInt(br.readLine()));
		maxValue = Collections.max(list);
		min = Integer.MAX_VALUE;
		int left = 1;
		int right = 1000000000;
		while(left <= right) {
			int mid = (left+right)/2;
			int c = count(mid);
			if(c > M) {
				left = mid+1;
			}
			else {
				min = Math.min(min, mid);
				right = mid-1;
			}
		}
		System.out.println(min);
	}
	
	public static int count(int k) {
		int count = 1;
		int temp = k;
		if(k < maxValue) return Integer.MAX_VALUE;
		for(int i=0; i<N; i++) {
			if(temp-list.get(i) >= 0) temp-=list.get(i);
			else {
				count++;
				temp = k;
				temp-=list.get(i);
			}
		}
		return count;
	}
}

/*
7 5
100
400
300
100
500
101
400

500
*/