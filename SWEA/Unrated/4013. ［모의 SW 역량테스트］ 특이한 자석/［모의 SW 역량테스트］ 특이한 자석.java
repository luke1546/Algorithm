
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
	static int K,M[];
	static Deque<int[]> dq = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String str[] = br.readLine().split(" ");
		int T = Integer.parseInt(str[0]);
		for (int tc = 1; tc <= T; tc++) {
			int ans = 0;
			int number,direction;
			str = br.readLine().split(" ");
			K = Integer.parseInt(str[0]);
			M = new int[4];
			for(int i=0; i<4; i++)
				M[i] = Integer.parseInt(br.readLine().replace(" ",""),2);
			for(int i=0; i<K; i++) {
				str = br.readLine().split(" ");
				number = Integer.parseInt(str[0])-1;
				direction = Integer.parseInt(str[1]);
				dq.add(new int[] {number,direction});
				자성확인(number,direction);
				while(!dq.isEmpty())
					회전(dq.peek()[0], dq.poll()[1]);
			}
			for(int i=0; i<4; i++) {
//				System.out.println(Integer.toBinaryString(M[i]));
				ans+=Math.pow(2, i)*((M[i]&128)/128);
			}
			sb.append("#" + tc + " "+ ans + "\n");
		}
		System.out.println(sb.toString());
	}

	private static void 회전(int number, int direction) {
		if(direction == 1) {	//시계
			if(M[number]%2==1)
				M[number]= (M[number]>>1)+128;
			else
				M[number]>>=1;
		}else {
			if(M[number]>=128)
				M[number]= (M[number]<<1)-255;
			else
				M[number]<<=1;
		}
//		System.out.print(direction + " ====== ");
//		System.out.println(Integer.toBinaryString(M[number])+ " " + M[number]);
	}

	private static void 자성확인(int number, int direction) {
		//우
		for(int i = number; i<3; i++)
			if(((M[i]&32)*(M[i+1]&2)) == 0 &&((M[i]&32)|(M[i+1]&2)) > 0) {
//				System.out.println("우회전 true" + i);
//				System.out.println(i  + " + " + number);
				if((i-number)%2 == 0)
					dq.add(new int[] {i+1,direction*-1});
				else
					dq.add(new int[] {i+1,direction});
				
			}else	break;
		//좌
		for(int i = number; i>0; i--) {
//			System.out.println((M[i]&2) + " " + (M[i-1]&32));
			if(((M[i]&2)*(M[i-1]&32)) == 0 && ((M[i]&2)|(M[i-1]&32)) > 0) {
//				System.out.println("좌회전 true" + i);
				if((number-i)%2 == 0)
					dq.add(new int[] {i-1,direction*-1});
				else
					dq.add(new int[] {i-1,direction});
					
			}else	break;
		}
	}
}
