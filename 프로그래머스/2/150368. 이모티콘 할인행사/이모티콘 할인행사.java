import java.util.*;
class Solution {
    static int[] selected;
    static boolean[] visit;
    static int R;
    static int maxUser = 0;
    static int maxSum = 0;
    public int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];
        R = emoticons.length;
        selected = new int[R];
        visit = new boolean[4];
        perm(0,users,emoticons);
        answer[0] = maxUser;
        answer[1] = maxSum;
        return answer;
    }
    void perm(int cnt, int users[][], int emoticons[]){
        if(cnt == R){
            int user = 0;
            int sum = 0;
            int[] usersBuy = new int[users.length];
            for(int i=0; i<R; i++){
                float discount = (selected[i]+1)*10;
                for(int j=0; j<users.length; j++){
                    if(users[j][0] <= discount) {
                    usersBuy[j] += (emoticons[i]*(100-discount))/100;
                    }
                }
            }
            for(int i=0; i<users.length; i++){
                if(usersBuy[i] >= users[i][1]) user++;
                else sum += usersBuy[i];
            }
            if(maxUser < user){
                maxUser = user;
                maxSum = sum;
            }else if(maxUser == user && maxSum < sum){
                maxSum = sum;
            }
            return;
        }
        for(int i=0; i<4; i++){
            selected[cnt] = i;
            perm(cnt+1, users, emoticons);
        }
    }
}