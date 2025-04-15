class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        String answer = "";
        int c = toSec(pos);
        int last = toSec(video_len);
        int ops = toSec(op_start);
        int ope = toSec(op_end);
        for(String command : commands){
            if(c >= ops && c < ope) c = ope;
            if(command.equals("prev")){
                c-=10;
                if(c<0) c = 0;
            }else if(command.equals("next")){
                c+=10;
                if(c > last) c = last;
            }
        }
        if(c >= ops && c < ope) c = ope;
        return toMin(c);
    }
    
    public static String toMin(int sec){
        StringBuilder sb = new StringBuilder();
        if(sec/60 < 10) sb.append("0");
        sb.append(sec/60).append(":");
        if(sec%60 < 10) sb.append("0");
        sb.append(sec%60);
        return sb.toString();
    }
    
    public static int toSec(String min){
        int m = Integer.parseInt(min.substring(0,2));
        int s = Integer.parseInt(min.substring(3,5));
        return m*60+s;
    }
}