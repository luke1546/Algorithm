import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		bw.write(String.valueOf(N!=1 ? (1+N)*(N/2)+(N%2*((1+N)/2)) : 1));
		bw.flush();
	}
}