import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Main{
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int answer = 0;
    String s = br.readLine();
    String sub1 = s.substring(0,s.length()/2);
    String sub2;
    if(s.length()%2 == 1) sub2 = s.substring(s.length()/2+1);
    else sub2 = s.substring(s.length()/2);
    sub2 = sb.append(sub2).reverse().toString();
    if(!sub1.equals(sub2)) answer = s.length();
    else{
      int cnt = 0;
      for(int i=0; i<s.length(); i++) {
        if (s.charAt(0) == s.charAt(i))
          cnt++;
      }
      if(cnt == s.length()) answer = -1;
      else answer = s.length()-1;
    }
    System.out.println(answer);
  }
}