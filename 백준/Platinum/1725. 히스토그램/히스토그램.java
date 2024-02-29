import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
  static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  static StringBuilder sb = new StringBuilder();
  static int N, size, max;
  static Point[] segment;
  public static class Point{
    int i, v;
    public Point(int i, int v){
      this.i = i;
      this.v = v;
    }

    public Point copy(){
      return new Point(this.i, this.v);
    }
    public String toString(){
      return i + " " + v;
    }
  }
  public static void main(String[] args) throws IOException {
    N = Integer.parseInt(br.readLine());
    init();
    분할정복(1,N);
    System.out.println(max);
  }

  private static void 분할정복(int a, int b) {
    if(a == b){
      max = Math.max(max, segment[a+size/2-1].v);
      return;
    }
    if(a > b) return;
    Point p = query(a,b);
    max = Math.max(max, p.v * (b-a+1));
    분할정복(a, p.i-1);
    분할정복(p.i+1, b);
  }

  public static Point query(int a, int b){
    Point min = new Point(0,Integer.MAX_VALUE);
    a = a+size/2-1;
    b = b+size/2-1;
    while(a <= b){
      if(a%2==1) min = getMin(min, segment[a]);
      if(b%2==0) min = getMin(min, segment[b]);
      a = (a + 1) / 2;
      b = (b - 1) / 2;
    }
    return min;
  }

  public static void init() throws IOException {
    size = (int)Math.pow(2, Math.ceil(Math.log(N) / Math.log(2)))*2;
    segment = new Point[size];
    segment[0] = new Point(0,0);
    for(int i=0; i<N; i++){
      int n = Integer.parseInt(br.readLine());
      segment[i+size/2] = new Point(i+1,n);
    }
    for(int i=N; i<size/2; i++) segment[i+size/2] = new Point(i+1,0);
    for(int i=size-1; i>0; i-=2)  segment[i/2] = getMin(segment[i], segment[i-1]);
  }

  private static Point getMin(Point p1, Point p2) {
    if (p1.v > p2.v)  return p2.copy();
    else if (p1.v < p2.v)   return p1.copy();
    else {
      if (p1.i > p2.i)  return p2.copy();
      else  return p1.copy();
    }
  }
}

/*
bj_1725
input:
7
2
1
4
5
1
3
3
output:
8
 */