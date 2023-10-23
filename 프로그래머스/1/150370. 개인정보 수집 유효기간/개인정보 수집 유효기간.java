import java.util.*;
class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        // int[] answer = {};
        HashMap<String,Integer> hm = new HashMap();
        ArrayList<Integer> al = new ArrayList<>();
        for(String term : terms){
            StringTokenizer st = new StringTokenizer(term, " ");
            String t = st.nextToken();
            int m = Integer.parseInt(st.nextToken());
            hm.put(t,m);
        }
        int index=1;
        for(String privacy : privacies){
            StringTokenizer st = new StringTokenizer(privacy, " ");
            String date = st.nextToken();
            String term = st.nextToken();
            st = new StringTokenizer(date, ".");
            int y = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            m+=hm.get(term);
            while(m > 12){
                y++;
                m-=12;
            }
            st = new StringTokenizer(today, ".");
            int ty = Integer.parseInt(st.nextToken());
            int tm = Integer.parseInt(st.nextToken());
            int td = Integer.parseInt(st.nextToken());
            if(ty>y)    al.add(index);
            else if(ty==y && tm > m)    al.add(index);
            else if(ty==y && tm == m && td >= d)    al.add(index);
            index++;
            // System.out.println(privacy);
            // System.out.println(hm);
        }
        int size=0;
        int[] answer = new int[al.size()];
        for(int i : al) answer[size++] = i;
        return answer;
    }
}