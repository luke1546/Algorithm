#include <string>
#include <vector>
#include <iostream>
using namespace std;

int dp[100001];
int fibo(int n){
    if(n==0) return 0;
    if(dp[n] != 0) return dp[n]%1234567;
    return dp[n] = (fibo(n-2)%1234567 + fibo(n-1)%1234567)%1234567;
}

int solution(int n) {
    dp[1] = 1;
    return fibo(n);
}