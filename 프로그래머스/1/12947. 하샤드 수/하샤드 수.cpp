#include <string>
#include <vector>

using namespace std;

int digitSum(int x){
    int n=0;
    while(x){
        n+=x%10;
        x/=10;
    }
    return n;
}

bool solution(int x) {
    return !(x % digitSum(x));
}