#include <string>
#include <vector>
#include <sstream>

using namespace std;

string solution(string s) {
    ostringstream oss;
    if(s.size()&1) oss << s[s.size()/2];
    else oss << s[s.size()/2-1] << s[s.size()/2];
    return oss.str();
}