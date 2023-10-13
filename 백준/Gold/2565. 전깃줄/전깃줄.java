import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[];
		int N = Integer.parseInt(br.readLine());
		int[][] 전깃줄 = new int[N][2];
		for(int i=0; i<N; i++) {
			str = br.readLine().split(" ");
			전깃줄[i][0] = Integer.parseInt(str[0]);
			전깃줄[i][1] = Integer.parseInt(str[1]);
		}
		Arrays.sort(전깃줄,(o1,o2) -> o1[0]-o2[0]);
//		LinkedList<Integer> ll = new LinkedList<>();
		
		LinkedList<Integer> al = new LinkedList<>();
		for(int i=0; i<전깃줄.length; i++) {
			int x = Collections.binarySearch(al, 전깃줄[i][1])*-1;
			if(x==al.size()+1)	al.add(전깃줄[i][1]);
			else {
				al.add(x, 전깃줄[i][1]);
				al.remove(x-1);
			}
		}
		System.out.println(전깃줄.length - al.size());
	}
}
