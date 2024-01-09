import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		int cnt=0;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s = br.readLine();
		String p = br.readLine();
		int pi[] = new int[p.length()];
		pi[0] = 0;	int j = 0;
		for(int i=1; i<p.length(); i++){
			while(p.charAt(i)!=p.charAt(j) && j!=0)	j=pi[j-1];
			if(p.charAt(i)==p.charAt(j)) j++;
			pi[i] = j;
		}
		
		int i=0;	j=0;
		while(i<s.length()) {
			if(s.charAt(i) == p.charAt(j)) {
				j++;	i++;
			}else if(j==0)	i++;
			else	j = pi[j-1];
			if(j==p.length())	{
				cnt++;
				sb.append((i-j+1) + " ");
				j = pi[j-1];
			}
		}
		System.out.println(cnt);
		System.out.print(sb.toString());
	}
}
