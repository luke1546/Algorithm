import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		br.readLine();
		String str[] = br.readLine().split(" ");
		Arrays.sort(str,(o1,o2)->(o2+o1).compareTo(o1+o2));
		for(int i=0; i<str.length; i++)	sb.append(str[i]);
		if(str[0].equals("0"))	sb.setLength(1);
		System.out.println(sb.toString());
	}
}
