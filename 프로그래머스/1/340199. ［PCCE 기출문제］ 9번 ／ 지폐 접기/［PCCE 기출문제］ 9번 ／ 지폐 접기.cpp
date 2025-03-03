#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool 집어넣기(vector<int> wallet, vector<int> bill){
    int walletMax = max(wallet[0], wallet[1]);
    int walletMin = min(wallet[0], wallet[1]);
    int billMax = max(bill[0], bill[1]);
    int billMin = min(bill[0], bill[1]);
    if(walletMax >= billMax && walletMin >= billMin) return true;
    return false;
}

void fold(vector<int>& bill){
    bill[0] > bill[1] ? bill[0]/=2 : bill[1]/=2;
}

int solution(vector<int> wallet, vector<int> bill) {
    int answer = 0;
    while(!집어넣기(wallet, bill)){
        fold(bill);
        answer++;
    }
    return answer;
}