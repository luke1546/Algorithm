import java.util.*;

class Solution {
    static HashMap<Integer, Character> hm = new HashMap<>();
    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();
        hm.put(10, 'A');
        hm.put(11, 'B');
        hm.put(12, 'C');
        hm.put(13, 'D');
        hm.put(14, 'E');
        hm.put(15, 'F');
        int count = 0;
        ArrayList<Character> list = new ArrayList<>();
        while(list.size() < m*t){
            String str = conversion(count, n);
            for(int i=0; i<str.length(); i++) list.add(str.charAt(i));
            count++;
        }
        p-=1;
        for(int i=1; i<=t; i++){
            sb.append(list.get(p));
            p+=m;
        }
        return sb.toString();
    }
    
    public static String conversion(int num, int n){
        StringBuilder sb = new StringBuilder();
        while(num != 0){
            int x = num%n;
            if(x >= 10) sb.append(hm.get(x));
            else sb.append(x);
            num/=n;
        }        
        if(sb.length() == 0) sb.append(0);
        return sb.reverse().toString();
    }
}