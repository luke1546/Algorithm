import java.util.*;

public class Main{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int ans = 0;
        for(int i=0; i<3; i++) list.add(sc.nextInt());
        ans+=Collections.min(list);
        list = new ArrayList<>();
        for(int i=0; i<2; i++) list.add(sc.nextInt());
        ans+=Collections.min(list);
        System.out.println(ans-50);
    }
}