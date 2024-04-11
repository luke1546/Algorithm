import java.util.*;
import java.util.regex.*;
class Solution {
    static int selected[] = new int[3];
    static boolean visit[] = new boolean[3];
    static HashMap<Integer,String> hm = new HashMap<>();
    static ArrayList<String> list = new ArrayList<>();
    static Long max=Long.MIN_VALUE;
    public long solution(String expression) {
        hm.put(0,"+");
        hm.put(1,"-");
        hm.put(2,"*");
        Pattern p = Pattern.compile("\\d+|\\D");
        Matcher m = p.matcher(expression);
        while(m.find()) list.add(m.group());
        순열(0);
        return max;
    }
    void 순열(int cnt){
        if(cnt == 3) max = Math.max(max,calculate(hm.get(selected[0]),hm.get(selected[1]),hm.get(selected[2])));
        for(int i=0; i<3; i++){
            if(visit[i]) continue;
            visit[i] = true;
            selected[cnt] = i;
            순열(cnt+1);
            visit[i] = false;
        }
    }
    Long calculate(String op1, String op2, String op3){
        ArrayList<String> al = new ArrayList<>(list);
        Stack<String> stack = new Stack<>();
        String op;
        for(int x=0; x<3; x++){
            if(x==0) op = op1;
            else if(x==1) op = op2;
            else op = op3;
        for(int i=0; i<al.size(); i++){
            if(!stack.isEmpty() && stack.peek().equals(op)){
                stack.pop();
                Long v = stringCal(stack.pop(),op,al.get(i));
                stack.push(v+"");
            }
            else stack.push(al.get(i));
        }
            al = new ArrayList<>(stack);
            stack.clear();
        }
        
        return Math.abs(Long.parseLong(al.get(0)));
    }
    
    Long stringCal(String aS, String op, String cS){
        Long a = Long.parseLong(aS);
        Long c = Long.parseLong(cS);
        if(op.equals("+")) return a+c;
        else if(op.equals("-")) return a-c;
        else return a*c;
    }
}