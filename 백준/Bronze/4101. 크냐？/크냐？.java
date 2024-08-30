import java.util.*;

public class Main{
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(true){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a == 0 && b == 0) break;
            if(a > b) sb.append("Yes").append("\n");
            else sb.append("No").append("\n");
        }
        System.out.print(sb);
    }
}

/*
1 19
4 4
23 14
0 0

No
No
Yes
*/