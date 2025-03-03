#include <string>
#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

bool compare(const vector<double>& v1, const vector<double>& v2){
    return v1[0] == v2[0] ? v1[1] < v2[1] : v1[0] > v2[0];
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<double> v(N+1);
    vector<double> prefix(N+1);
    vector<vector<double>> result(N, vector<double>(2));
    for(int i : stages){
        v[i-1]++;
        prefix[i-1]++;
    }
    for(int i=prefix.size()-1; i>0; i--)
        prefix[i-1]+=prefix[i];
    for(int i=0; i<prefix.size()-1; i++){
        if(prefix[i] == 0) result[i][0] = 0;
        else result[i][0] = v[i]/prefix[i];
        result[i][1] = i+1;
    }
    sort(result.begin(), result.end(), compare);
    for(auto v : result) answer.push_back(v[1]);
    return answer;
}