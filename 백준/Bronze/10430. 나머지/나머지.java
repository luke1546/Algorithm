import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringTokenizer st;
	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine(), " ");
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		bw.write(String.valueOf((A+B)%C));
		bw.write("\n");
		bw.write(String.valueOf( ((A%C) + (B%C))%C ));
		bw.write("\n");
		bw.write(String.valueOf((A*B)%C));
		bw.write("\n");
		bw.write(String.valueOf(((A%C) * (B%C))%C));
		bw.flush();
	}
}


/*
첫째 줄에 (A+B)%C, 둘째 줄에 ((A%C) + (B%C))%C, 셋째 줄에 (A×B)%C, 넷째 줄에 ((A%C) × (B%C))%C를 출력한다.
5 8 4

1
1
0
0
*/