#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int getN(vector<int>& arr, vector<int>& v){
    vector<int> temp;
    int from = v[0]-1;
    int to = v[1]-1;
    int k = v[2]-1;
    for(int i=from; i<=to; i++)
        temp.push_back(arr[i]);
    sort(temp.begin(), temp.end());
    return temp[k];
}

vector<int> solution(vector<int> array, vector<vector<int>> commands) {
    vector<int> answer;
    for(auto v : commands)
        answer.push_back(getN(array,v));
    return answer;
}