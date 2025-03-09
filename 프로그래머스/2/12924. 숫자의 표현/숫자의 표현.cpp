#include <string>
#include <vector>

using namespace std;

int solution(int n) {
    int answer = 1, sum = 1;
    for(int i=2; i<=146; i++){
        sum+=i;
        if((n-sum) >= 0 && (n-sum) % i == 0) answer++;
    }
    return answer;
}