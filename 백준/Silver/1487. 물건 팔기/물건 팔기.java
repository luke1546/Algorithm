
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2];
		int max = 0;
		int value = 0;
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());	
		}
		for(int i=0; i<N; i++){ //i가 판매하는 비용
			int sum = 0;
			for(int j=0; j<N; j++){
				if(arr[i][0] <= arr[j][0]) {
					if(arr[i][0] - arr[j][1] >= 0)
					sum+=(arr[i][0] - arr[j][1]);
				}
			}
			if(max < sum){
				max = sum;
				value = arr[i][0];
			}else if(max == sum && value > arr[i][0]){
				max = sum;
				value = arr[i][0];
			}
			sum = 0;
		}
		System.out.println(value >= 0 ? value : 0);
	
	}
}
/*
3
13 5
22 15
35 30

13
*/