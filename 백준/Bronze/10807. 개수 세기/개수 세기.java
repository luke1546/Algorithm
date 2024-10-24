import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[201];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            int v = Integer.parseInt(st.nextToken())+100;
            arr[v]++;
        }
        int x = Integer.parseInt(br.readLine())+100;
        System.out.println(arr[x]);
    }
}
/*
11
1 4 1 2 4 2 4 2 3 4 4
2
*/