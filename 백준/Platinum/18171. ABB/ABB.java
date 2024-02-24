import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static String s;
  static int r,c;
  static int[][] Manacher;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int max = 1;
    br.readLine();
    s = br.readLine();
    s = dummy(s);
    Manacher = new int[s.length()][3];
    for(int i=1; i<s.length(); i++){
      r = Manacher[i-1][1];
      c = Manacher[i-1][2];
      int index = findByManacher(i);
      while(i-index >= 0 && i+index < s.length() && s.charAt(i-index) == s.charAt(i+index)) index++;
      Manacher[i][0] = index-1;
      if(r >= i+index-1){
        Manacher[i][1] = r;
        Manacher[i][2] = c;
      }else{
        Manacher[i][1] = i+index-1;
        Manacher[i][2] = i;
      }
      if(Manacher[i][1] == s.length()-1) max = Math.max(max,Manacher[i][0]);
    }
    System.out.println(s.length()/2 - max);
  }

  private static String dummy(String s) {
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<s.length(); i++) sb.append("#").append(s.charAt(i));
    return sb.append("#").toString();
  }

  private static int findByManacher(int i){
    if(r < i) return 0;
    return Math.min(r-i, Manacher[2*c-i][0]);
  }
}

/*
bj_18171
input:
15
murderforajarof
output:
6
 */

//#a#b#b#