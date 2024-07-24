import java.util.*;
import java.io.*;

class Solution {
    public int solution(String t, String p) {
        int cnt = 0;
        long n = Long.parseLong(p);
        for(int i=0;i<t.length()-p.length()+1;i++){
            if(Long.parseLong(t.substring(i, p.length()+i))<=n){
              cnt++;
            }
        }   
        return cnt;
    }
}