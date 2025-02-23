#include <string>
#include <vector>
#include <iostream>
#include <regex>

using namespace std;

bool solution(string s) {
    bool flag = false;
    if(s.size() == 4 || s.size() == 6) flag = true;
    regex pattern("[0-9]+");
    string rs = regex_replace(s, pattern, "");
    cout << rs;
    return rs.empty() && flag;
}