#include <string>
#include <vector>

using namespace std;

string solution(int a, int b) {
    int sum = 0;
    string ans = "";
    vector<int> month = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    for(int i=0; i<a-1; i++){
        sum += month[i];
    }
    sum = sum+b-1;
    sum%=7;
    if(sum == 0) ans = "FRI";
    if(sum == 1) ans = "SAT";
    if(sum == 2) ans = "SUN";
    if(sum == 3) ans = "MON";
    if(sum == 4) ans = "TUE";
    if(sum == 5) ans = "WED";
    if(sum == 6) ans = "THU";
    return ans;
}