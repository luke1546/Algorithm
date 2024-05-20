import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		ArrayList<String> al = new ArrayList<>();
		HashMap<String,Integer> hm = new HashMap<>();
		st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			if(str.length() < M) continue;
			if(hm.containsKey(str)) hm.put(str, hm.get(str)+1);
			else hm.put(str, 1);
		}
		for(String s : hm.keySet()) al.add(s);
		
		Comparator<String> ans = new Comparator<String>(){
			@Override
			public int compare(String s1, String s2) {
				if(hm.get(s1) == hm.get(s2)) {
					if(s1.length() == s2.length()) return s1.compareTo(s2);
					else return s2.length() - s1.length();
				}
				else return hm.get(s2) - hm.get(s1);
			}
		};
		Collections.sort(al, ans);
		for(String s : al) sb.append(s).append("\n");
		System.out.println(sb.toString());
	}
}

/*
1. 자주 나오는 단어일수록 앞에 배치한다.
2. 해당 단어의 길이가 길수록 앞에 배치한다.
3. 알파벳 사전 순으로 앞에 있는 단어일수록 앞에 배치한다
 
7 4
apple
ant
sand
apple
append
sand
sand

출력 : 
sand
apple
append
*/