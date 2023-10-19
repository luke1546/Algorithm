class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        while(getDis(x,y,r,c)<k){
            if(x<n) {
                x+=1;
                sb.append("d");
            }else if(y>1){
                y-=1;
                sb.append("l");
            }else if(y<m){
                y+=1;
                sb.append("r");
            }else{
                x-=1;
                sb.append("u");
            }
            // System.out.println(getDis(x,y,r,c));
            // System.out.println(k);
            k-=1;
        }
        // System.out.println(getDis(x,y,r,c));
        // System.out.println(x+" "+y+" "+r+" "+c+" "+k);
        if(getDis(x,y,r,c)==k) goEnd(x,y,r,c,sb);
        else    return "impossible";
        answer = sb.toString();
        return answer;
    }
    private static int getDis(int x, int y, int r, int c){
        return (int)(Math.abs(x-r)+Math.abs(y-c));
    }
    private static void goEnd(int x, int y, int r, int c, StringBuilder sb){
        if(x<r)
            for(int i=0; i<r-x; i++)    sb.append("d");
        if(c<y)
            for(int i=0; i<y-c; i++)    sb.append("l");
        if(y<c)
            for(int i=0; i<c-y; i++)    sb.append("r");
        if(r<x)
            for(int i=0; i<x-r; i++)    sb.append("u");
        
    }
}