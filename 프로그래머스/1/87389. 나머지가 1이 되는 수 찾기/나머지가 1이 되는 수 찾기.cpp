#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int i = 0;
    while(n%++i!=1);
    return i;
}