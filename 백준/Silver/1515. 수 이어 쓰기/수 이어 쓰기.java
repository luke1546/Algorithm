import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		String str = br.readLine();
		int index = 0;
		int c = 0;
		while(c < str.length()) {
			index++;
			String is = index+"";
			for(int i=0; i<is.length(); i++) {
				if(is.charAt(i) == str.charAt(c)) {
					c++;
					if(c >= str.length()) break;
				}
			}
		}
		System.out.println(index);
	}
}


/*
82340329923

43
*/


