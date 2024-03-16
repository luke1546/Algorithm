import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static String str;
	static int r, c, Manacher[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		str = br.readLine();
		int first = str.length();
		dummy();
		Manacher = new int[str.length()][3];
		for(int i=1; i<str.length(); i++) {
			r = Manacher[i-1][1];
			c = Manacher[i-1][2];
			int index = getIndex(i);
			while(i-index >= 0 && i+index < str.length() && str.charAt(i-index) == str.charAt(i+index)) index++;
			int p = i+index-1;
			Manacher[i][0] = index-1;
			if(p > r) {
				Manacher[i][1] = p;
				Manacher[i][2] = i;
			}else {
				Manacher[i][1] = r;
				Manacher[i][2] = c;
			}
		}
		int max = 0;
		for(int i=1; i<Manacher.length; i++) {
			if(i*2-Manacher[i][1] == 0)	max = Math.max(max, Manacher[i][0]);
		}
		System.out.println(2*first-max);
	}
	private static int getIndex(int i) {
		if(r < i) return 0;
		return Math.min(r-i, Manacher[c*2-i][0]);
	}
	private static void dummy() {
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<str.length(); i++) sb.append("#").append(str.charAt(i));
		str = sb.append("#").toString();
	}
}
