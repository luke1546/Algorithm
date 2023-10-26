import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		while(true) {
			boolean p = true;
			String n = br.readLine();
			if(n.equals("0"))	break;
			for(int i=0; i<n.length()/2; i++) {
				if(n.charAt(i) != n.charAt(n.length()-1-i)) {
					sb.append("no\n");
					p = false;
					break;
				}
			}
			if(p)	sb.append("yes\n");
		}
		System.out.println(sb.toString());
	}
}
