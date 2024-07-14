import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	static Deque<Integer> dq;
	public static void main(String[] args) throws IOException {
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			char cArr[] = br.readLine().toCharArray();
			int k = Integer.parseInt(br.readLine());
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			int arr[] = new int[26];
			ArrayList<ArrayList<Integer>> al = new ArrayList<>();
			for(int i=0; i<26; i++) al.add(new ArrayList<>());
			for(int i=0; i<cArr.length; i++) {
				int index = cArr[i]-'a';
				al.get(index).add(i);
				arr[index]++;
			}
			for(int i=0; i<26; i++) {
				if(arr[i] < k) continue;
				for(int j=0; j<al.get(i).size()-k+1; j++) {
					int s = al.get(i).get(j+k-1) - al.get(i).get(j)+1;
					max = Math.max(max, s);
					min = Math.min(min, s);
				}
			}
			if(min == Integer.MAX_VALUE) sb.append(-1);
			else sb.append(min).append(" ").append(max);
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
}
