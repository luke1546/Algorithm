import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        int r = board.length;
        int c = board[0].length;
        int map[][] = new int[r+1][c+1];
        for(int size=0; size<skill.length; size++){
            if(skill[size][0] == 1) skill[size][5]*=-1;
            map[skill[size][1]][skill[size][2]] += skill[size][5];
            map[skill[size][1]][skill[size][4]+1] += (skill[size][5]*-1);
            map[skill[size][3]+1][skill[size][2]] += (skill[size][5]*-1);
            map[skill[size][3]+1][skill[size][4]+1] += (skill[size][5]);
        }
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                map[i][j+1] += map[i][j];
            }
        }
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                map[i+1][j] += map[i][j];
            }
        }
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                map[i][j] += board[i][j];
            }
        }
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(map[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}