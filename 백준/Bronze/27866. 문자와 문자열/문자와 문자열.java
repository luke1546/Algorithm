import java.io.*;
public class Main{
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int index = Integer.parseInt(br.readLine());
        System.out.println(str.charAt(index-1));
    }
}

/*
Sprout
3

r
*/