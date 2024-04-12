import java.util.*;
class Solution {
    static int N;
    static int selected[];
    static boolean visit[];
    static HashMap<Character, Integer> hm;
    static ArrayList<int[]> al;
    static int answer;
    public int solution(int n, String[] data) {
        N = 8;
        selected = new int[N];
        visit = new boolean[N];
        hm = new HashMap<>();
        al = new ArrayList<>();
        answer = 0;
        hm.put('A',0);
        hm.put('C',1);
        hm.put('F',2);
        hm.put('J',3);
        hm.put('M',4);
        hm.put('N',5);
        hm.put('R',6);
        hm.put('T',7);
        hm.put('=',8);
        hm.put('<',9);
        hm.put('>',10);
        for(int i=0; i<n; i++){
            int a = hm.get(data[i].charAt(0));
            int b = hm.get(data[i].charAt(2));
            int c = hm.get(data[i].charAt(3));
            int d = data[i].charAt(4)-'0';
            al.add(new int[]{a, b, c, d});
        }
        perm(0,n);
        return answer;
    }
    void perm(int cnt, int n){
        if(cnt==N){
            for(int i=0; i<n; i++){
                int a = al.get(i)[0];
                int b = al.get(i)[1];
                int c = al.get(i)[2];
                int d = al.get(i)[3];
                int dis = getDistance(selected,a,b);
                if(c==8) if(dis != d) return;
                if(c==9) if(dis >= d) return;
                if(c==10) if(dis <= d) return;
            }
            answer++;
            return;
        }
        for(int i=0; i<N; i++){
            if(visit[i]) continue;
            visit[i] = true;
            selected[cnt] = i;
            perm(cnt+1,n);
            visit[i] = false;
        }
    }
    int getDistance(int[] selected, int a, int b){
        int aIndex = 0;
        int bIndex = 0;
        for(int i=0; i<selected.length; i++){
            if(selected[i] == a) aIndex = i;
            else if(selected[i] == b) bIndex = i;
        }
        return Math.abs(aIndex-bIndex)-1;
    }
}