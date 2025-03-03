#include <string>
#include <vector>
#include <iostream>
using namespace std;

int 약수(int n){
    if(n == 1) return 1;
    int count = 0;
    for(int i=1; i<=n/2; i++){
        if(n%i==0) count++;
    }
    return count+1;
}

int solution(int number, int limit, int power) {
    int answer = 0;
    for(int i=1; i<=number; i++){
        int x = 약수(i);
        if(x > limit) x = power;
        answer+=x;
    }
    return answer;
}
