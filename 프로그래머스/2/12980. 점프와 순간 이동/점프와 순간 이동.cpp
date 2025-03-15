#include <iostream>
using namespace std;

void half(int& n){
    while(!(n&1)){
        n/=2;
    }
}

int solution(int n)
{
    int ans = 0;
    while(n){
        if(n&1){
            ans++;
            n--;
        }else half(n);
    }
    return ans;
}