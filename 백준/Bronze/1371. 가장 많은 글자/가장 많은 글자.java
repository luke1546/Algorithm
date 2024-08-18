import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		int arr[] = new int[26];
		String str;
		while((str = br.readLine()) != null) {
			for(int i=0; i<str.length(); i++) {
				if(str.charAt(i) != ' ') arr[str.charAt(i) - 'a']++;
			}
		}
		int max = 0;
		for(int i=0; i<26; i++) max = Math.max(max, arr[i]);
		for(int i=0; i<26; i++) if(arr[i] == max) sb.append((char)(i+'a'));
		System.out.println(sb);
	}
}


/*
english is a west germanic
language originating in england
and is the first language for
most people in the united
kingdom the united states
canada australia new zealand
ireland and the anglophone
caribbean it is used
extensively as a second
language and as an official
language throughout the world
especially in common wealth
countries and in many
international organizations

a
*/