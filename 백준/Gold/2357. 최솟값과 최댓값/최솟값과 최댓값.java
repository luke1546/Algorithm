import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static int N, M, size, half, minSegment[], maxSegment[];
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    init();
    query();
    System.out.println(sb.toString());
  }

  private static void query() throws IOException {
    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int a = Integer.parseInt(st.nextToken()) + half - 1;
      int b = Integer.parseInt(st.nextToken()) + half - 1;
      int min = Integer.MAX_VALUE, max = 0;
      while (b >= a) {
        if (a % 2 == 1) {
          min = Math.min(min, minSegment[a]);
          max = Math.max(max, maxSegment[a]);
          a++;
        }
        if (b % 2 == 0) {
          min = Math.min(min, minSegment[b]);
          max = Math.max(max, maxSegment[b]);
          b--;
        }
        a /= 2;
        b /= 2;
      }
      sb.append(min + " " + max + "\n");
    }
  }

  private static void init() throws IOException {
    size = (int) Math.pow(2, Math.ceil(Math.log(N) / Math.log(2))) * 2;
    half = size / 2;
    minSegment = new int[size];
    maxSegment = new int[size];
    Arrays.fill(minSegment, Integer.MAX_VALUE);
    for (int i = half; i < half + N; i++) {
      int a = Integer.parseInt(br.readLine());
      minSegment[i] = a;
      maxSegment[i] = a;
    }
    for (int i = size - 1; i > 0; i -= 2) {
      minSegment[i / 2] = Math.min(minSegment[i], minSegment[i - 1]);
      maxSegment[i / 2] = Math.max(maxSegment[i], maxSegment[i - 1]);
    }
  }
}

/*
10 4
75
30
100
38
50
51
52
20
81
5
1 10
3 5
6 9
8 10
 */