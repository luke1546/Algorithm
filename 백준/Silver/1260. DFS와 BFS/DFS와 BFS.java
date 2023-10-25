import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;

public class Main {
	static ArrayList<ArrayList<Integer>> al = new ArrayList<>();
	static Deque<Integer> dq = new ArrayDeque<>();
	static StringBuilder sb = new StringBuilder();
	static int N;
	static boolean[] isVisited;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);
		int V = Integer.parseInt(str[2]);
		for(int i=0; i<N+1; i++) {
			al.add(new ArrayList<>());
		}
		for (int i = 0; i < M; i++) {
			str = br.readLine().split(" ");
			al.get(Integer.parseInt(str[0])).add(Integer.parseInt(str[1]));
			al.get(Integer.parseInt(str[1])).add(Integer.parseInt(str[0]));
		}
		for(int i=1; i<N+1; i++)
			Collections.sort(al.get(i));
		isVisited = new boolean[N+1];
		ArrayList<Integer> temp = new ArrayList<>();
		temp.add(V);
		DFS(temp);
		System.out.println(sb.toString());
		sb = new StringBuilder();
		isVisited = new boolean[N+1];
		
		dq.add(V);
		while(!dq.isEmpty())
			BFS(dq.poll());
		System.out.println(sb.toString());
		
	}
	
	private static void BFS(int V) {
		if(!isVisited[V]) {
			sb.append(V + " ");
			isVisited[V] = true;
		}else {
			return;
		}
		for(int i=0; i<al.get(V).size(); i++)	dq.offer(al.get(V).get(i));
		if(!dq.isEmpty())
			BFS(dq.poll());
	}

	private static void DFS(ArrayList<Integer> temp) {
		for(int i=0; i<temp.size(); i++) {
			if(!isVisited[temp.get(i)]){
				sb.append(temp.get(i) + " ");
				isVisited[temp.get(i)] = true;
			}else
				continue;
			DFS(al.get(temp.get(i)));
		}
	}
	
	
}
