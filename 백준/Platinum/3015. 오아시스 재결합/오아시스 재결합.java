import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static ArrayList<Integer> list = new ArrayList<>();
	static long ans = 0;
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		list.add(Integer.parseInt(br.readLine()));
		for(int i=1; i<N; i++) {
			int x = Integer.parseInt(br.readLine());
			countPair(x);
			while(!list.isEmpty()) {
				if(list.get(list.size()-1)< x) list.remove(list.size()-1);
				else break;
			}
			list.add(x);
		}
		System.out.println(ans);
	}
	private static void countPair(int x) {
		int index = binarySearch(list, x);
		if(index != 0) index--;
		ans = ans + list.size()-index;
	}
	
	private static int binarySearch(ArrayList<Integer> list, int target) {
		int result = -1;
		int left = 0;
		int right = list.size()-1;
		while(left <= right) {
			int mid = left + (right - left) / 2;
			if(list.get(mid) == target) {
				result = mid;
				right = mid - 1;
			}else if(list.get(mid) > target) {
				left = mid + 1;
			}else {
				right = mid - 1;
			}
		}
		if(result == -1) result = left;
		return result;
	}
}


/*
7
2
4
1
2
2
5
1

10
*/