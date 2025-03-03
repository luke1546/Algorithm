#include <string>
#include <vector>

using namespace std;

int solution(int n, int m, vector<int> section) {
    int answer = 0;
    int cover = -1;
    for(int i : section){
        if(i > cover){
            answer++;
            cover = i+m-1;
        }
    }
    return answer;
}