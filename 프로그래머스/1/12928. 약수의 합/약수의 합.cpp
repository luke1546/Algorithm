#include <string>
#include <vector>

using namespace std;

int 약수구하기(int n){
    int value = 0;
    for(int i=1; i<=n; i++){
        if(n%i==0) value+=i;
    }
    return value;
}

int solution(int n) {
    int answer = 약수구하기(n);
    return answer;
}