#include <string>
#include <vector>

using namespace std;

int solution(vector<int> numbers) {
    int n = 45;
    for(int i=0; i<numbers.size(); i++) n-=numbers[i];
    return n;
}