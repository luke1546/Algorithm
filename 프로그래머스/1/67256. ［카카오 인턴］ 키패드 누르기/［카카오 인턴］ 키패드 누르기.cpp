#include <string>
#include <vector>
#include <unordered_map>
#include <cmath>
using namespace std;

int getD(pair<int, int> p1, pair<int, int> p2){
    return abs(p1.first - p2.first) + abs(p1.second - p2.second);
}

string solution(vector<int> numbers, string hand) {
    string answer = "";
    unordered_map<char, pair<int, int>> um;
    um['*'] = {0,0};
    um['0'] = {0,1};
    um['#'] = {0,2};
    um['7'] = {1,0};
    um['8'] = {1,1};
    um['9'] = {1,2};
    um['4'] = {2,0};
    um['5'] = {2,1};
    um['6'] = {2,2};
    um['1'] = {3,0};
    um['2'] = {3,1};
    um['3'] = {3,2};
    char left = '*';
    char right = '#';
    int ld = 0, rd = 0;
    for(auto i : numbers){
        switch(i){
            case 1:
            case 4:
            case 7:
                answer+="L";
                left = i+'0';
                break;
            case 3:
            case 6:
            case 9:
                answer+="R";
                right = i+'0';
                break;
            default:
                ld = getD(um[i+'0'],um[left]);
                rd = getD(um[i+'0'],um[right]);
                if(ld == rd){
                    if(hand == "right"){
                        right = i+'0';
                        answer+="R";
                    }else{
                        left = i+'0';
                        answer+="L";
                    }
                }else{
                    if(ld > rd){
                        right = i+'0';
                        answer+="R";
                    }else{
                        left = i+'0';
                        answer+="L";
                    }
                }
        }
    }
    return answer;
}