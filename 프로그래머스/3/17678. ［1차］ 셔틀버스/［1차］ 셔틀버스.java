import java.util.*;
class Solution {
    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";
        int firstTime = 540;
        int busTime = firstTime;
        int lastTime = 0;
        PriorityQueue<Integer> crew = new PriorityQueue<>();
        for(int i=0; i<timetable.length; i++)   crew.offer(STI(timetable[i]));
        for(int i=0; i<n; i++){
            int cnt = 0;
            while(!crew.isEmpty()){
                if(cnt == m) break;
                if(crew.peek() <= busTime){
                    lastTime = crew.poll()-1;
                    cnt++;
                }else break;
            }
            if(i == n-1 && cnt != m) lastTime = firstTime + ((n-1)*t);
            busTime += t;
        }
        answer = ITS(lastTime);
        return answer;
    }
    public static int STI(String str){
        String hour[] = str.split(":");
        return Integer.parseInt(hour[0])*60 + Integer.parseInt(hour[1]);
    }
    public static String ITS(int i){
        int m = i%60;
        int h = i/60;
        StringBuilder sb = new StringBuilder();
        if(h < 10) sb.append("0");
        sb.append(h).append(":");
        if(m < 10) sb.append("0");
        sb.append(m);
        return sb.toString();
    }
}