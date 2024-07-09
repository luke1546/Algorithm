import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	static char[] arr;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		arr = br.readLine().toCharArray();
		Deque<Character> dq = new ArrayDeque<>();
		int count = 0;
		int ac = 0;
		int bc = 0;
		for(int i=0; i<arr.length; i++) {
			if(arr[i] == 'a') count++;
		}
		for(int i=0; i<arr.length; i++) {
			dq.offer(arr[i]);
			if(dq.size() > count) {
				char c = dq.poll();
				if(c == 'a') ac--;
				else bc--;
			}
			if(arr[i] == 'a') ac++;
			else bc++;
			if(dq.size() == count) {
				min = Math.min(min, bc);
			}
		}
		for(int i=0; i<arr.length; i++) {
			dq.offer(arr[i]);
			if(dq.size() > count) {
				char c = dq.poll();
				if(c == 'a') ac--;
				else bc--;
			}
			if(arr[i] == 'a') ac++;
			else bc++;
			if(dq.size() == count) {
				min = Math.min(min, bc);
			}
		}
		System.out.println(min);
	}
}

/*
abababababababa

3
*/