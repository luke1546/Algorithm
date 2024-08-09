import java.io.*;

public class Main{
    public static void main(String args[]) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String A = br.readLine();
        String B = br.readLine();
        int AB = Integer.parseInt(A+B);
        int C = Integer.parseInt(br.readLine());
        System.out.println(Integer.parseInt(A) + Integer.parseInt(B) - C);
        System.out.println(AB-C);
    }
}