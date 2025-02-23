#include <string>
#include <vector>

using namespace std;

int solution(int num) {
    int count = 0;
    long long n = num;
    while(n != 1 && count < 500){
        if(n&1) n = n*3+1;
        else n/=2;
        count++;
    }
    return count >= 500 ? -1 : count;
}