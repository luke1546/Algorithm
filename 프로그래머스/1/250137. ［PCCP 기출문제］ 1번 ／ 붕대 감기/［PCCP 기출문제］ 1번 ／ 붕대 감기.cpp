#include <string>
#include <vector>

using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {
    int time = 0;
    int lastAttack = attacks[attacks.size()-1][0];
    int maxHealth = health;
    int attackCnt = 0;
    int 연속성공 = 0;
    while(time <= lastAttack){
        if(attacks[attackCnt][0] == time){
            연속성공 = 0;
            health -= attacks[attackCnt][1];
            attackCnt++;
            time++;
            continue;
        }
        연속성공++;
        health+=bandage[1];
        if(연속성공 == bandage[0]) {
            health+=bandage[2];
            연속성공 = 0;
        }
        if(health <= 0) return -1;
        if(health > maxHealth) health = maxHealth;
        time++;
    }
    return health <= 0 ? -1 : health;
}