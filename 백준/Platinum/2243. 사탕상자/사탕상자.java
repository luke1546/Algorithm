import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int segment[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		
		int taste = 1000000;
		makeSegment(taste);
		int size = segment.length;
		
//		System.out.println(size);
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			if(a==1) {
				int index = 1;
				while(index < (size>>1)) {
					if(segment[index] >= b)	index<<=1;
					else	b-=segment[index++];
				}
				if(segment[index] < b)	index++;
				segment[index]--;
				sb.append(index-(size>>1)+1).append("\n");
				index>>=1;
				while(index > 0) {
					segment[index]--;
					index>>=1;
				}
			}else {
				int c = Integer.parseInt(st.nextToken());
				int index = b+(size>>1)-1;
				while(index > 0) {
					segment[index]+=c;
					index>>=1;
				}
			}
		}
		System.out.println(sb.toString());
	}
	private static void makeSegment(int taste) {
		int size = (int)Math.pow(2, Math.ceil(Math.log(taste) / Math.log(2)))<<1;
		segment = new int[size];
	}
}
