import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[1001];
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int index = 0;
        int x = 1;
        int ans = 0;
        while(index <= 1000){
            for(int i=0; i<x; i++){
                arr[index] = x;   
                index++;
                if(index == 1001) break;
            }
            x++;
        }
        for(int i=a-1; i<b; i++){
            ans += arr[i];
        }
        System.out.println(ans);
    }
}
/*
3 7

15
*/