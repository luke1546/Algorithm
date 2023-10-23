import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		int arr[] = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		int min = Integer.MAX_VALUE;
		int v1=0;
		int v2=0;
		for(int i=0; i<N; i++) {
			int index = Arrays.binarySearch(arr, -arr[i]);
			if(index < 0)	index = (index * -1) -1;
			if(index == N)	{
				if(min > Math.abs(arr[i]+arr[index-1]) && i != index-1) {
					min = Math.abs(arr[i]+arr[index-1]);
					v1 = arr[i];
					v2 = arr[index-1];
				}
			}
			else if(index == 0) {
				if(min > Math.abs(arr[i]+arr[index]) && i != index) {
					min = Math.abs(arr[i]+arr[index]);
					v1 = arr[i];
					v2 = arr[index];
				}
			}
			else {
				if(min > Math.abs(arr[i] + arr[index]) && i != index) {
					min = Math.abs(arr[i] + arr[index]);
					v1 = arr[i];
					v2 = arr[index];
				}
				if(min > Math.abs(arr[i] + arr[index-1]) && i != index-1) {
					min = Math.abs(arr[i] + arr[index-1]);
					v1 = arr[i];
					v2 = arr[index-1];
				}
			}
		}
		System.out.println(v1 < v2 ? v1 + " " + v2 : v2 + " " + v1);
	}
}
