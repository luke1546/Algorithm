import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		int arr[] = new int[10001];
		for(int i=0; i<N; i++) arr[Short.parseShort(br.readLine())]++; 
		for(int i=0; i<10001; i++) {
			for(int j=0; j<arr[i]; j++) bw.write(i+"\n");
		}
		bw.flush();
	}
}

/*
10
5
2
3
1
4
2
3
5
1
7

1
1
2
2
3
3
4
5
5
7
*/
