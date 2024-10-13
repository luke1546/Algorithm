#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    vector<int> v;
    while(n){
        v.push_back(n%10);
        n/=10;
    }
    sort(v.begin(), v.end(), [](int o1, int o2) {
        return o1>o2;
    });
    for(int i : v) answer = answer*10 + i;
    return answer;
}