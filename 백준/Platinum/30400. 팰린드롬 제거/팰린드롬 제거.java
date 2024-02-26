import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
  static int N, M, r, c, Manacher[][];
  static String s;
  static char[] cArr;
  public static void main(String[] args) throws IOException {
    int answer = 0;
    boolean destroyed = false;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    s = br.readLine();
    s = dummy(s);
    cArr = s.toCharArray();
    Manacher = new int[s.length()][3];
    for(int i=1; i<cArr.length; i++){
      r = Manacher[i-1][1];
      c = Manacher[i-1][2];
      int index = findByManacher(i) + 1;
      while(i - index >= 0
          && i + index < cArr.length
          && cArr[i] != '!' && cArr[i-index] != '!' && cArr[i+index] != '!'
          &&cArr[i-index] == cArr[i+index]){
        if(index == M){
          answer++;
          if(cArr[i+index] == '#')  cArr[i+index-1] = '!';
          else cArr[i+index] = '!';
          destroyed = true;
          break;
        }
        index++;
      }
      if(destroyed) index-=2;
      destroyed = false;
      Manacher[i][0] = index-1;
      if(index+i-1 > r){
        Manacher[i][1] = index+i-1;
        Manacher[i][2] = i;
      }else{
        Manacher[i][1] = r;
        Manacher[i][2] = c;
      }
    }
    System.out.println(answer);
  }

  private static int findByManacher(int i) {
    if(r < i) return 0;
    else return Math.min(r-i, Manacher[2*c-i][0]);
  }

  private static String dummy(String s) {
    StringBuilder sb = new StringBuilder();
    for(int i=0; i<s.length(); i++) sb.append("#").append(s.charAt(i));
    return sb.append("#").toString();
  }
}
