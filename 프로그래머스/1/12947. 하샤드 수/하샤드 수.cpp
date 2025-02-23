#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    int y = x;
    int sum = 0;
    while(y){
        sum += y%10;
        y/=10;
    }
    return !(x%sum);
}