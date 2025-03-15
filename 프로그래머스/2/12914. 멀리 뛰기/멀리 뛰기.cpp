#include <string>
#include <vector>

using namespace std;
long long dp[2001];

long long jump(int n){
    if(n == 0) return 0;
    if(dp[n] != 0) return dp[n];
    return dp[n] = (jump(n-1)%1234567 + jump(n-2)%1234567)%1234567;
}

long long solution(int n) {
    long long answer = 0;
    dp[1] = 1;
    dp[2] = 2;
    return jump(n);
}