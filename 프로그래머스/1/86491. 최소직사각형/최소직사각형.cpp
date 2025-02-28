#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> sizes) {
    int mi = 0, ma = 0;
    for(auto vec : sizes){
        mi = max(mi, min(vec[0], vec[1]));
        ma = max(ma, max(vec[0], vec[1]));
    }
    return ma*mi;
}