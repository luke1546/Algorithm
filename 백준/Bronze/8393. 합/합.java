import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws Exception {
		int N = Integer.parseInt(br.readLine());
		System.out.print(N!=1 ? (1+N)*(N/2)+(N%2*((1+N)/2)) : 1);
	}
}