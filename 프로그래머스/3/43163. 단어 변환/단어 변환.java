import java.util.*;
class Solution {
    public class SI{
        String str;
        int cnt;
        public SI(String str, int cnt){
            this.str = str;
            this.cnt = cnt;
        }
        public String toString(){
            return "str : " + str + ", cnt : " + cnt;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        ArrayDeque<SI> dq = new ArrayDeque<>();
        boolean[] visit = new boolean[words.length];
        dq.offer(new SI(begin,0));
        while(!dq.isEmpty()){
            // System.out.println(dq);
            SI si = dq.poll();
            if(si.str.equals(target)) return si.cnt;
            for(int i=0; i<words.length; i++){
                if(!visit[i] && canGo(si.str,words[i]))  {
                    visit[i] = true;
                    dq.offer(new SI(words[i], si.cnt+1));
                }
            }
        }
        return 0;
    }
    public static boolean canGo(String v, String t){
        int cnt = 0;
        for(int i=0; i<v.length(); i++){
            if(v.charAt(i) != t.charAt(i)) cnt++;
        }
        if(cnt > 1) return false;
        return true;
    }
}