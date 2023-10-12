import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split(" ");
		int WC = Integer.parseInt(str[0]);
		int W[] = new int[WC];
		str = br.readLine().split(" ");
		for(int i=0; i<WC; i++)	W[i]=Integer.parseInt(str[i]);	//추 입력받기
		
		str = br.readLine().split(" ");
		int MC = Integer.parseInt(str[0]);
		int M[] = new int[MC];
		str = br.readLine().split(" ");
		for(int i=0; i<MC; i++)	M[i]=Integer.parseInt(str[i]);	//구슬 입력받기
		
		HashMap<Integer, Boolean> hm = new HashMap<>();
		ArrayDeque<Integer> dq = new ArrayDeque<>();
		for(int i=0; i<WC; i++) {
			for(int key : hm.keySet()) {
				int dif = Math.abs(W[i] - key);
				int sum = W[i] + key;
				if(!hm.containsKey(dif)) dq.add(dif);
				if(!hm.containsKey(sum)) dq.add(sum);
			}
			if(!hm.containsKey(W[i])) hm.put(W[i], true);
			while(!dq.isEmpty())	hm.put(dq.poll(), true);
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<MC; i++) {
			if(hm.containsKey(M[i]))	sb.append("Y ");
			else	sb.append("N ");
		}
		System.out.println(sb.toString());
	}
}
