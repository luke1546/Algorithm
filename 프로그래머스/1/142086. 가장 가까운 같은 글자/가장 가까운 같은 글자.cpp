#include <string>
#include <vector>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    int arr[26];
    fill(arr, arr+26, -1);
    
    for(int i=0; i<s.size(); i++){
        int index = s[i]-'a';
        if(arr[index] == -1){
            answer.push_back(-1);
        }else{
            answer.push_back(i-arr[index]);
        }
        arr[index] = i;
    }
    return answer;
}