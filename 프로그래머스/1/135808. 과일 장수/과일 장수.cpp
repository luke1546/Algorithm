#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int solution(int k, int m, vector<int> score) {
    int answer = 0;
    sort(score.begin(), score.end(), greater<int>());
    int index = m-1;
    while(index < score.size()){
        answer+=(score[index] * m);
        index+=m;
    }
    return answer;
}