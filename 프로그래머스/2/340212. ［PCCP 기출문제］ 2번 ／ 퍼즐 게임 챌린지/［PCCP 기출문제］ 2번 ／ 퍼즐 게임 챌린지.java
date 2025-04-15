import java.util.*;

class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 100000;
        int left = 1;
        int right = 100000;
        while(left < right){
            int mid = left + (right-left)/2;
            System.out.println(mid);
            if(calc(diffs, times, limit, mid)){
                right = mid;
                answer = mid;
            }else{
                left = mid+1;
            }
        }
        return answer;
    }
    
    public static boolean calc(int[] diffs, int[] times, long limit, int level){
        long sum = 0;
        for(int i=0; i<diffs.length; i++){
            if(diffs[i] <= level) sum += times[i];
            else{
                sum += getTime(i, diffs[i]-level, times);
            }
            if(sum > limit) return false;
        }
        return true;
    }
    
    public static long getTime(int i, long diff, int[] times){
        long sum = 0;
        if(i == 0) sum += ((diff+1) * times[i]);
        else{
            sum += (diff * (times[i-1] + times[i]));
            sum += times[i];
        }
        return sum;
    }
}

//long 조심
//이분탐색 1 ~ 10만