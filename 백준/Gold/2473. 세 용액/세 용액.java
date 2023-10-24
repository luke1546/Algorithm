import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static long arr[];
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		arr = new long[(int) N];
		long min = Long.MAX_VALUE;
		long v1=0,v2=0,v3=0;
		for(int i=0; i<N; i++) arr[i] = Long.parseLong(st.nextToken());
		Arrays.sort(arr);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(j==i)	continue;
				long fvalue = (arr[i]+arr[j])*-1;
				int index1 = Arrays.binarySearch(arr, fvalue);
				if(index1 < 0) index1 = (index1*-1) -1;
				int index2 = index1-1;
				
				if(index1 == N)	{
					index1--;
					while(index1 == i || index1 == j) {	
						--index1;
						--index2;
					}
				}
				
				while(index1==i || index1==j) --index1;
				while(index2==i || index2==j || index2<0) ++index2;
				if(index1 < 0)	index1 = index2;
				else if(index2 < N && Math.abs(fvalue-arr[index1]) > Math.abs(fvalue-arr[index2]))
					index1 = index2;
				
				if(min > Math.abs(fvalue - arr[index1])) {
					min = Math.min(min, Math.abs(fvalue - arr[index1]));
					v1 = arr[i];
					v2 = arr[j];
					v3 = arr[index1];
				}
			}
		}
		long[] temp = new long[3];
		temp[0] = v1;
		temp[1] = v2;
		temp[2] = v3;
		Arrays.sort(temp);
		System.out.println(temp[0] + " " + temp[1] + " " + temp[2]);
	}
}
