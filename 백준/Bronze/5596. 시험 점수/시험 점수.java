import java.util.*;
import java.io.*;

public class Main{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = 0;
        int b = 0;
        for(int i=0; i<4; i++) a+=Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<4; i++) b+=Integer.parseInt(st.nextToken());
        System.out.print(Math.max(a,b));
    }
}

/*
100 80 70 60
80 70 80 90

320
*/