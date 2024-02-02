import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
  static int N;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    ArrayList<Integer> al = new ArrayList<>();
    HashMap<Integer, Integer> hm = new HashMap<>();
    N = Integer.parseInt(br.readLine());
    int arr1[] = new int[N];
    int arr2[] = new int[N];
    int lis[] = new int[N];
    StringTokenizer st = new StringTokenizer(br.readLine()," ");
    for(int i=0; i<N; i++)  arr1[i] = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine()," ");
    for(int i=0; i<N; i++)  arr2[i] = Integer.parseInt(st.nextToken());
    for(int i=0; i<N; i++)  hm.put(arr2[i],i);
    for(int i=0; i<N; i++)  lis[i] = hm.get(arr1[i]);
    al.add(lis[0]);
    for(int i=1; i<N; i++){
      if(lis[i] > al.get(al.size()-1)) al.add(lis[i]);
      else {
        al.set(Collections.binarySearch(al,lis[i]) * (-1) -1,lis[i]);
      }
    }
//    System.out.println(Arrays.toString(lis));
//    System.out.println(al);
    System.out.println(al.size());
  }
}

/*
5
2 3 1 4 5
3 2 1 5 4

3 2 1 4 0
0 4

 */

