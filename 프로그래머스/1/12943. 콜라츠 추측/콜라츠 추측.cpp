#include <string>
#include <vector>

using namespace std;

int solution(int num) {
    int cnt = 0;
    long long n = num;
    while(n!=1){
        if(cnt == 500) break;
        if(n&1) n = n*3+1;
        else n/=2;
        cnt++;
    }
    return cnt == 500 ? -1 : cnt;
}