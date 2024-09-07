class Solution {
    public int[] solution(String s) {
        int count = 0;
        int ans = 0;
        while(s.length() != 1){
            count++;
            int zero = countZero(s);
            ans+=zero;
            s = Integer.toBinaryString(s.length() - zero);
        }
        return new int[]{count,ans};
    }
    public static int countZero(String s){
        int cnt = 0;
        for(int i=0; i<s.length(); i++) if(s.charAt(i) == '0') cnt++;
        return cnt;
    }
}