import java.util.*;
public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        while(true){
            int n = sc.nextInt();
            if(n == 0) break;
            int ans = 0;
            for(int i=1; i<=n; i++) ans+=i;
            System.out.println(ans);
        }
    }
}