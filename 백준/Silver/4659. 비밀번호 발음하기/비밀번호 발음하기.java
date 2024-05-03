import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		while(true) {
			String s = br.readLine();
			if(s.equals("end")) break;
			if(!hasVowel(s)) {
				fail(s);
				continue;
			}else if(isContinue(s)) {
				fail(s);
				continue;
			}else if(isSame(s)) {
				fail(s);
				continue;
			}else	success(s);
		}
		System.out.println(sb.toString());
	}
	private static boolean isSame(String s) {
		boolean flag = false;
		char before = s.charAt(0);
		for(int i=1; i<s.length(); i++) {
			if(s.charAt(i) == before) {
				if(s.charAt(i) != 'e' && s.charAt(i) != 'o') {
					flag = true;
				}
			}
			before = s.charAt(i);
		}
		return flag;
	}
	private static boolean isContinue(String s) {
		boolean flag = false;
		int 자음 = 0;
		int 모음 = 0;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u') {
				모음++;
				자음=0;
			}
			else {
				자음++;
				모음=0;
			}
			if(자음 == 3 || 모음 == 3) flag = true;
		}
		return flag;
	}
	private static boolean hasVowel(String s) {
		boolean vowel = false;
		for(int i=0; i<s.length(); i++) {
			if(s.charAt(i) == 'a' || s.charAt(i) == 'e' || s.charAt(i) == 'i' || s.charAt(i) == 'o' || s.charAt(i) == 'u')
				vowel = true;
		}
		return vowel;
	}
	private static void success(String s) {
		sb.append("<").append(s).append("> is acceptable.\n");
	}
	private static void fail(String s) {
		sb.append("<").append(s).append("> is not acceptable.\n");
	}
}


/*
a
tv
ptoui
bontres
zoggax
wiinq
eep
houctuh
end

<a> is acceptable.
<tv> is not acceptable.
<ptoui> is not acceptable.
<bontres> is not acceptable.
<zoggax> is not acceptable.
<wiinq> is not acceptable.
<eep> is acceptable.
<houctuh> is acceptable.
*/