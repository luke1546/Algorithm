import java.util.*;
import java.io.*;

public class Main {
	static ArrayDeque<Integer> dq = new ArrayDeque<>();
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		for(int i=0; i<s.length(); i++) {
			int n = s.charAt(i);
			if(n == '(' || n == '[') {
				dq.push(n);
			}else if(n == ')') {
				boolean pair = false;
				int temp = 0;
				while(!dq.isEmpty()) {
					int top = dq.peek();
					if(top < 0) temp += dq.pop();
					else if(top == '[') {
						System.out.println(0);
						return;
					}
					else if(top == '(') {
						if(temp==0) temp = -1;
						dq.pop();
						dq.push(temp*2);
						pair = true;
						break;
					}
				}
				if(!pair) {
					System.out.println(0);
					return;
				}
			}else if(n == ']') {
				boolean pair = false;
				int temp = 0;
				while(!dq.isEmpty()) {
					int top = dq.peek();
					if(top < 0) temp += dq.pop();
					else if(top == '(') {
						System.out.println(0);
						return;
					}
					else if(top == '[') {
						if(temp==0) temp = -1;
						dq.pop();
						dq.push(temp*3);
						pair = true;
						break;
					}
				}
				if(!pair) {
					System.out.println(0);
					return;
				}
			}
		}
		
		int ans = 0;
		while(!dq.isEmpty()) {
			int c = dq.pop();
			if(c > 0) {
				System.out.println(0);
				return;
			}
			ans+=c;
		}
		System.out.println(-ans);
	}
}

/*
(()[[]])([])

28
*/