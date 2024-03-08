import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    String vega = "(100+1+|01)+";
    for(int i=0; i<N; i++){
      String wave = br.readLine();
      if (wave.matches(vega))   sb.append("YES").append("\n");
      else sb.append("NO").append("\n");
    }
    System.out.print(sb.toString());
  }
}

/*
(100+1+|01)+
 */
