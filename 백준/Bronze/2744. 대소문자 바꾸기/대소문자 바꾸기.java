import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		for(int i=0; i<str.length(); i++){
            if(str.charAt(i) <= 90) sb.append((char)(str.charAt(i) + 32));
            else sb.append((char)(str.charAt(i) - 32));
        }
		System.out.println(sb);
	}
}
