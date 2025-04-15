class Solution {
    static int gHp;
    static int[] gBandage;
    public int solution(int[] bandage, int health, int[][] attacks) {
        gHp = health;
        gBandage = bandage;
        int beforeTime = 0;
        for(int[] attack : attacks){
            int timeDif = attack[0] - beforeTime - 1;
            beforeTime = attack[0];
            gHp += getRecovery(timeDif);
            if(gHp > health) 
                gHp = health;
            gHp -= attack[1];
            if(gHp <= 0){
                gHp = -1;
                break;
            }
        }
        return gHp;
    }
    public static int getRecovery(int timeDif){
        int recovery = 0;
        int success = timeDif/gBandage[0];
        recovery += (success * gBandage[2]);
        recovery += (gBandage[1] * timeDif);
        return recovery;
    }
}