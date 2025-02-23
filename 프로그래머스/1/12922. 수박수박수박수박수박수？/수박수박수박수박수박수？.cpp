#include <string>
#include <vector>
#include <sstream>

using namespace std;

string solution(int n) {
    ostringstream oss;
    bool f = false;
    for(int i=0; i<n; i++){
        f=!f;
        oss << (f ? "수" : "박");
    }
    return oss.str();
}