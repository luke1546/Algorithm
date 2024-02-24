import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    HashMap<String, String> sMap = new HashMap<>();
    HashMap<String, String> iMap = new HashMap<>();
    int no = 1;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    for(int i=0; i<N; i++){
      String pokemon = br.readLine();
      sMap.put(pokemon,Integer.toString(no));
      iMap.put(Integer.toString(no),pokemon);
      no++;
    }
    for(int i=0; i<M; i++){
      String quiz = br.readLine();
      String answer;
      if(sMap.containsKey(quiz)) answer = sMap.get(quiz);
      else answer = iMap.get(quiz);
      System.out.println(answer);
    }
  }
}
