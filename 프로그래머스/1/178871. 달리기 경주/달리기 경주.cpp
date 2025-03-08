#include <string>
#include <vector>
#include <map>
#include <unordered_map>
using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    vector<string> answer;
    unordered_map<string, int> nameToRank;
    map<int, string> rankToName;
    for(int i=0; i<players.size(); i++) {
        nameToRank[players[i]] = i;
        rankToName[i] = players[i];
    }
    for(string s : callings){
        int 앞사람등수 = nameToRank[s]-1;
        string 앞사람 = rankToName[앞사람등수];
        nameToRank[s]--;
        nameToRank[앞사람]++;
        rankToName[앞사람등수+1] = 앞사람;
        rankToName[앞사람등수] = s;
    }
    for(auto p : rankToName) answer.push_back(p.second);
    return answer;
}