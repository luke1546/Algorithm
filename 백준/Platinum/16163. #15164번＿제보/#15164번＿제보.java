import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
 static  String s;
  static int r, c, Manacher[][];
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    s = br.readLine();
    long answer = s.length();
    dummy();
    Manacher = new int[s.length()][3];
    for(int i=1; i<s.length(); i++) {
      r = Manacher[i - 1][1];
      c = Manacher[i - 1][2];
      int index = findByManacher(i) + 1;
      while (i - index >= 0 && i + index < s.length() && s.charAt(i - index) == s.charAt(
          i + index)) {
        index++;
      }
      Manacher[i][0] = index - 1;
      if (index + i - 1 > r) {
        Manacher[i][1] = index + i - 1;
        Manacher[i][2] = i;
      } else {
        Manacher[i][1] = r;
        Manacher[i][2] = c;
      }
      answer += (Manacher[i][0]/2);
    }
    System.out.println(answer);
  }
  public static void dummy(){
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<s.length(); i++) sb.append("#").append(s.charAt(i));
    s = sb.append("#").toString();
  }
  public static int findByManacher(int i){
    if(r < i) return 0;
    return Math.min(r-i, Manacher[2*c-i][0]);
  }
}
