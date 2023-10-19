class Solution {
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        while(getDis(x,y,r,c)<k){
            if(x<n) {x++;    sb.append("d");
            }else if(y>1){y--;    sb.append("l");
            }else if(y<m){ y++;    sb.append("r");
            }else{x--;    sb.append("u");}
            k--;
        }
        if(getDis(x,y,r,c)==k) goEnd(x,y,r,c,sb);
        else    return "impossible";
        answer = sb.toString();
        return answer;
    }
    private static int getDis(int x, int y, int r, int c){
        return (int)(Math.abs(x-r)+Math.abs(y-c));
    }
    private static void goEnd(int x, int y, int r, int c, StringBuilder sb){
        if(x<r) for(int i=0; i<r-x; i++)    sb.append("d");
        if(c<y) for(int i=0; i<y-c; i++)    sb.append("l");
        if(y<c) for(int i=0; i<c-y; i++)    sb.append("r");
        if(r<x) for(int i=0; i<x-r; i++)    sb.append("u");
    }
}