import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
    	int ans = 0;
        int N = Integer.parseInt(br.readLine());
        int alpa[] = new int[26];
        String first = br.readLine();
        for(int i=0; i<first.length(); i++) alpa[first.charAt(i) - 'A']++;
        for (int i = 1; i < N; i++) {  
        	int same = 0;
        	String str = br.readLine();
        	int[] beta = alpa.clone();
        	for(int j=0; j<str.length(); j++) {
        		if(beta[str.charAt(j)-'A'] > 0) {
        			beta[str.charAt(j)-'A']--;
        			same++;
        		}
        	}
        	if(Math.abs(first.length() - str.length()) == 1 && same == Math.min(first.length(), str.length())) ans++;
        	else if(first.length() == str.length() && same == first.length()-1) ans++;
        	else if(first.length() == str.length() && same==first.length() && !str.equals(first)) ans++;
        }
        System.out.println(ans);
    }
}

/*
4
DOG
GOD
GOOD
DOLL

2
*/
