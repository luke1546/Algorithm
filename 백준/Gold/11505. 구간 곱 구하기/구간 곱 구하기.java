import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

  static int N, M, K, half, size;
  static long mod = 1000000007;
  static long[] segment;
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringTokenizer st;
  static StringBuilder sb = new StringBuilder();

  public static void main(String[] args) throws IOException {
    st = new StringTokenizer(br.readLine(), " ");
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    K = Integer.parseInt(st.nextToken());
    init();
    for (int i = 0; i < M + K; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken()) + half - 1;
      int c = Integer.parseInt(st.nextToken());
      if (a == 1) {
        update(b, c);
      }
      if (a == 2) {
        query(b, c);
      }
    }
    System.out.println(sb.toString());
  }

  private static void query(int b, int c) {
    long answer = 1;
    c += (half - 1);
    while (c >= b) {
      if (b % 2 == 1) {
        answer = (answer * (long) segment[b]) % mod;
        b++;
      }
      if (c % 2 == 0) {
        answer = (answer * (long) segment[c]) % mod;
        c--;
      }
      b /= 2;
      c /= 2;
    }
    sb.append(answer + "\n");
  }

  private static void update(int b, int c) {
    segment[b] = c;
    while (b > 0) {
      if (b % 2 == 0) {
        segment[b / 2] = (segment[b] * segment[b + 1]) % mod;
      } else {
        segment[b / 2] = (segment[b] * segment[b - 1]) % mod;
      }
      b /= 2;
    }
//    System.out.println(Arrays.toString(segment));
  }

  private static void init() throws IOException {
    size = (int) (Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)))) * 2;
    half = size / 2;
    segment = new long[size];
    for (int i = half; i < half + N; i++) {
      segment[i] = Long.parseLong(br.readLine());
    }
    for (int i = size - 1; i > 0; i -= 2) {
      segment[i / 2] = (segment[i] * segment[i - 1]) % mod;
    }
  }
}

/*
5 2 2
1
2
3
4
5
1 3 6
2 2 5
1 5 2
2 3 5
 */