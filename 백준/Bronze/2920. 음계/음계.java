import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[8];
        int cnt[] = new int[2];
        for(int i=0; i<8; i++) arr[i] = Integer.parseInt(st.nextToken());
        for(int i=1; i<8; i++){
            if(arr[i] > arr[i-1]) cnt[0]++;
            else if(arr[i] < arr[i-1]) cnt[1]++;
        }
        if(cnt[0] == 7) System.out.println("ascending");
        else if(cnt[1] == 7) System.out.println("descending");
        else System.out.println("mixed");
    }
}