import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int a = Integer.parseInt(br.readLine());
		int b = Integer.parseInt(br.readLine());
		if(a>0 && b>0) System.out.println(1);
		if(a<0 && b>0) System.out.println(2);
		if(a<0 && b<0) System.out.println(3);
		if(a>0 && b<0) System.out.println(4);
	}
}
