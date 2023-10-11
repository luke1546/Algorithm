import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	static int K,M[];
	static Deque<int[]> dq = new ArrayDeque<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[];
		int ans = 0;
		int number,direction;
		M = new int[4];
		for(int i=0; i<4; i++)	M[i] = Integer.parseInt(br.readLine().replace(" ",""),2);		//2진수를 10진수로 변경
		
		K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			str = br.readLine().split(" ");
			number = Integer.parseInt(str[0])-1;
			direction = Integer.parseInt(str[1]);		//입력받기
			dq.add(new int[] {number,direction});
			자성확인(number,direction);
			while(!dq.isEmpty())	회전(dq.peek()[0], dq.poll()[1]);
		}
		for(int i=0; i<4; i++)	ans+=Math.pow(2, i)*((M[i]&128)/128);
		System.out.println(ans);
	}

	private static void 회전(int number, int direction) {
		if(direction == 1) {	//시계방향
			if(M[number]%2==1)	M[number]= (M[number]>>1)+128;
			else	M[number]>>=1;
		}else {					//반시계방향
			if(M[number]>=128)	M[number]= (M[number]<<1)-255;
			else	M[number]<<=1;
		}
	}

	private static void 자성확인(int number, int direction) {
		//오른쪽 애들 확인
		for(int i = number; i<3; i++)
			if(((M[i]&32)*(M[i+1]&2)) == 0 &&((M[i]&32)|(M[i+1]&2)) > 0) {
				if((i-number)%2 == 0)	dq.add(new int[] {i+1,direction*-1});
				else	dq.add(new int[] {i+1,direction});
			}else	break;
		//왼쪽 애들 확인
		for(int i = number; i>0; i--) {
			if(((M[i]&2)*(M[i-1]&32)) == 0 && ((M[i]&2)|(M[i-1]&32)) > 0) {
				if((number-i)%2 == 0)	dq.add(new int[] {i-1,direction*-1});
				else	dq.add(new int[] {i-1,direction});
			}else	break;
		}
	}
}