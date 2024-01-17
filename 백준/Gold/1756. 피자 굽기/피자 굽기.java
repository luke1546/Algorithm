import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  static int N, M;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    int[][] arr = new int[N][2];
    boolean[] oven = new boolean[N];
    int[] pizza = new int[M];
    st = new StringTokenizer(br.readLine());

    arr[0][0] = Integer.parseInt(st.nextToken());
    arr[0][1] = arr[0][0];

    for(int i=1; i<N; i++){
      arr[i][0] = Integer.parseInt(st.nextToken());
      arr[i][1] = Math.min(arr[i][0], arr[i-1][1]);
    }
    st = new StringTokenizer(br.readLine());
    for(int i=0; i<M; i++){
      pizza[i] = Integer.parseInt(st.nextToken());
    }

    int p = 0, i = N-1;
    while(p < M && i >= 0){
      if(arr[i][1] >= pizza[p])   {
        p++;
        oven[i] = true;
      }
      i--;
    }
    if (p < M) {
      System.out.println(0);
    }else{
      for(int x=0; x<N; x++){
        if (oven[x]) {
          System.out.println(x+1);
          break;
        }
      }
    }
  }
}

/*
7 3
5 6 4 3 6 2 3
3 2 5
 */