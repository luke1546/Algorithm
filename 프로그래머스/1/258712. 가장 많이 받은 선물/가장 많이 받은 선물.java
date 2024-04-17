import java.util.*;
class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int size = friends.length;
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0; i<size; i++) hm.put(friends[i],i);
        int map[][] = new int[size][size];
        for(String gift : gifts){
            String strs[] = gift.split(" ");
            int a = hm.get(strs[0]);
            int b = hm.get(strs[1]);
            map[a][b]++;
        }
        int score[] = new int[size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                score[i] += map[i][j];
                score[i] -= map[j][i];
            }
        }
        int receive[] = new int[size];
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(i!=j && map[i][j] > map[j][i]) receive[i]++;
                else if(i!=j && map[i][j] == map[j][i]){
                    if(score[i] > score[j]) receive[i]++;
                }
            }
        }
        for(int v : receive) answer = Math.max(answer,v);
        return answer;
    }
}