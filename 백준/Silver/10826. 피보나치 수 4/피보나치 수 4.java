import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		BigInteger ans = new BigInteger("1");
		BigInteger temp = new BigInteger("0");
		for(int i=1; i<N; i++) {
			ans = ans.add(temp);
			temp = ans.subtract(temp);
		}
		if(N == 0) ans = new BigInteger("0");
		bw.write(ans.toString());
		bw.flush();
	}
}
