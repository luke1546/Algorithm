import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static class Point{
    int i,v;
    public Point(int i, int v){
      this.i = i;
      this.v = v;
    }
    public Point copy() {
      return new Point(this.i, this.v);
    }
    public String toString() {
      return this.i + " " + this.v;
    }
  }
  static Point[] segment;
  static int N, M, size;
  static BufferedReader br;
  static StringTokenizer st;
  static StringBuilder sb;
  public static void main(String[] args) throws Exception {
    br = new BufferedReader(new InputStreamReader(System.in));
    sb = new StringBuilder();
    N = Integer.parseInt(br.readLine());
    init();
    M = Integer.parseInt(br.readLine());
    for(int i=0; i<M; i++) {
      st = new StringTokenizer(br.readLine(), " ");
      int q = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());
      if (q == 1)   update(a, b);
      if (q == 2)   query(a, b);
    }
    System.out.print(sb.toString());
  }
  public static void update(int a, int b){
    a = a + size/2 -1 ;
    segment[a].v = b;
    while(a > 1){
      if(a%2 == 0) segment[a/2] = getMin(segment[a],segment[a+1]);
      else segment[a/2] = getMin(segment[a], segment[a-1]);
      a/=2;
    }
  }

  public static void query(int a, int b){
    a = a + size/2 -1;
    b = b + size/2 -1;
    Point min = new Point(0,Integer.MAX_VALUE);
    while(a <= b){
      if(a%2 == 1) min = getMin(min, segment[a]);
      if(b%2 == 0) min = getMin(min, segment[b]);
      a = (a + 1) / 2;
      b = (b - 1) / 2;
    }
    sb.append(min.i).append("\n");
  }

  public static void init() throws Exception {
    size = (int)Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)))*2;
    segment = new Point[size];
    segment[0] = new Point(0,Integer.MAX_VALUE);
    st = new StringTokenizer(br.readLine(), " ");
    for(int i=0; i<N; i++)    segment[i+size/2] = new Point(i+1,Integer.parseInt(st.nextToken()));
    for(int i=N; i<size/2; i++) segment[i+size/2] = new Point(i+1, Integer.MAX_VALUE);
    for(int i=size-1; i>1; i-=2) segment[i/2] = getMin(segment[i],segment[i-1]);
  }

  private static Point getMin(Point p1, Point p2) {
    if (p1.v > p2.v) return p2.copy();
    else if(p1.v < p2.v) return p1.copy();
    else {
      if(p1.i < p2.i) return p1.copy();
      else return p2.copy();
    }
  }
}

/*
bj_14428
input:
5
5 4 3 2 1
6
2 1 3
2 1 4
1 5 3
2 3 5
1 4 3
2 3 5
output:
3
4
4
3
 */
