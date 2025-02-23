#include <string>
#include <vector>
#include <sstream>
using namespace std;

string solution(vector<string> seoul) {
    ostringstream oss;
    for(int i=0; i<seoul.size(); i++) {
        if(seoul[i] == "Kim") 
            oss << "김서방은 " << i << "에 있다";
    }
    return oss.str();
}