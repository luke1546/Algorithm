import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		boolean flag = false;
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		ArrayList<Integer> first = new ArrayList<>();
		ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		int n1 = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n1; i++) first.add(Integer.parseInt(st.nextToken()));
		for(int i=0; i<N-1; i++) {
			int n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			list.add(new ArrayList<>());
			for(int j=0; j<n; j++) {
				list.get(i).add(Integer.parseInt(st.nextToken()));
			}
		}
		for(int i=0; i<n1-K+1; i++) {
			if(flag) break;
			int[] arr = new int[K];
			int[] fail = new int[K];
			for(int j=0; j<K; j++) arr[j] = first.get(j+i);
			int k = 0;
			for(int j=1; j<K; j++) {
				while(k > 0 && arr[j] != arr[k]) k = fail[k-1];
				if(arr[j] == arr[k]) fail[j] = ++k;
			}
			for(ArrayList<Integer> al : list) {
				boolean flag1 = false;
				boolean flag2 = false;
				if(KMP(arr, al, fail)) flag1 = true;
				else flag1 = false;
				Collections.reverse(al);
				if(KMP(arr, al, fail)) flag2 = true;
				else flag2 = false;
				if(flag1 || flag2) flag = true;
				else flag = false;
				if(!flag) break;
			}
		}
		System.out.println(flag ? "YES" : "NO");
	}

	private static boolean KMP(int[] arr, ArrayList<Integer> al, int[] fail) {
		int i = 0;
		int j = 0;
		while(i < al.size()) {
			if(al.get(i) == arr[j]) {
				i++;
				j++;
			}else if(j==0) i++;
			else {
				j = fail[j-1];
			}
			if(j == arr.length) return true;
		}
		return false;
	}

}

/*
3 4
13
10 8 23 93 21 42 52 22 13 1 2 3 4
11
1 3 8 9 21 42 52 22 13 41 42
10
9 21 42 52 13 22 52 42 12 21

YES
*/