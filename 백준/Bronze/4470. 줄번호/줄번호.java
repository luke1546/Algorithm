import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) sb.append((i+1)+". "+br.readLine()).append("\n");
		System.out.print(sb);
	}
}

/*
5
Lionel Cosgrove
Alice
Columbus and Tallahassee
Shaun and Ed
Fido

1. Lionel Cosgrove
2. Alice
3. Columbus and Tallahassee
4. Shaun and Ed
5. Fido
*/