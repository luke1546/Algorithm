class Solution {
    static boolean p;
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        for(int i=0; i<numbers.length; i++){
            p = true;
            StringBuilder sb = new StringBuilder();
            String str = Long.toBinaryString(numbers[i]);
            int size = str.length();
            
            if(size == 1)   {if(numbers[i] == 0) p = false;}
            else if(size <= 3) for(int j=0; j<3-size; j++) sb.append("0");
            else if(size <= 7) for(int j=0; j<7-size; j++) sb.append("0");
            else if(size <= 15) for(int j=0; j<15-size; j++) sb.append("0");
            else if(size <= 31) for(int j=0; j<31-size; j++) sb.append("0");
            else if(size <= 63) for(int j=0; j<63-size; j++) sb.append("0");
            // System.out.println("p: " + p);
            sb.append(str);
            str = sb.toString();
            int size2 = str.length();
            DC(str,0,size2-1,size2);
            if(str=="0")    p = false;
            if(p) answer[i] = 1;
            else answer[i] = 0;
        }
        return answer;
    }
    private static void DC(String str, int s, int e, int size){
        int half = size/2;
        if(half == 0) return;
        // System.out.println(str + " " + s + " " + e + " " + " " + half + " " + size);
        if(str.charAt(s+half) == '0'){
            for(int i = s; i <= e; i++)
                if(str.charAt(i) == '1')    p = false;
        }
        // System.out.println(p);
        DC(str,s,e-1-half,half);
        DC(str,s+1+half,e,half);
    }
}