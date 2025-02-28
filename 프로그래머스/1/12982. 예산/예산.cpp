#include <iostream>
#include <algorithm>
#include <vector>

using namespace std;

int solution(vector<int> d, int budget) {
    sort(d.begin(), d.end());
    int ans = 0;
    for(int i : d){
        budget-=i;
        ans++;
        if(budget<0) break;
    }
    return budget < 0 ? --ans : ans;
}