import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static String s;
  static int r, c;
  static int[][] Manacher;  // P[i](반지름의길이), r(반지름 끝 인덱스), c(중심)
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    s = br.readLine();
    s = dummy(s);
    Manacher = new int[s.length()][3];
    for(int i=1; i<s.length(); i++){
      r = Manacher[i-1][1];
      c = Manacher[i-1][2];
      int index = findByManacher(i);   // index는 같은부분인지 찾기 시작할 위치
      while(i-index >= 0 && i+index < s.length() && s.charAt(i+index) == s.charAt(i-index)) index++;
      Manacher[i][0] = index-1;
      if(r >= i+index-1){
        Manacher[i][1] = r;
        Manacher[i][2] = c;
      }else{
        Manacher[i][1] = i+index-1;
        Manacher[i][2] = i;
      }
    }
    int max = 0;
    for(int i=0; i<s.length(); i++) max = Math.max(max, Manacher[i][0]);
    System.out.println(max);
  }

  private static String dummy(String s) {
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<s.length(); i++) sb.append("#").append(s.charAt(i));
    return sb.append("#").toString();
  }

  private static int findByManacher(int i) {
    int index;
    if(i > r)  index = 0;
    else index = Math.min(Manacher[2 * c - i][0], r - i);
    return index + 1;
  }
}


/*
bj_13275
input :
abcba
output :
5
 */