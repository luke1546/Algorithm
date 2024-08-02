import java.io.*;
import java.util.*;

public class Main{
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		boolean arr[] = new boolean[2000001];
		for(int i=0; i<n; i++){
			 int v = Integer.parseInt(br.readLine());
            arr[v+1000000] = true;
		}
		for(int i=0; i<arr.length; i++)	{
            if(arr[i]) sb.append((i-1000000)+"\n");
        }
		System.out.print(sb);
	}
}

/*
5
5
4
3
2
1

1
2
3
4
5
*/