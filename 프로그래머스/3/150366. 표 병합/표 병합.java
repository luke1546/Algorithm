
import java.util.*;

class Solution {
    static int[] parents;
    static StringBuilder sb = new StringBuilder();
    static HashMap<Integer, String> hm = new HashMap<>();
    static int SIZE = 2551;
    public String[] solution(String[] commands) {
        String[] answer = {};
        parents = new int[SIZE];
        for(int i=0; i<SIZE; i++) {
            hm.put(i,"EMPTY");
            parents[i] = i;
        }
        
        for(String command : commands){
            StringTokenizer st = new StringTokenizer(command," ");
            String c = st.nextToken();
            if(c.equals("UPDATE") && st.countTokens()==3) update1(st);
            if(c.equals("UPDATE") && st.countTokens()==2) update2(st);
            if(c.equals("MERGE")) merge(st);
            if(c.equals("UNMERGE")) unmerge(st);
            if(c.equals("PRINT")) print(st);
        }
        if(sb.length()!=0)  answer = sb.toString().split(" ");
        // for(int key : hm.keySet()) System.out.println("key : " + key + "value : " + hm.get(key));
        return answer;
    }
    private static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot != bRoot)  parents[bRoot] = aRoot;
    }
    private static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }
    private static void update1(StringTokenizer st){
        int key = getKey(st);
        String s = st.nextToken();
        hm.put(find(key),s);
    }
    private static void update2(StringTokenizer st){
        String v1 = st.nextToken();
        String v2 = st.nextToken();
        for(int key : hm.keySet()){
            if(hm.get(find(key)).equals(v1)) hm.put(find(key),v2);
        }
    }
    private static void merge(StringTokenizer st){
        int key1 = getKey(st);
        int key2 = getKey(st);
        int fk1 = find(key1);
        int fk2 = find(key2);
        if(fk1 == fk2)    return;
        String str = hm.get(fk1).equals("EMPTY") ? hm.get(fk2) : hm.get(fk1);
        hm.put(fk1,"EMPTY");
        hm.put(fk2,"EMPTY");
        union(fk1, fk2);
        if(!str.equals("EMPTY"))   hm.put(fk1,str);
    }
    private static void unmerge(StringTokenizer st){
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int key = getKey(st);
        int fk = find(key);
        for(int i=0; i<SIZE; i++)   if(find(i) == fk) dq.offer(i);
        while(!dq.isEmpty()){
            int x = dq.poll();
            parents[x] = x;
        }
        if(fk!=key){
            hm.put(key,hm.get(fk));
            hm.put(fk,"EMPTY");
        }
    }
    private static void print(StringTokenizer st){
        int key = getKey(st);
        int fk = find(key);
        sb.append(hm.get(fk)+" ");
        // else    sb.append("EMPTY ");
    }
    private static int getKey(StringTokenizer st){
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int key = (r)*50+c;
        return key;
    }
}