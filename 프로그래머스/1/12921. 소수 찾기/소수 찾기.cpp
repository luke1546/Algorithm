#include <string>
#include <vector>
#include <cmath>
#include <iostream>

using namespace std;

int solution(int n) {
    int ans = 0;
    bool arr[1000001] = {};
    for(int i=2; i<=sqrt(n); i++){
        for(int j=i*2; j<=n; j+=i){
            arr[j] = true;
        }
    }
    for(int i=2; i<=n; i++){
        if(!arr[i]) ans++;
    }
    return ans;
}