#include <string>
#include <vector>
#include <iostream>
#include <set>
using namespace std;

void  comb(int start, int cnt, vector<int> numbers);

int selected[2] = {};
set<int> ansSet;
vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    comb(0,0, numbers);
    for(int i : ansSet) answer.push_back(i);
    return answer;
}

void comb(int start, int cnt, vector<int> numbers){
    if(cnt == 2){
        ansSet.insert(selected[0] + selected[1]);
        return;
    }
    for(int i=start; i<numbers.size(); i++){
        selected[cnt] = numbers[i];
        comb(i+1, cnt+1, numbers);
    }
}