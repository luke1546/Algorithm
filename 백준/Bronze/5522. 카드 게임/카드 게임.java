import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int sum = 0;
		for(int i=0; i<5; i++) sum+=Integer.parseInt(br.readLine());
		System.out.println(sum);
	}
}

/*
1
2
3
4
5

15
*/