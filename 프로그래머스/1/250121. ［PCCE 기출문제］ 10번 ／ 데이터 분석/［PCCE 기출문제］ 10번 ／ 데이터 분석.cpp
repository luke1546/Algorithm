#include <string>
#include <vector>
#include <unordered_map>
#include <algorithm>
#include <iostream>
using namespace std;

vector<vector<int>> solution(vector<vector<int>> data, string ext, int val_ext, string sort_by) {
    vector<vector<int>> answer;
    unordered_map<string, int> um;
    um["date"] = 1;
    um["maximum"] = 2;
    um["remain"] = 3;
    for(auto v : data)
        if(v[um[ext]] < val_ext) answer.push_back(v);
    sort(answer.begin(), answer.end(), [&](vector<int> v1, vector<int> v2){
       return v1[um[sort_by]] < v2[um[sort_by]];
    });
    return answer;
}