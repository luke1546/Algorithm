import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	public static void main(String[] args) throws IOException {
		int n = Integer.parseInt(br.readLine());
		int ans = 0;
		if((n % 4 == 0 && n % 100 != 0) || n % 400 == 0) ans = 1;
		System.out.println(ans);
	}
}


/*
2000

1
*/